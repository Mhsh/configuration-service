package com.configuration.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storage.jpa.JpaConnectorMetadata;
import com.storage.repository.JpaConnectorMetadataRepository;

@Service
public class ConnectorMetadataService {

	@Autowired
	private JpaConnectorMetadataRepository connectorMetadataRepository;

	public JpaConnectorMetadata createConnectorMetadata(JpaConnectorMetadata connectorMetadata) {
		return connectorMetadataRepository.save(connectorMetadata);
	}

	public JpaConnectorMetadata getConnectorMetadataById(Long id) {
		return connectorMetadataRepository.findById(id).orElse(null);
	}

	public JpaConnectorMetadata updateConnectorMetadata(Long id, JpaConnectorMetadata connectorMetadata) {
		if (connectorMetadataRepository.existsById(id)) {
			connectorMetadata.setId(id);
			return connectorMetadataRepository.save(connectorMetadata);
		}
		return null;
	}

	public boolean deleteConnectorMetadata(Long id) {
		if (connectorMetadataRepository.existsById(id)) {
			connectorMetadataRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
