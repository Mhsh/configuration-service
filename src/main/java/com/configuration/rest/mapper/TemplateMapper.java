package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.TemplateDTO;
import com.storage.jpa.JpaTemplate;

/**
 * Mapper class responsible for mapping between {@link JpaTemplate} entities and
 * {@link TemplateDTO} data transfer objects. This class provides methods to
 * convert entities to DTOs and vice versa.
 */
@Component
public class TemplateMapper {

	/**
	 * Converts a {@link JpaTemplate} entity to a {@link TemplateDTO}.
	 *
	 * @param template The JpaTemplate entity to be converted.
	 * @return The corresponding TemplateDTO.
	 */
	public TemplateDTO toDto(JpaTemplate template) {
		TemplateDTO dto = new TemplateDTO();
		dto.setId(template.getId());
		dto.setTemplate(template.getTemplate());
		dto.setCreated(template.getCreatedDate());
		dto.setUpdated(template.getUpdatedDate());
		return dto;
	}

	/**
	 * Converts a {@link TemplateDTO} to a {@link JpaTemplate} entity.
	 *
	 * @param dto The TemplateDTO to be converted.
	 * @return The corresponding JpaTemplate entity.
	 */
	public JpaTemplate toEntity(TemplateDTO dto) {
		JpaTemplate template = new JpaTemplate();
		template.setId(dto.getId());
		template.setTemplate(dto.getTemplate());
		return template;
	}
}
