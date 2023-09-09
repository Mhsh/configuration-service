package com.configuration.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.configuration.rest.dto.ClientDTO;
import com.configuration.rest.mapper.ClientMapper;
import com.storage.jpa.JpaClient;
import com.storage.repository.JpaClientRepository;

@Service
public class ClientService {

	@Autowired
	private JpaClientRepository clientRepository;

	@Autowired
	private ClientMapper clientMapper;

	public List<ClientDTO> getAllClients() {
		List<JpaClient> clients = clientRepository.findAll();
		return clients.stream().map(clientMapper::toDto).collect(Collectors.toList());
	}

	public Optional<ClientDTO> getClientById(String id) {
		Optional<JpaClient> clientOptional = clientRepository.findById(id);
		return clientOptional.map(clientMapper::toDto);
	}

	public ClientDTO createClient(ClientDTO clientDTO) {
		JpaClient client = clientMapper.toEntity(clientDTO);
		JpaClient savedClient = clientRepository.save(client);
		return clientMapper.toDto(savedClient);
	}

	public ClientDTO updateClient(String id, ClientDTO updatedClientDTO) {
		if (!clientRepository.existsById(id)) {
			// Handle not found exception
			throw new EntityNotFoundException("Client not found with ID: " + id);
		}

		JpaClient updatedClient = clientMapper.toEntity(updatedClientDTO);
		updatedClient.setId(id);
		JpaClient savedClient = clientRepository.save(updatedClient);
		return clientMapper.toDto(savedClient);
	}

	public void deleteClient(String id) {
		if (!clientRepository.existsById(id)) {
			// Handle not found exception
			throw new EntityNotFoundException("Client not found with ID: " + id);
		}
		clientRepository.deleteById(id);
	}
}
