package com.configuration.rest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping
	public List<ClientDTO> getAllClients() {
		return clientService.getAllClients();
	}

	@GetMapping("/{id}")
	public Optional<ClientDTO> getClientById(@PathVariable String id) {
		return clientService.getClientById(id);
	}

	@PostMapping
	public ClientDTO createClient(@RequestBody ClientDTO clientDTO) {
		return clientService.createClient(clientDTO);
	}

	@PutMapping("/{id}")
	public ClientDTO updateClient(@PathVariable String id, @RequestBody ClientDTO updatedClientDTO) {
		return clientService.updateClient(id, updatedClientDTO);
	}

	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable String id) {
		clientService.deleteClient(id);
	}
}
