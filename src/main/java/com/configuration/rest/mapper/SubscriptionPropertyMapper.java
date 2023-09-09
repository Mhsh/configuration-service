package com.configuration.rest.mapper;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.SubscriptionPropertyDTO;
import com.storage.jpa.JpaConnectorMetadata;
import com.storage.jpa.JpaSubscriptionProperty;
import com.storage.repository.JpaConnectorMetadataRepository;

@Component
public class SubscriptionPropertyMapper {

	@Autowired
	private JpaConnectorMetadataRepository connectorMetadataRepository; // Your JpaConnector repository

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
