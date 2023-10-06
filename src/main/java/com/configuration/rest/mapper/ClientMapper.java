package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ClientDTO;
import com.storage.jpa.JpaClient;

/**
 * Mapper class responsible for mapping between {@link JpaClient} entities and
 * {@link ClientDTO} data transfer objects. This class provides methods to
 * convert entities to DTOs and vice versa.
 */
@Component
public class ClientMapper {

	/**
	 * Converts a {@link JpaClient} entity to a {@link ClientDTO}.
	 *
	 * @param client The JPA client entity to be converted.
	 * @return The corresponding ClientDTO.
	 */
	public ClientDTO toDto(JpaClient client) {
		ClientDTO dto = new ClientDTO();
		dto.setId(client.getId());
		dto.setDescription(client.getDescription());
		dto.setCreated(client.getCreatedDate());
		dto.setUpdated(client.getUpdatedDate());
		return dto;
	}

	/**
	 * Converts a {@link ClientDTO} to a {@link JpaClient} entity.
	 *
	 * @param dto The ClientDTO to be converted.
	 * @return The corresponding JpaClient entity.
	 */
	public JpaClient toEntity(ClientDTO dto) {
		JpaClient client = new JpaClient();
		client.setId(dto.getId());
		client.setDescription(dto.getDescription());
		return client;
	}
}
