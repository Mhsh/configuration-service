package com.configuration.rest.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.configuration.rest.dto.TemplateDTO;
import com.configuration.rest.mapper.TemplateMapper;
import com.storage.jpa.JpaTemplate;
import com.storage.repository.JpaTemplateRepository;

/**
 * Service class responsible for managing templates. This class provides methods
 * to create, retrieve, update, and delete templates.
 */
@Service
public class TemplateService {

	private final JpaTemplateRepository templateRepository;
	private final TemplateMapper templateMapper;

	/**
	 * Constructs a new TemplateService with the specified template repository and
	 * mapper.
	 *
	 * @param templateRepository The JpaTemplateRepository used to interact with
	 *                           template data.
	 * @param templateMapper     The TemplateMapper used for mapping between DTOs
	 *                           and entities.
	 */
	public TemplateService(JpaTemplateRepository templateRepository, TemplateMapper templateMapper) {
		this.templateRepository = templateRepository;
		this.templateMapper = templateMapper;
	}

	/**
	 * Retrieves all templates.
	 *
	 * @return A list of all template DTOs.
	 */
	public List<TemplateDTO> getAllTemplates() {
		List<JpaTemplate> templates = templateRepository.findAll();
		return templates.stream().map(templateMapper::toDto).collect(Collectors.toList());
	}

	/**
	 * Retrieves a template by its ID.
	 *
	 * @param id The ID of the template to retrieve.
	 * @return The template DTO if found, or null if not found.
	 */
	public TemplateDTO getTemplateById(String id) {
		JpaTemplate template = templateRepository.findById(id).orElse(null);
		return (template != null) ? templateMapper.toDto(template) : null;
	}

	/**
	 * Creates a new template.
	 *
	 * @param templateDTO The template DTO to be created.
	 * @return The created template DTO.
	 */
	public TemplateDTO createTemplate(TemplateDTO templateDTO) {
		JpaTemplate template = templateMapper.toEntity(templateDTO);
		template = templateRepository.save(template);
		return templateMapper.toDto(template);
	}

	/**
	 * Updates an existing template by its ID.
	 *
	 * @param id                 The ID of the template to update.
	 * @param updatedTemplateDTO The updated template DTO.
	 * @return The updated template DTO if it exists, or null if the template with
	 *         the given ID is not found.
	 */
	public TemplateDTO updateTemplate(String id, TemplateDTO updatedTemplateDTO) {
		JpaTemplate existingTemplate = templateRepository.findById(id).orElse(null);
		if (existingTemplate != null) {
			JpaTemplate updatedTemplate = templateMapper.toEntity(updatedTemplateDTO);
			updatedTemplate.setId(id);
			updatedTemplate = templateRepository.save(updatedTemplate);
			return templateMapper.toDto(updatedTemplate);
		}
		return null;
	}

	/**
	 * Deletes a template by its ID.
	 *
	 * @param id The ID of the template to delete.
	 */
	public void deleteTemplate(String id) {
		templateRepository.deleteById(id);
	}
}
