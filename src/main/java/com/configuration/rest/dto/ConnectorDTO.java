package com.configuration.rest.dto;

import java.util.Set;

import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.Enums.FileType;

/**
 * Data Transfer Object (DTO) class representing a connector. This class is used
 * to transfer connector information between the controller and service layers.
 */
public class ConnectorDTO extends BaseDTO{

	private ConnectorType id;
	private String description;
	private FileType fileType;
	private Set<ConnectorMetadataDTO> metadata;

	/**
	 * Get the ID of the connector.
	 *
	 * @return The connector's ID.
	 */
	public ConnectorType getId() {
		return id;
	}

	/**
	 * Set the ID of the connector.
	 *
	 * @param id The connector's ID to set.
	 */
	public void setId(ConnectorType id) {
		this.id = id;
	}

	/**
	 * Get the description of the connector.
	 *
	 * @return The connector's description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Set the description of the connector.
	 *
	 * @param description The connector's description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Get the file type associated with the connector.
	 *
	 * @return The connector's file type.
	 */
	public FileType getFileType() {
		return fileType;
	}

	/**
	 * Set the file type associated with the connector.
	 *
	 * @param fileType The connector's file type to set.
	 */
	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	/**
	 * Get the metadata associated with the connector.
	 *
	 * @return A Set of ConnectorMetadataDTO objects representing the connector's
	 *         metadata.
	 */
	public Set<ConnectorMetadataDTO> getMetadata() {
		return metadata;
	}

	/**
	 * Set the metadata associated with the connector.
	 *
	 * @param metadata A Set of ConnectorMetadataDTO objects to set as the
	 *                 connector's metadata.
	 */
	public void setMetadata(Set<ConnectorMetadataDTO> metadata) {
		this.metadata = metadata;
	}

	/**
	 * Generate a string representation of the ConnectorDTO object.
	 *
	 * @return A string containing the connector's ID, description, file type, and
	 *         metadata.
	 */
	@Override
	public String toString() {
		return "ConnectorDTO [id=" + id + ", description=" + description + ", fileType=" + fileType + ", metadata="
				+ metadata + "]";
	}
}
