package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.MappingItemDTO;
import com.storage.jpa.JpaEtlSubscriptionMapping;
import com.storage.jpa.JpaSubscription;

/**
 * Mapper class responsible for mapping between
 * {@link JpaEtlSubscriptionMapping} entities and {@link MappingItemDTO} data
 * transfer objects. This class provides methods to convert entities to DTOs and
 * vice versa.
 */
@Component
public class MappingMapper {

	/**
	 * Converts a {@link MappingItemDTO} to a {@link JpaEtlSubscriptionMapping}
	 * entity associated with a {@link JpaSubscription}.
	 *
	 * @param dto          The MappingItemDTO to be converted.
	 * @param subscription The JpaSubscription associated with the mapping.
	 * @return The corresponding JpaMapping entity.
	 */
	public JpaEtlSubscriptionMapping toEntity(MappingItemDTO dto, JpaSubscription subscription) {
		JpaEtlSubscriptionMapping entity = new JpaEtlSubscriptionMapping();
		entity.setSubscription(subscription);
		entity.setSourcekey(dto.getSourcekey());
		entity.setInternalkey(dto.getInternalkey());
		entity.setType(dto.getType());
		entity.setCreatedDate(subscription.getCreatedDate());
		entity.setUpdatedDate(subscription.getUpdatedDate());
		return entity;
	}

	/**
	 * Converts a {@link JpaEtlSubscriptionMapping} entity to a
	 * {@link MappingItemDTO}.
	 *
	 * @param entity The JpaMapping entity to be converted.
	 * @return The corresponding MappingItemDTO.
	 */
	public MappingItemDTO toDTO(JpaEtlSubscriptionMapping entity) {
		MappingItemDTO dto = new MappingItemDTO();
		dto.setSourcekey(entity.getSourcekey());
		dto.setInternalkey(entity.getInternalkey());
		dto.setType(entity.getType());
		dto.setSubscriptionId(entity.getSubscription().getId());
		dto.setCreated(entity.getCreatedDate());
		dto.setUpdated(entity.getUpdatedDate());
		return dto;
	}
}
