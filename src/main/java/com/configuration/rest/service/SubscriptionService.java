package com.configuration.rest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.rest.dto.SubscriptionDTO;
import com.configuration.rest.mapper.SubscriptionMapper;
import com.configuration.rest.mapper.SubscriptionPropertyMapper;
import com.storage.jpa.JpaSubscription;
import com.storage.jpa.JpaSubscriptionProperty;
import com.storage.repository.JpaSubscriptionRepository;

@Service
public class SubscriptionService {

	@Autowired
	private JpaSubscriptionRepository subscriptionRepository;

	@Autowired
	private SubscriptionMapper subscriptionMapper;

	@Autowired
	private SubscriptionPropertyMapper propertyMapper;

	public List<SubscriptionDTO> getAllSubscriptions() {
		List<JpaSubscription> subscriptions = subscriptionRepository.findAll();
		return subscriptions.stream().map(subscriptionMapper::toDto).collect(Collectors.toList());
	}

	public Optional<SubscriptionDTO> getSubscriptionById(Long id) {
		Optional<JpaSubscription> subscriptionOptional = subscriptionRepository.findById(id);
		return subscriptionOptional.map(subscriptionMapper::toDto);
	}

	public SubscriptionDTO createSubscription(SubscriptionDTO subscriptionDTO) {
		JpaSubscription subscription = subscriptionMapper.toEntity(subscriptionDTO);
		for (JpaSubscriptionProperty property : subscription.getProperties()) {
			property.setSubscription(subscription);

		}
		JpaSubscription savedSubscription = subscriptionRepository.save(subscription);
		return subscriptionMapper.toDto(savedSubscription);
	}

	public SubscriptionDTO updateSubscription(Long id, SubscriptionDTO updatedSubscriptionDTO) {
		if (!subscriptionRepository.existsById(id)) {
			throw new EntityNotFoundException("Subscription not found with ID: " + id);
		}

		JpaSubscription updatedSubscription = subscriptionMapper.toEntity(updatedSubscriptionDTO);
		updatedSubscription.setId(id);

		JpaSubscription existingSubscription = subscriptionRepository.getOne(id);

		// Update the properties collection with the existing properties, if any
		Set<JpaSubscriptionProperty> existingProperties = existingSubscription.getProperties();
		for (JpaSubscriptionProperty updatedProperty : updatedSubscription.getProperties()) {
			JpaSubscriptionProperty existingProperty = existingProperties.stream()
					.filter(property -> Objects.equals(property.getId(), updatedProperty.getId())).findFirst()
					.orElse(null);

			if (existingProperty != null) {
				updatedProperty.setSubscription(existingSubscription);
			}
		}

		JpaSubscription savedSubscription = subscriptionRepository.save(updatedSubscription);
		return subscriptionMapper.toDto(savedSubscription);
	}

	public void deleteSubscription(Long id) {
		if (!subscriptionRepository.existsById(id)) {
			throw new EntityNotFoundException("Subscription not found with ID: " + id);
		}
		subscriptionRepository.deleteById(id);
	}
}
