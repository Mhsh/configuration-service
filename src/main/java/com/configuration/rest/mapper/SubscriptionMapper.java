package com.configuration.rest.mapper;

import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.SubscriptionDTO;
import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.JpaClient;
import com.storage.jpa.JpaConnector;
import com.storage.jpa.JpaSubscription;
import com.storage.repository.JpaClientRepository;
import com.storage.repository.JpaConnectorRepository;

@Component
public class SubscriptionMapper {
	@Autowired
	private SubscriptionPropertyMapper propertyMapper;

	@Autowired
	private JpaClientRepository clientRepository; // Your JpaClient repository

	@Autowired
	private JpaConnectorRepository connectorRepository; // Your JpaConnector repository

	public SubscriptionDTO toDto(JpaSubscription subscription) {
		SubscriptionDTO dto = new SubscriptionDTO();
		dto.setId(subscription.getId().toString());
		dto.setClientId(subscription.getClient().getId());
		dto.setConnectorId(subscription.getConnector().getId().toString());
		dto.setProperties(subscription.getProperties().stream().map(propertyMapper::toDto).collect(Collectors.toSet()));
		dto.setLocation(subscription.getLocation());
		dto.setDuration(subscription.getDuration());
		dto.setNextSchedule(subscription.getNextSchedule());
		// Map other fields as needed
		return dto;
	}

	public JpaSubscription toEntity(SubscriptionDTO dto) {
		JpaSubscription subscription = new JpaSubscription();
		// Note: You may need to handle id conversion if needed

		// Load client and connector entities from the database based on their IDs
		JpaClient client = clientRepository.findById(dto.getClientId())
				.orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + dto.getClientId()));

		JpaConnector connector = connectorRepository.findById(ConnectorType.valueOf(dto.getConnectorId()))
				.orElseThrow(() -> new EntityNotFoundException("Connector not found with ID: " + dto.getConnectorId()));

		// Set the client and connector in the subscription
		subscription.setClient(client);
		subscription.setConnector(connector);

		subscription
				.setProperties(dto.getProperties().stream().map(propertyMapper::toEntity).collect(Collectors.toSet()));
		subscription.setLocation(dto.getLocation());
		subscription.setDuration(dto.getDuration());
		subscription.setNextSchedule(dto.getNextSchedule());
		// Map other fields as needed
		return subscription;
	}
}
