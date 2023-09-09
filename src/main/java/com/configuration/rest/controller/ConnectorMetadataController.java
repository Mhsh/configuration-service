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

@RestController
@RequestMapping("/connectorMetadata")
public class ConnectorMetadataController {

	@Autowired
	private ConnectorMetadataService connectorMetadataService;

	@PostMapping
	public ResponseEntity<JpaConnectorMetadata> createConnectorMetadata(
			@RequestBody JpaConnectorMetadata connectorMetadata) {
		JpaConnectorMetadata createdConnectorMetadata = connectorMetadataService
				.createConnectorMetadata(connectorMetadata);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdConnectorMetadata);
	}

	@GetMapping("/{id}")
	public ResponseEntity<JpaConnectorMetadata> getConnectorMetadataById(@PathVariable Long id) {
		JpaConnectorMetadata connectorMetadata = connectorMetadataService.getConnectorMetadataById(id);
		if (connectorMetadata != null) {
			return ResponseEntity.ok(connectorMetadata);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

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
