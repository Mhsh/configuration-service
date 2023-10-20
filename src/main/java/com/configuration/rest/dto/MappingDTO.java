package com.configuration.rest.dto;

import java.util.List;
import java.util.UUID;

/**
 * Data Transfer Object (DTO) class representing mappings for a subscription.
 * This class is used to transfer mapping information between the controller and
 * service layers.
 */
public class MappingDTO extends BaseDTO{

	private UUID subscriptionId;
	private List<MappingItemDTO> mappings;

	/**
	 * Get the ID of the subscription associated with the mappings.
	 *
	 * @return The subscription's ID.
	 */
	public UUID getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * Set the ID of the subscription associated with the mappings.
	 *
	 * @param subscriptionId The subscription's ID to set.
	 */
	public void setSubscriptionId(UUID subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	/**
	 * Get the list of mapping items.
	 *
	 * @return The list of mapping items.
	 */
	public List<MappingItemDTO> getMappings() {
		return mappings;
	}

	/**
	 * Set the list of mapping items.
	 *
	 * @param mappings The list of mapping items to set.
	 */
	public void setMappings(List<MappingItemDTO> mappings) {
		this.mappings = mappings;
	}
}
