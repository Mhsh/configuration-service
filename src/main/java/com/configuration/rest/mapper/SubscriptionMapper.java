package com.configuration.rest.mapper;

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

/**
 * Mapper class responsible for mapping between {@link JpaSubscription} entities
 * and {@link SubscriptionDTO} data transfer objects. This class provides
 * methods to convert entities to DTOs and vice versa.
 */
@Component
public class SubscriptionMapper {

	@Autowired
	private JpaClientRepository clientRepository; // Your JpaClient repository

	@Autowired
	private JpaConnectorRepository connectorRepository; // Your JpaConnector repository

	/**
	 * Converts a {@link JpaSubscription} entity to a {@link SubscriptionDTO}.
	 *
	 * @param subscription The JpaSubscription entity to be converted.
	 * @return The corresponding SubscriptionDTO.
	 */
	public SubscriptionDTO toDto(JpaSubscription subscription) {
		SubscriptionDTO dto = new SubscriptionDTO();
		dto.setId(subscription.getId().toString());
		dto.setClientId(subscription.getClient().getId());
		dto.setConnectorId(subscription.getConnector().getId().toString());
		// Map other fields as needed
		return dto;
	}

	/**
	 * Converts a {@link SubscriptionDTO} to a {@link JpaSubscription} entity.
	 *
	 * @param dto The SubscriptionDTO to be converted.
	 * @return The corresponding JpaSubscription entity.
	 * @throws EntityNotFoundException If the referenced client or connector is not
	 *                                 found in the database.
	 */
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
		// Map other fields as needed
		return subscription;
	}
}
