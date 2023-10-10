package com.configuration.rest.mapper;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.configuration.rest.dto.ErrorDetailDTO;
import com.configuration.rest.dto.SubscriptionDetailDTO;
import com.storage.jpa.JpaErrorDetail;
import com.storage.jpa.JpaSubscriptionDetail;
import com.storage.repository.JpaSubscriptionDetailRepository;

/**
 * Mapper class responsible for mapping between {@link JpaSubscriptionDetail}
 * entities and {@link SubscriptionDetailDTO} data transfer objects. This class
 * provides methods to convert entities to DTOs and vice versa.
 */
@Component
public class ErrorDetailMapper {

	@Autowired
	private JpaSubscriptionDetailRepository subscriptionDetailRepository;

	/**
	 * Converts a {@link JpaSubscriptionDetail} entity to a
	 * {@link SubscriptionDetailDTO}.
	 *
	 * @param jpaSubscriptionDetail The JpaSubscriptionProperty entity to be
	 *                              converted.
	 * @return The corresponding SubscriptionPropertyDTO.
	 */
	public ErrorDetailDTO toDto(JpaErrorDetail errorDetail) {
		ErrorDetailDTO dto = new ErrorDetailDTO();
		dto.setErrorCode(errorDetail.getErrorCode());
		dto.setErrorDetail(errorDetail.getErrorDetail());
		dto.setId(errorDetail.getId());
		dto.setRetryCount(errorDetail.getRetryCount());
		dto.setSubscriptionId(errorDetail.getJpaSubscriptionDetail().getId());
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
	public JpaErrorDetail toEntity(ErrorDetailDTO errorDetailDTO, Long subscriptionDetailId) {
		JpaErrorDetail dto = new JpaErrorDetail();
		dto.setErrorCode(errorDetailDTO.getErrorCode());
		dto.setErrorDetail(errorDetailDTO.getErrorDetail());
		dto.setId(errorDetailDTO.getId());
		dto.setRetryCount(errorDetailDTO.getRetryCount());
		dto.setJpaSubscriptionDetail(
				subscriptionDetailRepository.findById(errorDetailDTO.getSubscriptionId()).orElse(null));
		return dto;
	}
}
