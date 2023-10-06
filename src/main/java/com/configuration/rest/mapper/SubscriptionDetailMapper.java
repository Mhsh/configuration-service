package com.configuration.rest.mapper;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.SubscriptionDetailDTO;
import com.storage.jpa.JpaSubscriptionDetail;
import com.storage.repository.JpaSubscriptionRepository;

/**
 * Mapper class responsible for mapping between {@link JpaSubscriptionDetail}
 * entities and {@link SubscriptionDetailDTO} data transfer objects. This class
 * provides methods to convert entities to DTOs and vice versa.
 */
@Component
public class SubscriptionDetailMapper {

	@Autowired
	private JpaSubscriptionRepository subscriptionRepository;

	/**
	 * Converts a {@link JpaSubscriptionDetail} entity to a
	 * {@link SubscriptionDetailDTO}.
	 *
	 * @param jpaSubscriptionDetail The JpaSubscriptionProperty entity to be
	 *                              converted.
	 * @return The corresponding SubscriptionPropertyDTO.
	 */
	public SubscriptionDetailDTO toDto(JpaSubscriptionDetail jpaSubscriptionDetail) {
		SubscriptionDetailDTO dto = new SubscriptionDetailDTO();
		dto.setId(jpaSubscriptionDetail.getId());
		dto.setProperties(jpaSubscriptionDetail.getProperties());
		dto.setDuration(jpaSubscriptionDetail.getDuration());
		dto.setNextSchedule(jpaSubscriptionDetail.getNextExecution());
		dto.setDuration(jpaSubscriptionDetail.getDuration());
		dto.setRawFileLocation(jpaSubscriptionDetail.getRawFileLocation());
		dto.setCreated(jpaSubscriptionDetail.getCreatedDate());
		dto.setUpdated(jpaSubscriptionDetail.getUpdatedDate());
		return dto;
	}

	/**
	 * Converts a {@link SubscriptionDetailDTO} to a {@link JpaSubscriptionDetail}
	 * entity.
	 *
	 * @param dto The SubscriptionPropertyDTO to be converted.
	 * @return The corresponding JpaSubscriptionProperty entity.
	 * @throws EntityNotFoundException If the referenced connector metadata is not
	 *                                 found in the database.
	 */
	public JpaSubscriptionDetail toEntity(SubscriptionDetailDTO subscriptionDetailDTO, Long subscriptionId) {
		JpaSubscriptionDetail property = new JpaSubscriptionDetail();
		property.setId(subscriptionDetailDTO.getId());
		property.setProperties(subscriptionDetailDTO.getProperties());
		property.setDuration(subscriptionDetailDTO.getDuration());
		property.setNextExecution(subscriptionDetailDTO.getNextSchedule());
		property.setDuration(subscriptionDetailDTO.getDuration());
		property.setSubscription(subscriptionRepository.findById(subscriptionId).get());
		property.setRawFileLocation(subscriptionDetailDTO.getRawFileLocation());
		return property;
	}
}
