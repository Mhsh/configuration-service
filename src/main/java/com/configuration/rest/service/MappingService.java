package com.configuration.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<MappingItemDTO> createMappings(Long subscriptionId, List<MappingItemDTO> mappingDTOs) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(subscriptionId);

		if (subscriptionOptional.isPresent()) {
			JpaSubscription subscription = subscriptionOptional.get();
			List<JpaMapping> mappingEntities = mappingDTOs.stream()
					.map(dto -> mappingMapper.toEntity(dto, subscription)).collect(Collectors.toList());
			List<JpaMapping> savedMappings = jpaMappingRepository.saveAll(mappingEntities);
			return savedMappings.stream().map(mappingMapper::toDTO).collect(Collectors.toList());
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
	public MappingItemDTO getMapping(Long mappingId) {
		Optional<JpaMapping> mappingOptional = jpaMappingRepository.findById(mappingId);

		if (mappingOptional.isPresent()) {
			JpaMapping mapping = mappingOptional.get();
			return mappingMapper.toDTO(mapping);
		} else {
			throw new EntityNotFoundException("Mapping not found with ID: " + mappingId);
		}
	}

	/**
	 * Retrieves all mappings for a given subscription.
	 *
	 * @param subscriptionId The ID of the subscription for which mappings are
	 *                       retrieved.
	 * @return A list of mapping DTOs for the specified subscription.
	 * @throws EntityNotFoundException If the subscription with the given ID is not
	 *                                 found.
	 */
	public List<MappingItemDTO> getAllMappings(Long subscriptionId) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(subscriptionId);

		if (subscriptionOptional.isPresent()) {
			JpaSubscription subscription = subscriptionOptional.get();
			List<JpaMapping> mappings = jpaMappingRepository.findBySubscription(subscription);
			return mappings.stream().map(mappingMapper::toDTO).collect(Collectors.toList());
		} else {
			throw new EntityNotFoundException("Subscription not found with ID: " + subscriptionId);
		}
	}

	/**
	 * Updates an existing mapping by its ID.
	 *
	 * @param mappingId         The ID of the mapping to update.
	 * @param updatedMappingDTO The updated mapping DTO.
	 * @return The updated mapping DTO if it exists, or throws an exception if not
	 *         found.
	 * @throws EntityNotFoundException If the mapping with the given ID is not
	 *                                 found.
	 */
	public MappingItemDTO updateMapping(Long mappingId, MappingItemDTO updatedMappingDTO) {
		Optional<JpaMapping> mappingOptional = jpaMappingRepository.findById(mappingId);

		if (mappingOptional.isPresent()) {
			JpaMapping existingMapping = mappingOptional.get();
			JpaMapping updatedMapping = mappingMapper.toEntity(updatedMappingDTO, existingMapping.getSubscription());
			updatedMapping.setId(mappingId);
			JpaMapping savedMapping = jpaMappingRepository.save(updatedMapping);
			return mappingMapper.toDTO(savedMapping);
		} else {
			throw new EntityNotFoundException("Mapping not found with ID: " + mappingId);
		}
	}

	/**
	 * Deletes a mapping by its ID.
	 *
	 * @param mappingId The ID of the mapping to delete.
	 * @throws EntityNotFoundException If the mapping with the given ID is not
	 *                                 found.
	 */
	public void deleteMapping(Long mappingId) {
		if (!jpaMappingRepository.existsById(mappingId)) {
			throw new EntityNotFoundException("Mapping not found with ID: " + mappingId);
		}
		jpaMappingRepository.deleteById(mappingId);
	}
}
