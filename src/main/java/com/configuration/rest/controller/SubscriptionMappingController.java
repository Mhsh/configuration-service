package com.configuration.rest.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.MappingDTO;
import com.configuration.rest.dto.MappingItemDTO;
import com.configuration.rest.service.MappingService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * REST Controller for managing mappings associated with subscriptions. This
 * controller provides endpoints for creating, retrieving, updating, and
 * deleting mappings.
 */
@RestController
@RequestMapping("/subscription/{subscriptionId}/mappings")
public class SubscriptionMappingController {

	@Autowired
	private MappingService mappingService;

	/**
	 * Create new mappings for a subscription.
	 *
	 * @param subscriptionId The ID of the subscription.
	 * @param mappingDTOs    A list of mapping data transfer objects.
	 * @return A ResponseEntity containing the created mappings and HTTP status code
	 *         201 (Created).
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(tags = { "SubscriptionMapping" })
	public ResponseEntity<MappingDTO> createMappings(@PathVariable UUID subscriptionId,
			@RequestBody List<MappingItemDTO> mappingDTOs) {
		MappingDTO createdMappings = mappingService.createMappings(subscriptionId, mappingDTOs);
		return new ResponseEntity<>(createdMappings, HttpStatus.CREATED);
	}

	/**
	 * Get all mappings associated with a subscription.
	 *
	 * @param subscriptionId The ID of the subscription.
	 * @return A ResponseEntity containing a list of mappings and HTTP status code
	 *         200 (OK).
	 */
	@GetMapping
	@Operation(tags = { "SubscriptionMapping" })
	public ResponseEntity<MappingDTO> getAllMappings(@PathVariable UUID subscriptionId) {
		MappingDTO mappings = mappingService.getMappingBySubscription(subscriptionId);
		return new ResponseEntity<>(mappings, HttpStatus.OK);
	}

	/**
	 * Delete a mapping by its ID.
	 *
	 * @param subscriptionId The ID of the subscription.
	 * @param mappingId      The ID of the mapping to delete.
	 * @return A ResponseEntity with HTTP status code 204 (No Content) indicating a
	 *         successful deletion.
	 */
	@DeleteMapping
	@Operation(tags = { "SubscriptionMapping" })
	public ResponseEntity<Void> deleteMapping(@PathVariable UUID subscriptionId) {
		mappingService.deleteMappingBySubscription(subscriptionId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
