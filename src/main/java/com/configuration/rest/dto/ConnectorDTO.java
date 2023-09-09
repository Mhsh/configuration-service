package com.configuration.rest.dto;

import java.util.Set;

import com.storage.jpa.Enums.ConnectorType;
import com.storage.jpa.Enums.FileType;

public class ConnectorDTO {
	private ConnectorType id;
	private String description;
	private FileType fileType;
	private Set<ConnectorMetadataDTO> metadata;

	public ConnectorType getId() {
		return id;
	}

	public void setId(ConnectorType id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FileType getFileType() {
		return fileType;
	}

	public void setFileType(FileType fileType) {
		this.fileType = fileType;
	}

	public Set<ConnectorMetadataDTO> getMetadata() {
		return metadata;
	}

	public void setMetadata(Set<ConnectorMetadataDTO> metadata) {
		this.metadata = metadata;
	}

	@Override
	public String toString() {
		return "ConnectorDTO [id=" + id + ", description=" + description + ", fileType=" + fileType + ", metadata="
				+ metadata + "]";
	}

}
