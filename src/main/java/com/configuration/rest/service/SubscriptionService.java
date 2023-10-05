package com.configuration.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.rest.dto.SubscriptionDTO;
import com.configuration.rest.mapper.SubscriptionMapper;
import com.storage.jpa.JpaSubscription;
import com.storage.repository.JpaSubscriptionRepository;

/**
 * Service class responsible for handling operations related to subscriptions.
 * This class provides methods to create, retrieve, update, and delete
 * subscription entities.
 */
@Service
public class SubscriptionService {

	@Autowired
	private JpaSubscriptionRepository subscriptionRepository;

	@Autowired
	private SubscriptionMapper subscriptionMapper;

	/**
	 * Retrieves all subscriptions.
	 *
	 * @return A list of all subscription DTOs.
	 */
	public List<SubscriptionDTO> getAllSubscriptions() {
		List<JpaSubscription> subscriptions = subscriptionRepository.findAll();
		return subscriptions.stream().map(subscriptionMapper::toDto).collect(Collectors.toList());
	}

	/**
	 * Retrieves a subscription by its ID.
	 *
	 * @param id The ID of the subscription to retrieve.
	 * @return The subscription DTO if found, or an empty optional if not found.
	 */
	public Optional<SubscriptionDTO> getSubscriptionById(Long id) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(id);
		return subscriptionOptional.map(subscriptionMapper::toDto);
	}

	/**
	 * Creates a new subscription.
	 *
	 * @param subscriptionDTO The subscription DTO to be created.
	 * @return The created subscription DTO.
	 */
	public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
		JpaSubscription subscription = subscriptionMapper.toEntity(subscriptionDTO);
		JpaSubscription savedSubscription = subscriptionRepository.save(subscription);
		return subscriptionMapper.toDto(savedSubscription);
	}

	/**
	 * Updates an existing subscription by its ID.
	 *
	 * @param id                     The ID of the subscription to update.
	 * @param updatedSubscriptionDTO The updated subscription DTO.
	 * @return The updated subscription DTO if it exists.
	 * @throws EntityNotFoundException If the subscription with the given ID is not
	 *                                 found.
	 */
	public SubscriptionDTO updateSubscription(Long id, SubscriptionDTO updatedSubscriptionDTO) {
		if (!subscriptionRepository.existsById(id)) {
			throw new EntityNotFoundException("Subscription not found with ID: " + id);
		}
		JpaSubscription updatedSubscription = subscriptionMapper.toEntity(updatedSubscriptionDTO);
		updatedSubscription.setId(id);
		JpaSubscription savedSubscription = subscriptionRepository.save(updatedSubscription);
		return subscriptionMapper.toDto(savedSubscription);
	}

	/**
	 * Deletes a subscription by its ID.
	 *
	 * @param id The ID of the subscription to delete.
	 * @throws EntityNotFoundException If the subscription with the given ID is not
	 *                                 found.
	 */
	public void deleteSubscription(Long id) {
		if (!subscriptionRepository.existsById(id)) {
			throw new EntityNotFoundException("Subscription not found with ID: " + id);
		}
		subscriptionRepository.deleteById(id);
	}
}
