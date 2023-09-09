package com.configuration.rest.mapper;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ConnectorDTO;
import com.storage.jpa.JpaConnector;

@Component
public class ConnectorMapper {

	@Autowired
	private ConnectorMetadataMapper metadataMapper;

	public ConnectorDTO toDto(JpaConnector connector) {
		ConnectorDTO dto = new ConnectorDTO();
		dto.setId(connector.getId());
		dto.setDescription(connector.getDescription());
		dto.setFileType(connector.getFileType());
		dto.setMetadata(connector.getMetadata().stream().map(metadataMapper::toDto).collect(Collectors.toSet()));
		// Map other fields as needed
		return dto;
	}

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
