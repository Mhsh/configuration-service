package com.configuration.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.rest.dto.MappingDTO;
import com.configuration.rest.dto.MappingItemDTO;
import com.configuration.rest.mapper.MappingMapper;
import com.storage.jpa.JpaMapping;
import com.storage.jpa.JpaSubscription;
import com.storage.repository.JpaMappingRepository;
import com.storage.repository.JpaSubscriptionRepository;

/**
 * Service class responsible for handling operations related to mappings. This
 * class provides methods to create, retrieve, update, and delete mapping
 * entities.
 */
@Service
public class MappingService {

	@Autowired
	private JpaMappingRepository jpaMappingRepository;

	@Autowired
	private MappingMapper mappingMapper;

	@Autowired
	private JpaSubscriptionRepository subscriptionRepository;

	/**
	 * Creates mappings for a given subscription.
	 *
	 * @param subscriptionId The ID of the subscription for which mappings are
	 *                       created.
	 * @param mappingDTOs    The list of mapping DTOs to be created.
	 * @return A list of created mapping DTOs.
	 * @throws EntityNotFoundException If the subscription with the given ID is not
	 *                                 found.
	 */
	public MappingDTO createMappings(Long subscriptionId, List<MappingItemDTO> mappingDTOs) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(subscriptionId);

		if (subscriptionOptional.isPresent()) {
			JpaSubscription subscription = subscriptionOptional.get();
			List<JpaMapping> mappingEntities = mappingDTOs.stream()
					.map(dto -> mappingMapper.toEntity(dto, subscription)).collect(Collectors.toList());
			List<JpaMapping> savedMappings = jpaMappingRepository.saveAll(mappingEntities);
			return createMappingDTO(savedMappings.stream().map(mappingMapper::toDTO).collect(Collectors.toList()),
					subscriptionId);
		} else {
			throw new EntityNotFoundException("Subscription not found with ID: " + subscriptionId);
		}
	}

	/**
	 * Retrieves a mapping by its ID.
	 *
	 * @param mappingId The ID of the mapping to retrieve.
	 * @return The mapping DTO if found, or throws an exception if not found.
	 * @throws EntityNotFoundException If the mapping with the given ID is not
	 *                                 found.
	 */
	public MappingDTO getMappingBySubscription(Long subscriptionId) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(subscriptionId);

		if (subscriptionOptional.isPresent()) {
			JpaSubscription subscription = subscriptionOptional.get();
			List<JpaMapping> mappings = jpaMappingRepository.findBySubscription(subscription);
			return createMappingDTO(mappings.stream().map(mappingMapper::toDTO).collect(Collectors.toList()),
					subscriptionId);
		} else {
			throw new EntityNotFoundException("Subscription not found with ID: " + subscriptionId);
		}
	}

	/**
	 * Deletes a mapping by its ID.
	 *
	 * @param mappingId The ID of the mapping to delete.
	 * @throws EntityNotFoundException If the mapping with the given ID is not
	 *                                 found.
	 */
	public void deleteMappingBySubscription(Long subscriptionId) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(subscriptionId);

		if (subscriptionOptional.isPresent()) {
			jpaMappingRepository.deleteBySubscription(subscriptionOptional.get());
		} else {
			throw new EntityNotFoundException("Subscription not found with ID: " + subscriptionId);
		}
	}

	private MappingDTO createMappingDTO(List<MappingItemDTO> mappingItems, Long subscriptionId) {
		MappingDTO mappingDTO = new MappingDTO();
		mappingDTO.setMappings(mappingItems);
		mappingDTO.setSubscriptionId(subscriptionId);
		return mappingDTO;
	}
}
