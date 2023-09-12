package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ClientTemplateDTO;
import com.storage.jpa.JpaClientTemplate;

/**
 * Mapper class responsible for converting between {@link JpaClientTemplate}
 * entities and {@link ClientTemplateDTO} Data Transfer Objects (DTOs).
 */
@Component
public class ClientTemplateMapper {

	/**
	 * Converts a {@link JpaClientTemplate} entity to a {@link ClientTemplateDTO}
	 * DTO.
	 *
	 * @param entity The {@link JpaClientTemplate} entity to be converted.
	 * @return A {@link ClientTemplateDTO} DTO representing the converted entity.
	 */
	public ClientTemplateDTO toDTO(JpaClientTemplate entity) {
		ClientTemplateDTO dto = new ClientTemplateDTO();
		dto.setId(entity.getId());
		dto.setTemplate(entity.getTemplate());
		return dto;
	}

	/**
	 * Converts a {@link ClientTemplateDTO} DTO to a {@link JpaClientTemplate}
	 * entity.
	 *
	 * @param dto The {@link ClientTemplateDTO} DTO to be converted.
	 * @return A {@link JpaClientTemplate} entity representing the converted DTO.
	 */
	public JpaClientTemplate toEntity(ClientTemplateDTO dto) {
		JpaClientTemplate entity = new JpaClientTemplate();
		entity.setId(dto.getId());
		entity.setTemplate(dto.getTemplate());
		return entity;
	}
}
