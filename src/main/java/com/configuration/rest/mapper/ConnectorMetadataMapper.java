package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ConnectorDTO;
import com.configuration.rest.dto.ConnectorMetadataDTO;
import com.storage.jpa.JpaConnector;
import com.storage.jpa.JpaConnectorMetadata;

@Component
public class ConnectorMetadataMapper {

	public ConnectorMetadataDTO toDto(JpaConnectorMetadata connector) {
		ConnectorMetadataDTO dto = new ConnectorMetadataDTO();
		dto.setId(connector.getId());
		dto.setKey(connector.getKey());
		dto.setMultiValued(connector.isMultiValued());
		// Map other fields as needed
		return dto;
	}

	public JpaConnectorMetadata toEntity(ConnectorMetadataDTO dto) {
		JpaConnectorMetadata connector = new JpaConnectorMetadata();
		connector.setId(dto.getId());
		connector.setKey(dto.getKey());
		connector.setMultiValued(dto.isMultiValued());
		// Map other fields as needed
		return connector;
	}
}
