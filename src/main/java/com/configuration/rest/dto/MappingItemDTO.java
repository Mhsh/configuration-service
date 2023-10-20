package com.configuration.rest.dto;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) class representing a mapping item. This class is
 * used to transfer mapping item information between the controller and service
 * layers.
 */
public class MappingItemDTO extends BaseDTO{

	private String sourcekey;
	private String internalkey;
	private String type;
	private UUID subscriptionId;

	/**
	 * Get the source key of the mapping item.
	 *
	 * @return The source key.
	 */
	public String getSourcekey() {
		return sourcekey;
	}

	/**
	 * Set the source key of the mapping item.
	 *
	 * @param sourcekey The source key to set.
	 */
	public void setSourcekey(String sourcekey) {
		this.sourcekey = sourcekey;
	}

	/**
	 * Get the internal key of the mapping item.
	 *
	 * @return The internal key.
	 */
	public String getInternalkey() {
		return internalkey;
	}

	/**
	 * Set the internal key of the mapping item.
	 *
	 * @param internalkey The internal key to set.
	 */
	public void setInternalkey(String internalkey) {
		this.internalkey = internalkey;
	}

	/**
	 * Get the type of the mapping item.
	 *
	 * @return The mapping item type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * Set the type of the mapping item.
	 *
	 * @param type The mapping item type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the subscriptionId
	 */
	public UUID getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * @param subscriptionId the subscriptionId to set
	 */
	public void setSubscriptionId(UUID subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

}
