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

/**
 * Service class responsible for handling operations related to clients. This
 * class provides methods to retrieve, create, update, and delete client
 * entities.
 */
@Service
public class ClientService {

	@Autowired
	private JpaClientRepository clientRepository;

	@Autowired
	private ClientMapper clientMapper;

	/**
	 * Retrieves a list of all clients.
	 *
	 * @return A list of client DTOs.
	 */
	public List<ClientDTO> getAllClients() {
		List<JpaClient> clients = clientRepository.findAll();
		return clients.stream().map(clientMapper::toDto).collect(Collectors.toList());
	}

	/**
	 * Retrieves a client by its ID.
	 *
	 * @param id The ID of the client to retrieve.
	 * @return An optional containing the client DTO if found, or an empty optional
	 *         if not found.
	 */
	public Optional<ClientDTO> getClientById(String id) {
		Optional<JpaClient> clientOptional = clientRepository.findById(id);
		return clientOptional.map(clientMapper::toDto);
	}

	/**
	 * Creates a new client.
	 *
	 * @param clientDTO The client DTO containing the client's information.
	 * @return The created client DTO.
	 */
	public ClientDTO createClient(ClientDTO clientDTO) {
		JpaClient client = clientMapper.toEntity(clientDTO);
		JpaClient savedClient = clientRepository.save(client);
		return clientMapper.toDto(savedClient);
	}

	/**
	 * Updates an existing client by its ID.
	 *
	 * @param id               The ID of the client to update.
	 * @param updatedClientDTO The updated client DTO containing the new client
	 *                         information.
	 * @return The updated client DTO.
	 * @throws EntityNotFoundException If the client with the specified ID is not
	 *                                 found.
	 */
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

	/**
	 * Deletes a client by its ID.
	 *
	 * @param id The ID of the client to delete.
	 * @throws EntityNotFoundException If the client with the specified ID is not
	 *                                 found.
	 */
	public void deleteClient(String id) {
		if (!clientRepository.existsById(id)) {
			// Handle not found exception
			throw new EntityNotFoundException("Client not found with ID: " + id);
		}
		clientRepository.deleteById(id);
	}
}
