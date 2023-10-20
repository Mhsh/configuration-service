package com.configuration.rest.controller;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.ClientTemplateDTO;
import com.configuration.rest.mapper.ClientTemplateMapper;
import com.configuration.rest.service.ClientTemplateService;
import com.storage.jpa.JpaClientTemplate;

import io.swagger.v3.oas.annotations.Operation;

/**
 * The `ClientTemplateController` class handles HTTP requests related to client
 * templates.
 */
@RestController
@RequestMapping("/client/{clientId}/template")
public class ClientTemplateController {

	@Autowired
	private ClientTemplateService clientTemplateService;

	@Autowired
	private ClientTemplateMapper clientTemplateMapper;

	/**
	 * Retrieves all client templates associated with a specific client.
	 *
	 * @param clientId The unique identifier of the client.
	 * @return A ResponseEntity containing a list of client templates if found, or
	 *         an empty list if none are found.
	 */
	@GetMapping
	@Operation(tags = { "ClientTemplate" })
	public ResponseEntity<List<ClientTemplateDTO>> getAllClientTemplates(@PathVariable String clientId) {
		List<JpaClientTemplate> templates = clientTemplateService.findAllByClientId(clientId);
		List<ClientTemplateDTO> dtos = templates.stream().map(clientTemplateMapper::toDTO).collect(Collectors.toList());
		return ResponseEntity.ok(dtos);
	}

	/**
	 * Retrieves a client template by its unique identifier.
	 *
	 * @param id The unique identifier of the client template.
	 * @return A ResponseEntity containing the client template if found, or a 404
	 *         Not Found status if not found.
	 */
	@GetMapping("/{id}")
	@Operation(tags = { "ClientTemplate" })
	public ResponseEntity<ClientTemplateDTO> getClientTemplate(@PathVariable UUID id) {
		JpaClientTemplate template = clientTemplateService.findById(id);
		if (template != null) {
			ClientTemplateDTO dto = clientTemplateMapper.toDTO(template);
			return ResponseEntity.ok(dto);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Creates a new client template.
	 *
	 * @param dto The DTO containing client template information to be created.
	 * @return A ResponseEntity containing the created client template and a 201
	 *         Created status.
	 */
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	@Operation(tags = { "ClientTemplate" })
	public ResponseEntity<ClientTemplateDTO> createClientTemplate(@PathVariable String clientId,
			@RequestBody ClientTemplateDTO dto) {
		JpaClientTemplate entity = clientTemplateMapper.toEntity(dto, clientId);
		JpaClientTemplate createdEntity = clientTemplateService.create(entity);
		ClientTemplateDTO createdDTO = clientTemplateMapper.toDTO(createdEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdDTO);
	}

	/**
	 * Updates an existing client template by its unique identifier.
	 *
	 * @param id  The unique identifier of the client template to be updated.
	 * @param dto The DTO containing updated client template information.
	 * @return A ResponseEntity containing the updated client template if found, or
	 *         a 404 Not Found status if not found.
	 */
	@PutMapping("/{id}")
	@Operation(tags = { "ClientTemplate" })
	public ResponseEntity<ClientTemplateDTO> updateClientTemplate(@PathVariable UUID id, @PathVariable String clientId,
			@RequestBody ClientTemplateDTO dto) {
		JpaClientTemplate existingEntity = clientTemplateService.findById(id);
		if (existingEntity != null) {
			JpaClientTemplate updatedEntity = clientTemplateMapper.toEntity(dto, clientId);
			updatedEntity.setId(id);
			JpaClientTemplate updatedTemplate = clientTemplateService.update(updatedEntity);
			ClientTemplateDTO updatedDTO = clientTemplateMapper.toDTO(updatedTemplate);
			return ResponseEntity.ok(updatedDTO);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Deletes a client template by its unique identifier.
	 *
	 * @param id The unique identifier of the client template to be deleted.
	 * @return A ResponseEntity with no content (204 No Content) if the client
	 *         template was successfully deleted, or a 404 Not Found status if not
	 *         found.
	 */
	@DeleteMapping("/{id}")
	@Operation(tags = { "ClientTemplate" })
	public ResponseEntity<Void> deleteClientTemplate(@PathVariable UUID id) {
		JpaClientTemplate template = clientTemplateService.findById(id);
		if (template != null) {
			clientTemplateService.delete(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}
