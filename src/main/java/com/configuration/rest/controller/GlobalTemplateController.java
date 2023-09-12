package com.configuration.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.SubscriptionTemplateDTO;
import com.configuration.rest.service.TemplateService;

/**
 * Controller class for managing templates through REST endpoints.
 */
@RestController
@RequestMapping("/bb/templates")
public class GlobalTemplateController {

	private final TemplateService templateService;

	/**
	 * Constructs a new TemplateController with the provided TemplateService.
	 *
	 * @param templateService The service responsible for template operations.
	 */
	public GlobalTemplateController(TemplateService templateService) {
		this.templateService = templateService;
	}

	/**
	 * Retrieves a template by its unique identifier.
	 *
	 * @param id The identifier of the template to retrieve.
	 * @return The TemplateDTO representing the retrieved template.
	 */
	@GetMapping("/{id}")
	public SubscriptionTemplateDTO getTemplateById(@PathVariable String id) {
		return templateService.getTemplateById(id);
	}

	/**
	 * Retrieves a list of all templates.
	 *
	 * @return A list of TemplateDTOs representing all available templates.
	 */
	@GetMapping
	public List<SubscriptionTemplateDTO> getAllTemplates() {
		return templateService.getAllTemplates();
	}

	/**
	 * Creates a new template using the provided TemplateDTO.
	 *
	 * @param templateDTO The TemplateDTO containing the data for the new template.
	 * @return The TemplateDTO representing the newly created template.
	 */
	@PostMapping
	public SubscriptionTemplateDTO createTemplate(@RequestBody SubscriptionTemplateDTO templateDTO) {
		return templateService.createTemplate(templateDTO);
	}

	/**
	 * Updates an existing template identified by its unique identifier.
	 *
	 * @param id                 The identifier of the template to update.
	 * @param updatedTemplateDTO The TemplateDTO containing the updated data for the
	 *                           template.
	 * @return The TemplateDTO representing the updated template.
	 */
	@PutMapping("/{id}")
	public SubscriptionTemplateDTO updateTemplate(@PathVariable String id,
			@RequestBody SubscriptionTemplateDTO updatedTemplateDTO) {
		return templateService.updateTemplate(id, updatedTemplateDTO);
	}

	/**
	 * Deletes a template by its unique identifier.
	 *
	 * @param id The identifier of the template to delete.
	 */
	@DeleteMapping("/{id}")
	public void deleteTemplate(@PathVariable String id) {
		templateService.deleteTemplate(id);
	}
}
