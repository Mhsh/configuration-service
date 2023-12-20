package com.configuration.rest.dto;

/**
 * Data Transfer Object (DTO) class representing a template. This class is used
 * to transfer template information between the controller and service layers.
 */
public class TemplateDTO extends BaseDTO{

	private String id;
	private String template;

	/**
	 * Get the ID of the template.
	 *
	 * @return The template ID.
	 */
	public String getId() {
		return id;
	}

	/**
	 * Set the ID of the template.
	 *
	 * @param id The template ID to set.
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Get the template content.
	 *
	 * @return The template content.
	 */
	public String getTemplate() {
		return template;
	}

	/**
	 * Set the template content.
	 *
	 * @param template The template content to set.
	 */
	public void setTemplate(String template) {
		this.template = template;
	}

	// Constructors, getters, and setters
}
