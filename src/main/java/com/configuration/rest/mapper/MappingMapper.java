package com.configuration.rest.mapper;

import org.springframework.stereotype.Component;

import com.configuration.rest.dto.MappingItemDTO;
import com.storage.jpa.JpaMapping;
import com.storage.jpa.JpaSubscription;

@Component
public class MappingMapper {

	public JpaMapping toEntity(MappingItemDTO dto, JpaSubscription subscription) {
		JpaMapping entity = new JpaMapping();
		entity.setSubscription(subscription);
		entity.setSourcekey(dto.getSourcekey());
		entity.setInternalkey(dto.getInternalkey());
		entity.setType(dto.getType());
		return entity;
	}

	public MappingItemDTO toDTO(JpaMapping entity) {
		MappingItemDTO dto = new MappingItemDTO();
		dto.setSourcekey(entity.getSourcekey());
		dto.setInternalkey(entity.getInternalkey());
		dto.setType(entity.getType());
		return dto;
	}
}
