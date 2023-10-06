package com.configuration.rest.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ConnectorDTO;
import com.storage.jpa.JpaConnector;

/**
 * Mapper class responsible for mapping between {@link JpaConnector} entities
 * and {@link ConnectorDTO} data transfer objects. This class provides methods
 * to convert entities to DTOs and vice versa.
 */
@Component
public class ConnectorMapper {

	@Autowired
	private ConnectorMetadataMapper metadataMapper;

	/**
	 * Converts a {@link JpaConnector} entity to a {@link ConnectorDTO}.
	 *
	 * @param connector The JPA connector entity to be converted.
	 * @return The corresponding ConnectorDTO.
	 */
	public ConnectorDTO toDto(JpaConnector connector) {
		ConnectorDTO dto = new ConnectorDTO();
		dto.setId(connector.getId());
		dto.setDescription(connector.getDescription());
		dto.setFileType(connector.getFileType());
		dto.setMetadata(connector.getMetadata().stream().map(metadataMapper::toDto).collect(Collectors.toSet()));
		dto.setCreated(connector.getCreatedDate());
		dto.setUpdated(connector.getUpdatedDate());
		// Map other fields as needed
		return dto;
	}

	/**
	 * Converts a {@link ConnectorDTO} to a {@link JpaConnector} entity.
	 *
	 * @param dto The ConnectorDTO to be converted.
	 * @return The corresponding JpaConnector entity.
	 */
	public JpaConnector toEntity(ConnectorDTO dto) {
		JpaConnector connector = new JpaConnector();
		// Note: You may need to handle id conversion if needed
		connector.setId(dto.getId());
		connector.setDescription(dto.getDescription());
		connector.setFileType(dto.getFileType());
		connector.setMetadata(dto.getMetadata().stream().map(metadataMapper::toEntity).collect(Collectors.toSet()));
		// Map other fields as needed
		return connector;
	}
}
