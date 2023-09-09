package com.configuration.rest.dto;

import java.util.Set;

public class SubscriptionPropertyDTO {
	private String id;
	private Long connectorMetadataId;
	private Set<String> values;
	private String subscriptionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getConnectorMetadataId() {
		return connectorMetadataId;
	}

	public void setConnectorMetadataId(Long connectorMetadataId) {
		this.connectorMetadataId = connectorMetadataId;
	}

	public Set<String> getValues() {
		return values;
	}

	public void setValues(Set<String> values) {
		this.values = values;
	}

	public String getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	@Override
	public String toString() {
		return "JpaSubscriptionPropertyDTO [id=" + id + ", connectorMetadataId=" + connectorMetadataId + ", values="
				+ values + ", subscriptionId=" + subscriptionId + "]";
	}

}
