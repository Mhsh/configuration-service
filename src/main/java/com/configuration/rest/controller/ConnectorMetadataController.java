package com.configuration.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.service.ConnectorMetadataService;
import com.storage.jpa.JpaConnectorMetadata;

/**
 * REST Controller for managing connector metadata operations. This controller
 * provides endpoints for creating, retrieving, updating, and deleting connector
 * metadata.
 */
@RestController
@RequestMapping("/connectorMetadata")
public class ConnectorMetadataController {

	@Autowired
	private ConnectorMetadataService connectorMetadataService;

	/**
	 * Create a new connector metadata.
	 *
	 * @param connectorMetadata The connector metadata to create.
	 * @return A ResponseEntity containing the created connector metadata and HTTP
	 *         status code 201 (Created).
	 */
	@PostMapping
	public ResponseEntity<JpaConnectorMetadata> createConnectorMetadata(
			@RequestBody JpaConnectorMetadata connectorMetadata) {
		JpaConnectorMetadata createdConnectorMetadata = connectorMetadataService
				.createConnectorMetadata(connectorMetadata);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdConnectorMetadata);
	}

	/**
	 * Get connector metadata by its ID.
	 *
	 * @param id The ID of the connector metadata to retrieve.
	 * @return A ResponseEntity containing the retrieved connector metadata and HTTP
	 *         status code 200 (OK) if found, or HTTP status code 404 (Not Found) if
	 *         not found.
	 */
	@GetMapping("/{id}")
	public ResponseEntity<JpaConnectorMetadata> getConnectorMetadataById(@PathVariable Long id) {
		JpaConnectorMetadata connectorMetadata = connectorMetadataService.getConnectorMetadataById(id);
		if (connectorMetadata != null) {
			return ResponseEntity.ok(connectorMetadata);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Update an existing connector metadata by its ID.
	 *
	 * @param id                The ID of the connector metadata to update.
	 * @param connectorMetadata The updated connector metadata.
	 * @return A ResponseEntity containing the updated connector metadata and HTTP
	 *         status code 200 (OK) if updated, or HTTP status code 404 (Not Found)
	 *         if the original metadata was not found.
	 */
	@PutMapping("/{id}")
	public ResponseEntity<JpaConnectorMetadata> updateConnectorMetadata(@PathVariable Long id,
			@RequestBody JpaConnectorMetadata connectorMetadata) {
		JpaConnectorMetadata updatedConnectorMetadata = connectorMetadataService.updateConnectorMetadata(id,
				connectorMetadata);
		if (updatedConnectorMetadata != null) {
			return ResponseEntity.ok(updatedConnectorMetadata);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Delete connector metadata by its ID.
	 *
	 * @param id The ID of the connector metadata to delete.
	 * @return A ResponseEntity with HTTP status code 204 (No Content) if deleted,
	 *         or HTTP status code 404 (Not Found) if the metadata was not found.
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteConnectorMetadata(@PathVariable Long id) {
		boolean deleted = connectorMetadataService.deleteConnectorMetadata(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
