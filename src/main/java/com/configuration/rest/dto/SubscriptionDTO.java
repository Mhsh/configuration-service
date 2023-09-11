package com.configuration.rest.dto;

import java.util.Date;
import java.util.Set;

/**
 * Data Transfer Object (DTO) class representing a subscription. This class is
 * used to transfer subscription information between the controller and service
 * layers.
 */
public class SubscriptionDTO {

	private String id;
	private String clientId; // You can use the client ID as a reference
	private String connectorId; // You can use the connector ID as a reference
	private Set<SubscriptionPropertyDTO> properties;
	private Integer duration;
	private Date nextSchedule;

	/**
	 * Get the ID of the subscription.
	 *
	 * @return The subscription ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the ID of the subscription.
	 *
	 * @param id The subscription ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the ID of the client associated with this subscription.
	 *
	 * @return The client ID.
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Set the ID of the client associated with this subscription.
	 *
	 * @param clientId The client ID to set.
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Get the ID of the connector associated with this subscription.
	 *
	 * @return The connector ID.
	 */
	public String getConnectorId() {
		return connectorId;
	}

	/**
	 * Set the ID of the connector associated with this subscription.
	 *
	 * @param connectorId The connector ID to set.
	 */
	public void setConnectorId(String connectorId) {
		this.connectorId = connectorId;
	}

	/**
	 * Get the set of properties associated with this subscription.
	 *
	 * @return The subscription properties.
	 */
	public Set<SubscriptionPropertyDTO> getProperties() {
		return properties;
	}

	/**
	 * Set the properties associated with this subscription.
	 *
	 * @param properties The subscription properties to set.
	 */
	public void setProperties(Set<SubscriptionPropertyDTO> properties) {
		this.properties = properties;
	}

	/**
	 * Get the duration of the subscription.
	 *
	 * @return The subscription duration.
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * Set the duration of the subscription.
	 *
	 * @param duration The subscription duration to set.
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * Get the next scheduled date for the subscription.
	 *
	 * @return The next scheduled date.
	 */
	public Date getNextSchedule() {
		return nextSchedule;
	}

	/**
	 * Set the next scheduled date for the subscription.
	 *
	 * @param nextSchedule The next scheduled date to set.
	 */
	public void setNextSchedule(Date nextSchedule) {
		this.nextSchedule = nextSchedule;
	}
}
