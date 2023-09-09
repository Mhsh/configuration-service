package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ClientDTO;
import com.storage.jpa.JpaClient;

@Component
public class ClientMapper {

	public ClientDTO toDto(JpaClient client) {
		ClientDTO dto = new ClientDTO();
		dto.setId(client.getId());
		dto.setDescription(client.getDescription());
		return dto;
	}

	public JpaClient toEntity(ClientDTO dto) {
		JpaClient client = new JpaClient();
		client.setId(dto.getId());
		client.setDescription(dto.getDescription());
		return client;
	}
}
