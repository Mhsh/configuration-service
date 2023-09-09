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

import com.configuration.rest.dto.SubscriptionDTO;
import com.configuration.rest.service.SubscriptionService;

@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	@GetMapping
	public List<SubscriptionDTO> getAllSubscriptions() {
		return subscriptionService.getAllSubscriptions();
	}

	@GetMapping("/{id}")
	public Optional<SubscriptionDTO> getSubscriptionById(@PathVariable Long id) {
		return subscriptionService.getSubscriptionById(id);
	}

	@PostMapping
	public SubscriptionDTO createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
		return subscriptionService.createSubscription(subscriptionDTO);
	}

	@PutMapping("/{id}")
	public SubscriptionDTO updateSubscription(@PathVariable Long id,
			@RequestBody SubscriptionDTO updatedSubscriptionDTO) {
		return subscriptionService.updateSubscription(id, updatedSubscriptionDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteSubscription(@PathVariable Long id) {
		subscriptionService.deleteSubscription(id);
	}
}
