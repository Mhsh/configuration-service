package com.configuration.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.ConnectorDTO;
import com.configuration.rest.service.ConnectorService;

/**
 * REST Controller for managing connector operations. This controller provides
 * endpoints for creating, retrieving, updating, and deleting connectors.
 */
@RestController
@RequestMapping("/connector")
public class ConnectorController {

	@Autowired
	private ConnectorService connectorService;

	/**
	 * Get a list of all connectors.
	 *
	 * @return A list of ConnectorDTOs representing all connectors.
	 */
	@GetMapping
	public List<ConnectorDTO> getAllConnectors() {
		return connectorService.getAllConnectors();
	}

	/**
	 * Get a connector by its ID.
	 *
	 * @param id The ID of the connector to retrieve.
	 * @return An Optional containing the retrieved ConnectorDTO if found, or an
	 *         empty Optional if not found.
	 */
	@GetMapping("/{id}")
	public Optional<ConnectorDTO> getConnectorById(@PathVariable String id) {
		return connectorService.getConnectorById(id);
	}

	/**
	 * Create a new connector.
	 *
	 * @param connectorDTO The ConnectorDTO representing the connector to create.
	 * @return The created ConnectorDTO.
	 */
	@PostMapping
	public ConnectorDTO createConnector(@RequestBody ConnectorDTO connectorDTO) {
		return connectorService.createConnector(connectorDTO);
	}

	/**
	 * Update an existing connector by its ID.
	 *
	 * @param id                  The ID of the connector to update.
	 * @param updatedConnectorDTO The updated ConnectorDTO.
	 * @return The updated ConnectorDTO if updated, or null if the original
	 *         connector was not found.
	 */
	@PutMapping("/{id}")
	public ConnectorDTO updateConnector(@PathVariable String id, @RequestBody ConnectorDTO updatedConnectorDTO) {
		return connectorService.updateConnector(id, updatedConnectorDTO);
	}

	/**
	 * Delete a connector by its ID.
	 *
	 * @param id The ID of the connector to delete.
	 */
	@DeleteMapping("/{id}")
	public void deleteConnector(@PathVariable String id) {
		connectorService.deleteConnector(id);
	}
}
