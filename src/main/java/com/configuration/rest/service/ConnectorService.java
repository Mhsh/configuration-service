package com.configuration.rest.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.rest.dto.ConnectorDTO;
import com.configuration.rest.mapper.ConnectorMapper;
import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.JpaConnector;
import com.storage.jpa.JpaConnectorMetadata;
import com.storage.repository.JpaConnectorRepository;

/**
 * Service class responsible for handling operations related to connectors.
 * This class provides methods to create, retrieve, update, and delete connector entities.
 */
@Service
public class ConnectorService {

    @Autowired
    private JpaConnectorRepository connectorRepository;

    @Autowired
    private ConnectorMapper connectorMapper;

    /**
     * Retrieves all connectors.
     *
     * @return A list of all connector DTOs.
     */
    public List<ConnectorDTO> getAllConnectors() {
        List<JpaConnector> connectors = connectorRepository.findAll();
        return connectors.stream().map(connectorMapper::toDto).collect(Collectors.toList());
    }

    /**
     * Retrieves a connector by its ID.
     *
     * @param id The ID of the connector to retrieve.
     * @return The connector DTO if found, or an empty optional if not found.
     */
    public Optional<ConnectorDTO> getConnectorById(String id) {
        // Note: You may need to handle id conversion if needed
        Optional<JpaConnector> connectorOptional = connectorRepository.findById(ConnectorType.valueOf(id));
        return connectorOptional.map(connectorMapper::toDto);
    }

    /**
     * Creates a new connector.
     *
     * @param connectorDTO The connector DTO to be created.
     * @return The created connector DTO.
     */
    public ConnectorDTO createConnector(ConnectorDTO connectorDTO) {
        JpaConnector connector = connectorMapper.toEntity(connectorDTO);
        for (JpaConnectorMetadata metadata : connector.getMetadata()) {
            metadata.setConnector(connector);
        }
        JpaConnector savedConnector = connectorRepository.save(connector);
        return connectorMapper.toDto(savedConnector);
    }

    /**
     * Updates an existing connector by its ID.
     *
     * @param id                The ID of the connector to update.
     * @param updatedConnectorDTO The updated connector DTO.
     * @return The updated connector DTO if it exists, or throws an exception if not found.
     */
    public ConnectorDTO updateConnector(String id, ConnectorDTO updatedConnectorDTO) {
        // Note: You may need to handle id conversion if needed
        ConnectorType connectorType = ConnectorType.valueOf(id);
        if (!connectorRepository.existsById(connectorType)) {
            // Handle not found exception
            throw new EntityNotFoundException("Connector not found with ID: " + id);
        }

        JpaConnector updatedConnector = connectorMapper.toEntity(updatedConnectorDTO);
        updatedConnector.setId(connectorType);
        // Retrieve the existing connector from the database
        JpaConnector existingConnector = connectorRepository.getReferenceById(connectorType);

        // Update the metadata collection with the existing metadata, if any
        Set<JpaConnectorMetadata> existingMetadata = existingConnector.getMetadata();
        for (JpaConnectorMetadata updatedMetadata : updatedConnector.getMetadata()) {
            // Find the corresponding metadata in the existing collection
            JpaConnectorMetadata existingMetadataItem = existingMetadata.stream()
                    .filter(metadata -> Objects.equals(metadata.getId(), updatedMetadata.getId())).findFirst()
                    .orElse(null);

            if (existingMetadataItem != null) {
                // Set the connector reference from the existing metadata
                updatedMetadata.setConnector(existingConnector);
            }
        }

        // Save the updated connector entity (along with its metadata)
        JpaConnector savedConnector = connectorRepository.save(updatedConnector);

        // Convert the saved entity back to a DTO
        return connectorMapper.toDto(savedConnector);
    }

    /**
     * Deletes a connector by its ID.
     *
     * @param id The ID of the connector to delete.
     */
    public void deleteConnector(String id) {
        // Note: You may need to handle id conversion if needed
        ConnectorType connectorType = ConnectorType.valueOf(id);
        if (!connectorRepository.existsById(connectorType)) {
            // Handle not found exception
            throw new EntityNotFoundException("Connector not found with ID: " + id);
        }
        connectorRepository.deleteById(connectorType);
    }
}
