package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.SubscriptionTemplateDTO;
import com.storage.jpa.JpaTemplate;

/**
 * Mapper class responsible for mapping between {@link JpaTemplate} entities and
 * {@link SubscriptionTemplateDTO} data transfer objects. This class provides methods to
 * convert entities to DTOs and vice versa.
 */
@Component
public class SubscriptionTemplateMapper {

	/**
	 * Converts a {@link JpaTemplate} entity to a {@link SubscriptionTemplateDTO}.
	 *
	 * @param template The JpaTemplate entity to be converted.
	 * @return The corresponding TemplateDTO.
	 */
	public SubscriptionTemplateDTO toDto(JpaTemplate template) {
		SubscriptionTemplateDTO dto = new SubscriptionTemplateDTO();
		dto.setId(template.getId());
		dto.setTemplate(template.getTemplate());
		return dto;
	}

	/**
	 * Converts a {@link SubscriptionTemplateDTO} to a {@link JpaTemplate} entity.
	 *
	 * @param dto The TemplateDTO to be converted.
	 * @return The corresponding JpaTemplate entity.
	 */
	public JpaTemplate toEntity(SubscriptionTemplateDTO dto) {
		JpaTemplate template = new JpaTemplate();
		template.setId(dto.getId());
		template.setTemplate(dto.getTemplate());
		return template;
	}
}
