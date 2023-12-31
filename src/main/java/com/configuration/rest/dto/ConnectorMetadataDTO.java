package com.configuration.rest.dto;

import java.util.UUID;

/**
 * Data Transfer Object (DTO) class representing connector metadata. This class
 * is used to transfer connector metadata information between the controller and
 * service layers.
 */
public class ConnectorMetadataDTO extends BaseDTO {

	private UUID id;
	private String key;

	/**
	 * Get the ID of the connector metadata.
	 *
	 * @return The connector metadata's ID.
	 */
	public UUID getId() {
		return id;
	}

	/**
	 * Set the ID of the connector metadata.
	 *
	 * @param id The connector metadata's ID to set.
	 */
	public void setId(UUID id) {
		this.id = id;
	}

	/**
	 * Get the key of the connector metadata.
	 *
	 * @return The connector metadata's key.
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Set the key of the connector metadata.
	 *
	 * @param key The connector metadata's key to set.
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * Generate a string representation of the ConnectorMetadataDTO object.
	 *
	 * @return A string containing the connector metadata's ID, key, and
	 *         multi-valued flag.
	 */
	@Override
	public String toString() {
		return "ConnectorMetadataDTO [id=" + id + ", key=" + key + "]";
	}
}
