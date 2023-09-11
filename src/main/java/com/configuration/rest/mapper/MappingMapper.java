package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.MappingItemDTO;
import com.storage.jpa.JpaMapping;
import com.storage.jpa.JpaSubscription;

/**
 * Mapper class responsible for mapping between {@link JpaMapping} entities and
 * {@link MappingItemDTO} data transfer objects. This class provides methods to
 * convert entities to DTOs and vice versa.
 */
@Component
public class MappingMapper {

	/**
	 * Converts a {@link MappingItemDTO} to a {@link JpaMapping} entity associated
	 * with a {@link JpaSubscription}.
	 *
	 * @param dto          The MappingItemDTO to be converted.
	 * @param subscription The JpaSubscription associated with the mapping.
	 * @return The corresponding JpaMapping entity.
	 */
	public JpaMapping toEntity(MappingItemDTO dto, JpaSubscription subscription) {
		JpaMapping entity = new JpaMapping();
		entity.setSubscription(subscription);
		entity.setSourcekey(dto.getSourcekey());
		entity.setInternalkey(dto.getInternalkey());
		entity.setType(dto.getType());
		return entity;
	}

	/**
	 * Converts a {@link JpaMapping} entity to a {@link MappingItemDTO}.
	 *
	 * @param entity The JpaMapping entity to be converted.
	 * @return The corresponding MappingItemDTO.
	 */
	public MappingItemDTO toDTO(JpaMapping entity) {
		MappingItemDTO dto = new MappingItemDTO();
		dto.setSourcekey(entity.getSourcekey());
		dto.setInternalkey(entity.getInternalkey());
		dto.setType(entity.getType());
		return dto;
	}
}
