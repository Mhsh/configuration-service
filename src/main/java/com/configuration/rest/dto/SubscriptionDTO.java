package com.configuration.rest.dto;

/**
 * Data Transfer Object (DTO) class representing a subscription. This class is
 * used to transfer subscription information between the controller and service
 * layers.
 */
public class SubscriptionDTO extends BaseDTO{

	private String id;
	private String clientId; // You can use the client ID as a reference
	private String connectorId;

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

}
