package com.configuration.rest.dto;

public class ClientDTO {

	private String id;
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "JpaClientDTO [id=" + id + ", description=" + description + "]";
	}

}
