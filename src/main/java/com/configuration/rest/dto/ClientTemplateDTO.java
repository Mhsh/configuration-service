package com.configuration.rest.dto;

/**
 * A Data Transfer Object (DTO) representing a client template with its unique
 * identifier (ID) and a JSON template.
 */
public class ClientTemplateDTO {

	/**
	 * The unique identifier for the client template.
	 */
	private Long id;

	/**
	 * The JSON template stored as a string.
	 */
	private String template;

	/**
	 * Get the unique identifier for the client template.
	 *
	 * @return The ID of the client template.
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier for the client template.
	 *
	 * @param id The ID of the client template.
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Get the JSON template stored as a string.
	 *
	 * @return The JSON template.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Set the JSON template stored as a string.
	 *
	 * @param template The JSON template.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}
}
