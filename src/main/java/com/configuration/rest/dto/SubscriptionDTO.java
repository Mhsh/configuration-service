package com.configuration.rest.dto;

import java.util.Date;
import java.util.Set;

public class SubscriptionDTO {
	private String id;
	private String clientId; // You can use the client ID as a reference
	private String connectorId; // You can use the connector ID as a reference
	private Set<SubscriptionPropertyDTO> properties;
	private String location;
	private Integer duration;
	private Date nextSchedule;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getConnectorId() {
		return connectorId;
	}

	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
	}

	public Set<SubscriptionPropertyDTO> getProperties() {
		return properties;
	}

	public void setProperties(Set<SubscriptionPropertyDTO> properties) {
		this.properties = properties;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getNextSchedule() {
		return nextSchedule;
	}

	public void setNextSchedule(Date nextSchedule) {
		this.nextSchedule = nextSchedule;
	}

}
