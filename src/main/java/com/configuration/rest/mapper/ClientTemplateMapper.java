package com.configuration.rest.mapper;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ClientTemplateDTO;
import com.storage.jpa.JpaClient;
import com.storage.jpa.JpaClientTemplate;
import com.storage.repository.JpaClientRepository;

/**
 * Mapper class responsible for converting between {@link JpaClientTemplate}
 * entities and {@link ClientTemplateDTO} Data Transfer Objects (DTOs).
 */
@Component
public class ClientTemplateMapper {

	@Autowired
	private JpaClientRepository clientRepository; // Your JpaClient repository

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
		dto.setCreated(entity.getCreatedDate());
		dto.setUpdated(entity.getUpdatedDate());
		return dto;
	}

	/**
	 * Converts a {@link ClientTemplateDTO} DTO to a {@link JpaClientTemplate}
	 * entity.
	 *
	 * @param dto The {@link ClientTemplateDTO} DTO to be converted.
	 * @return A {@link JpaClientTemplate} entity representing the converted DTO.
	 */
	public JpaClientTemplate toEntity(ClientTemplateDTO dto, String clientId) {
		JpaClientTemplate entity = new JpaClientTemplate();
		JpaClient client = clientRepository.findById(clientId)
				.orElseThrow(() -> new EntityNotFoundException("Client not found with ID: " + clientId));
		entity.setTemplate(dto.getTemplate());
		// Load client and connector entities from the database based on their IDs
		
		entity.setClient(client);
		return entity;
	}
}
