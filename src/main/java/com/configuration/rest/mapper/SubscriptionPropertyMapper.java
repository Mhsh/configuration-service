package com.configuration.rest.mapper;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.SubscriptionPropertyDTO;
import com.storage.jpa.JpaConnectorMetadata;
import com.storage.jpa.JpaSubscriptionProperty;
import com.storage.repository.JpaConnectorMetadataRepository;

/**
 * Mapper class responsible for mapping between {@link JpaSubscriptionProperty}
 * entities and {@link SubscriptionPropertyDTO} data transfer objects. This
 * class provides methods to convert entities to DTOs and vice versa.
 */
@Component
public class SubscriptionPropertyMapper {

	@Autowired
	private JpaConnectorMetadataRepository connectorMetadataRepository; // Your JpaConnectorMetadata repository

	/**
	 * Converts a {@link JpaSubscriptionProperty} entity to a
	 * {@link SubscriptionPropertyDTO}.
	 *
	 * @param property The JpaSubscriptionProperty entity to be converted.
	 * @return The corresponding SubscriptionPropertyDTO.
	 */
	public SubscriptionPropertyDTO toDto(JpaSubscriptionProperty property) {
		SubscriptionPropertyDTO dto = new SubscriptionPropertyDTO();
		dto.setId(property.getId().toString());

		if (property.getConnectorMetadata() != null) {
			dto.setConnectorMetadataId(property.getConnectorMetadata().getId());
		}

		dto.setValues(property.getValues());

		if (property.getSubscription() != null) {
			dto.setSubscriptionId(property.getSubscription().getId().toString());
		}

		return dto;
	}

	/**
	 * Converts a {@link SubscriptionPropertyDTO} to a
	 * {@link JpaSubscriptionProperty} entity.
	 *
	 * @param dto The SubscriptionPropertyDTO to be converted.
	 * @return The corresponding JpaSubscriptionProperty entity.
	 * @throws EntityNotFoundException If the referenced connector metadata is not
	 *                                 found in the database.
	 */
	public JpaSubscriptionProperty toEntity(SubscriptionPropertyDTO dto) {
		JpaSubscriptionProperty property = new JpaSubscriptionProperty();
		property.setValues(dto.getValues());
		JpaConnectorMetadata connectorMetadata = connectorMetadataRepository.findById(dto.getConnectorMetadataId())
				.orElseThrow(() -> new EntityNotFoundException(
						"ConnectorMetadata not found with ID: " + dto.getConnectorMetadataId()));
		property.setConnectorMetadata(connectorMetadata);
		return property;
	}
}
