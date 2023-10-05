package com.configuration.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.SubscriptionDetailDTO;
import com.configuration.rest.service.SubscriptionDetailService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/subscription/{id}/details")
public class SubscriptionDetailController {

	private final SubscriptionDetailService subscriptionDetailService;

	public SubscriptionDetailController(SubscriptionDetailService subscriptionDetailService) {
		this.subscriptionDetailService = subscriptionDetailService;
	}

	@GetMapping
	@Operation(tags = { "SubscriptionDetail" })
	public List<SubscriptionDetailDTO> getAllSubscriptionDetails(@PathVariable Long id) {
		return subscriptionDetailService.getAllSubscriptionDetailsBySubscription(id);
	}

	@PostMapping
	@Operation(tags = { "SubscriptionDetail" })
	public ResponseEntity<SubscriptionDetailDTO> createSubscriptionDetail(
			@RequestBody SubscriptionDetailDTO subscriptionDetailDTO, @PathVariable Long id) {
		SubscriptionDetailDTO createdSubscriptionDetailDTO = subscriptionDetailService
				.createSubscriptionDetail(subscriptionDetailDTO, id);
		return ResponseEntity.ok(createdSubscriptionDetailDTO);
	}

	@PutMapping("/{id}")
	@Operation(tags = { "SubscriptionDetail" })
	public ResponseEntity<SubscriptionDetailDTO> updateSubscriptionDetail(@PathVariable Long id,
			@RequestBody SubscriptionDetailDTO subscriptionDetailDTO) {
		Optional<SubscriptionDetailDTO> updatedSubscriptionDetailDTO = subscriptionDetailService
				.updateSubscriptionDetail(id, subscriptionDetailDTO);
		return updatedSubscriptionDetailDTO.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	@Operation(tags = { "SubscriptionDetail" })
	public ResponseEntity<Void> deleteSubscriptionDetail(@PathVariable Long id) {
		boolean deleted = subscriptionDetailService.deleteSubscriptionDetail(id);
		if (deleted) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}