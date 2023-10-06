package com.configuration.rest.dto;

/**
 * Data Transfer Object (DTO) class representing a client. This class is used to
 * transfer client information between the controller and service layers.
 */
public class ClientDTO extends BaseDTO{

	private String id;
	private String description;

	/**
	 * Get the ID of the client.
	 *
	 * @return The client's ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the ID of the client.
	 *
	 * @param id The client's ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the description of the client.
	 *
	 * @return The client's description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the client.
	 *
	 * @param description The client's description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Generate a string representation of the ClientDTO object.
	 *
	 * @return A string containing the client's ID and description.
	 */
	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", description=" + description + "]";
	}
}
