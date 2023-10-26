package com.configuration.rest.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.ErrorDetailDTO;
import com.configuration.rest.service.ErrorDetailService;

@RestController
@RequestMapping("/error-details")
public class ErrorDetailController {

	private final ErrorDetailService errorDetailService;

	public ErrorDetailController(ErrorDetailService errorDetailService) {
		this.errorDetailService = errorDetailService;
	}

	@GetMapping
	public ResponseEntity<List<ErrorDetailDTO>> getAllErrorDetails() {
		List<ErrorDetailDTO> errorDetails = errorDetailService.getAllErrorDetails();
		return ResponseEntity.ok(errorDetails);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ErrorDetailDTO> getErrorDetailById(@PathVariable UUID id) {
		Optional<ErrorDetailDTO> errorDetail = errorDetailService.getErrorDetailById(id);
		return errorDetail.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/subscription/{subscriptionId}")
	public ResponseEntity<List<ErrorDetailDTO>> getErrorDetailBySubscription(@PathVariable UUID subscriptionId) {
		List<ErrorDetailDTO> errorDetails = errorDetailService.getErrorDetailBySubscription(subscriptionId);
		return ResponseEntity.ok(errorDetails);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Void> updateErrorDetail(@PathVariable UUID id,
			@Valid @RequestBody ErrorDetailDTO updatedErrorDetail) {
		boolean updated = errorDetailService.updateErrorDetail(id, updatedErrorDetail);
		return updated ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteErrorDetailById(@PathVariable UUID id) {
		errorDetailService.deleteErrorDetailById(id);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping("/subscription/{subscriptionId}")
	public ResponseEntity<Void> deleteErrorDetailBySubscription(@PathVariable UUID subscriptionId) {

		errorDetailService.deleteErrorDetailBySubscription(subscriptionId);
		return ResponseEntity.noContent().build();
	}
}
