package com.configuration.rest.dto;

import java.util.Set;

/**
 * Data Transfer Object (DTO) class representing subscription properties. This
 * class is used to transfer subscription property information between the
 * controller and service layers.
 */
public class SubscriptionPropertyDTO {

	private String id;
	private Long connectorMetadataId;
	private Set<String> values;
	private String subscriptionId;

	/**
	 * Get the ID of the subscription property.
	 *
	 * @return The subscription property ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the ID of the subscription property.
	 *
	 * @param id The subscription property ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the ID of the connector metadata associated with this property.
	 *
	 * @return The connector metadata ID.
	 */
	public Long getConnectorMetadataId() {
		return connectorMetadataId;
	}

	/**
	 * Set the ID of the connector metadata associated with this property.
	 *
	 * @param connectorMetadataId The connector metadata ID to set.
	 */
	public void setConnectorMetadataId(Long connectorMetadataId) {
		this.connectorMetadataId = connectorMetadataId;
	}

	/**
	 * Get the values associated with this subscription property.
	 *
	 * @return The subscription property values.
	 */
	public Set<String> getValues() {
		return values;
	}

	/**
	 * Set the values associated with this subscription property.
	 *
	 * @param values The subscription property values to set.
	 */
	public void setValues(Set<String> values) {
		this.values = values;
	}

	/**
	 * Get the ID of the subscription associated with this property.
	 *
	 * @return The subscription ID.
	 */
	public String getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * Set the ID of the subscription associated with this property.
	 *
	 * @param subscriptionId The subscription ID to set.
	 */
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@Override
	public String toString() {
		return "SubscriptionPropertyDTO [id=" + id + ", connectorMetadataId=" + connectorMetadataId + ", values="
				+ values + ", subscriptionId=" + subscriptionId + "]";
	}
}
