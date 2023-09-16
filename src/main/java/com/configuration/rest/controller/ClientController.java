package com.configuration.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.ClientDTO;
import com.configuration.rest.service.ClientService;

import io.swagger.v3.oas.annotations.Operation;

/**
 * REST Controller for managing client operations. This controller provides
 * endpoints for creating, retrieving, updating, and deleting clients.
 */
@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	/**
	 * Get a list of all clients.
	 *
	 * @return A list of ClientDTOs representing all clients.
	 */
	@Operation(tags = { "Client" })
	@GetMapping
	public List<ClientDTO> getAllClients() {
		return clientService.getAllClients();
	}

	/**
	 * Get a client by its ID.
	 *
	 * @param id The ID of the client to retrieve.
	 * @return An Optional containing the retrieved ClientDTO if found, or an empty
	 *         Optional if not found.
	 */
	@GetMapping("/{id}")
	@Operation(tags = { "Client" })
	public Optional<ClientDTO> getClientById(@PathVariable String id) {
		return clientService.getClientById(id);
	}

	/**
	 * Create a new client.
	 *
	 * @param clientDTO The ClientDTO representing the client to create.
	 * @return The created ClientDTO.
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(tags = { "Client" })
	public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
		return clientService.createClient(clientDTO);
	}

	/**
	 * Update an existing client by its ID.
	 *
	 * @param id               The ID of the client to update.
	 * @param updatedClientDTO The updated ClientDTO.
	 * @return The updated ClientDTO if updated, or null if the original client was
	 *         not found.
	 */
	@PutMapping("/{id}")
	@Operation(tags = { "Client" })
	public ClientDTO updateClient(@PathVariable String id, @RequestBody ClientDTO updatedClientDTO) {
		return clientService.updateClient(id, updatedClientDTO);
	}

	/**
	 * Delete a client by its ID.
	 *
	 * @param id The ID of the client to delete.
	 */
	@DeleteMapping("/{id}")
	@Operation(tags = { "Client" })
	public void deleteClient(@PathVariable String id) {
		clientService.deleteClient(id);
	}
}
