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

import io.swagger.v3.oas.annotations.Operation;

/**
 * Controller class for managing subscription entities through REST endpoints.
 */
@RestController
@RequestMapping("/subscription")
public class SubscriptionController {

	@Autowired
	private SubscriptionService subscriptionService;

	/**
	 * Retrieves a list of all subscriptions.
	 *
	 * @return A list of SubscriptionDTOs representing all available subscriptions.
	 */
	@GetMapping
	@Operation(tags = { "Subscription" })
	public List<SubscriptionDTO> getAllSubscriptions() {
		return subscriptionService.getAllSubscriptions();
	}

	/**
	 * Retrieves a subscription by its unique identifier.
	 *
	 * @param id The identifier of the subscription to retrieve.
	 * @return An Optional containing the SubscriptionDTO representing the retrieved
	 *         subscription, or empty if not found.
	 */
	@GetMapping("/{id}")
	@Operation(tags = { "Subscription" })
	public Optional<SubscriptionDTO> getSubscriptionById(@PathVariable Long id) {
		return subscriptionService.getSubscriptionById(id);
	}

	/**
	 * Creates a new subscription using the provided SubscriptionDTO.
	 *
	 * @param subscriptionDTO The SubscriptionDTO containing the data for the new
	 *                        subscription.
	 * @return The SubscriptionDTO representing the newly created subscription.
	 */
	@PostMapping
	@Operation(tags = { "Subscription" })
	public SubscriptionDTO createSubscription(@RequestBody SubscriptionDTO subscriptionDTO) {
		return subscriptionService.createSubscription(subscriptionDTO);
	}

	/**
	 * Updates an existing subscription identified by its unique identifier.
	 *
	 * @param id                     The identifier of the subscription to update.
	 * @param updatedSubscriptionDTO The SubscriptionDTO containing the updated data
	 *                               for the subscription.
	 * @return The SubscriptionDTO representing the updated subscription.
	 */
	@PutMapping("/{id}")
	@Operation(tags = { "Subscription" })
	public SubscriptionDTO updateSubscription(@PathVariable Long id,
			@RequestBody SubscriptionDTO updatedSubscriptionDTO) {
		return subscriptionService.updateSubscription(id, updatedSubscriptionDTO);
	}

	/**
	 * Deletes a subscription by its unique identifier.
	 *
	 * @param id The identifier of the subscription to delete.
	 */
	@DeleteMapping("/{id}")
	@Operation(tags = { "Subscription" })
	public void deleteSubscription(@PathVariable Long id) {
		subscriptionService.deleteSubscription(id);
	}
}
