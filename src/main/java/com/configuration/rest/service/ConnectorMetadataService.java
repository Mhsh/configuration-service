package com.configuration.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storage.jpa.JpaConnectorMetadata;
import com.storage.repository.JpaConnectorMetadataRepository;

/**
 * Service class responsible for handling operations related to connector
 * metadata. This class provides methods to create, retrieve, update, and delete
 * connector metadata entities.
 */
@Service
public class ConnectorMetadataService {

	@Autowired
	private JpaConnectorMetadataRepository connectorMetadataRepository;

	/**
	 * Creates a new connector metadata entity.
	 *
	 * @param connectorMetadata The connector metadata entity to be created.
	 * @return The created connector metadata entity.
	 */
	public JpaConnectorMetadata createConnectorMetadata(JpaConnectorMetadata connectorMetadata) {
		return connectorMetadataRepository.save(connectorMetadata);
	}

	/**
	 * Retrieves connector metadata by its ID.
	 *
	 * @param id The ID of the connector metadata to retrieve.
	 * @return The connector metadata entity if found, or null if not found.
	 */
	public JpaConnectorMetadata getConnectorMetadataById(Long id) {
		return connectorMetadataRepository.findById(id).orElse(null);
	}

	/**
	 * Updates an existing connector metadata entity by its ID.
	 *
	 * @param id                The ID of the connector metadata to update.
	 * @param connectorMetadata The updated connector metadata entity.
	 * @return The updated connector metadata entity if it exists, or null if not
	 *         found.
	 */
	public JpaConnectorMetadata updateConnectorMetadata(Long id, JpaConnectorMetadata connectorMetadata) {
		if (connectorMetadataRepository.existsById(id)) {
			connectorMetadata.setId(id);
			return connectorMetadataRepository.save(connectorMetadata);
		}
		return null;
	}

	/**
	 * Deletes connector metadata by its ID.
	 *
	 * @param id The ID of the connector metadata to delete.
	 * @return True if the connector metadata was deleted, or false if it was not
	 *         found.
	 */
	public boolean deleteConnectorMetadata(Long id) {
		if (connectorMetadataRepository.existsById(id)) {
			connectorMetadataRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
