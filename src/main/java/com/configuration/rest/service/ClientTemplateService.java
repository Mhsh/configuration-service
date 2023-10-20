package com.configuration.rest.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.storage.jpa.JpaClientTemplate;
import com.storage.repository.JpaClientTemplateRepository;

/**
 * Service class for managing {@link JpaClientTemplate} entities.
 */
@Service
public class ClientTemplateService {

	@Autowired
	private JpaClientTemplateRepository clientTemplateRepository;

	/**
	 * Finds a {@link JpaClientTemplate} entity by its unique identifier (ID).
	 *
	 * @param id The unique identifier (ID) of the {@link JpaClientTemplate} to
	 *           retrieve.
	 * @return The found {@link JpaClientTemplate} entity, or null if not found.
	 */
	public JpaClientTemplate findById(UUID id) {
		return clientTemplateRepository.findById(id).orElse(null);
	}

	/**
	 * Creates a new {@link JpaClientTemplate} entity.
	 *
	 * @param entity The {@link JpaClientTemplate} entity to be created.
	 * @return The newly created {@link JpaClientTemplate} entity.
	 */
	public JpaClientTemplate create(JpaClientTemplate entity) {
		return clientTemplateRepository.save(entity);
	}

	/**
	 * Updates an existing {@link JpaClientTemplate} entity.
	 *
	 * @param entity The {@link JpaClientTemplate} entity to be updated.
	 * @return The updated {@link JpaClientTemplate} entity.
	 */
	public JpaClientTemplate update(JpaClientTemplate entity) {
		return clientTemplateRepository.save(entity);
	}

	/**
	 * Deletes a {@link JpaClientTemplate} entity by its unique identifier (ID).
	 *
	 * @param id The unique identifier (ID) of the {@link JpaClientTemplate} to be
	 *           deleted.
	 */
	public void delete(UUID id) {
		clientTemplateRepository.deleteById(id);
	}

	/**
	 * Retrieves a list of client templates associated with a specific client's
	 * unique identifier (ID).
	 *
	 * @param clientId The unique identifier of the client for which to retrieve
	 *                 client templates.
	 * @return A list of client templates associated with the specified client ID,
	 *         or an empty list if none are found.
	 */

	public List<JpaClientTemplate> findAllByClientId(String clientId) {
		// Use the repository to find client templates by clientId
		return clientTemplateRepository.findAllByClient_Id(clientId);
	}
}
