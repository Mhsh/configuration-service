package com.configuration.rest.dto;

import java.util.List;

public class MappingDTO {
	private Long subscriptionId;
	private List<MappingItemDTO> mappings;

	public Long getSubscriptionId() {
		return subscriptionId;
	}

	public void setSubscriptionId(Long subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	public List<MappingItemDTO> getMappings() {
		return mappings;
	}

	public void setMappings(List<MappingItemDTO> mappings) {
		this.mappings = mappings;
	}

}