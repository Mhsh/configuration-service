package com.configuration.rest.dto;

/**
 * Data Transfer Object (DTO) class representing connector metadata. This class
 * is used to transfer connector metadata information between the controller and
 * service layers.
 */
public class ConnectorMetadataDTO extends BaseDTO{

	private Long id;
	private String key;
	private boolean multiValued;

	/**
	 * Get the ID of the connector metadata.
	 *
	 * @return The connector metadata's ID.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the ID of the connector metadata.
	 *
	 * @param id The connector metadata's ID to set.
	 */
	public void setId(Long id) {
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
	 * Check if the connector metadata is multi-valued.
	 *
	 * @return true if the connector metadata is multi-valued, false otherwise.
	 */
	public boolean isMultiValued() {
		return multiValued;
	}

	/**
	 * Set whether the connector metadata is multi-valued.
	 *
	 * @param multiValued true if the connector metadata is multi-valued, false
	 *                    otherwise.
	 */
	public void setMultiValued(boolean multiValued) {
		this.multiValued = multiValued;
	}

	/**
	 * Generate a string representation of the ConnectorMetadataDTO object.
	 *
	 * @return A string containing the connector metadata's ID, key, and
	 *         multi-valued flag.
	 */
	@Override
	public String toString() {
		return "ConnectorMetadataDTO [id=" + id + ", key=" + key + ", multiValued=" + multiValued + "]";
	}
}
