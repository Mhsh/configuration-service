package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ConnectorMetadataDTO;
import com.storage.jpa.JpaConnectorMetadata;

/**
 * Mapper class responsible for mapping between {@link JpaConnectorMetadata}
 * entities and {@link ConnectorMetadataDTO} data transfer objects. This class
 * provides methods to convert entities to DTOs and vice versa.
 */
@Component
public class ConnectorMetadataMapper {

	/**
	 * Converts a {@link JpaConnectorMetadata} entity to a
	 * {@link ConnectorMetadataDTO}.
	 *
	 * @param connector The JPA connector metadata entity to be converted.
	 * @return The corresponding ConnectorMetadataDTO.
	 */
	public ConnectorMetadataDTO toDto(JpaConnectorMetadata connector) {
		ConnectorMetadataDTO dto = new ConnectorMetadataDTO();
		dto.setId(connector.getId());
		dto.setKey(connector.getKey());
		dto.setMultiValued(connector.isMultiValued());
		// Map other fields as needed
		return dto;
	}

	/**
	 * Converts a {@link ConnectorMetadataDTO} to a {@link JpaConnectorMetadata}
	 * entity.
	 *
	 * @param dto The ConnectorMetadataDTO to be converted.
	 * @return The corresponding JpaConnectorMetadata entity.
	 */
	public JpaConnectorMetadata toEntity(ConnectorMetadataDTO dto) {
		JpaConnectorMetadata connector = new JpaConnectorMetadata();
		connector.setId(dto.getId());
		connector.setKey(dto.getKey());
		connector.setMultiValued(dto.isMultiValued());
		// Map other fields as needed
		return connector;
	}
}
