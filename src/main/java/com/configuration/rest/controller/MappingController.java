package com.configuration.rest.controller;

import java.util.List;

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

import com.configuration.rest.dto.MappingItemDTO;
import com.configuration.rest.service.MappingService;

@RestController
@RequestMapping("/subscriptions/{subscriptionId}/mappings")
public class MappingController {

	@Autowired
	private MappingService mappingService;

	@PostMapping
	public ResponseEntity<List<MappingItemDTO>> createMappings(@PathVariable Long subscriptionId,
			@RequestBody List<MappingItemDTO> mappingDTOs) {

		List<MappingItemDTO> createdMappings = mappingService.createMappings(subscriptionId, mappingDTOs);

		return new ResponseEntity<>(createdMappings, HttpStatus.CREATED);
	}

	@GetMapping("/{mappingId}")
	public ResponseEntity<MappingItemDTO> getMapping(@PathVariable Long subscriptionId, @PathVariable Long mappingId) {

		MappingItemDTO mapping = mappingService.getMapping(mappingId);
		return new ResponseEntity<>(mapping, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<MappingItemDTO>> getAllMappings(@PathVariable Long subscriptionId) {

		List<MappingItemDTO> mappings = mappingService.getAllMappings(subscriptionId);
		return new ResponseEntity<>(mappings, HttpStatus.OK);
	}

	@PutMapping("/{mappingId}")
	public ResponseEntity<MappingItemDTO> updateMapping(@PathVariable Long subscriptionId, @PathVariable Long mappingId,
			@RequestBody MappingItemDTO updatedMappingDTO) {

		MappingItemDTO updatedMapping = mappingService.updateMapping(mappingId, updatedMappingDTO);
		return new ResponseEntity<>(updatedMapping, HttpStatus.OK);
	}

	@DeleteMapping("/{mappingId}")
	public ResponseEntity<Void> deleteMapping(@PathVariable Long subscriptionId, @PathVariable Long mappingId) {

		mappingService.deleteMapping(mappingId);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
