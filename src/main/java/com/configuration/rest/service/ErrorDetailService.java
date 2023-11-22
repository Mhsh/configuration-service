package com.configuration.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.configuration.rest.dto.ErrorDetailDTO;
import com.configuration.rest.mapper.ErrorDetailMapper;
import com.storage.jpa.JpaIngestionErrorDetail;
import com.storage.jpa.JpaSubscriptionDetail;
import com.storage.repository.JpaIngestionErrorDetailRepository;
import com.storage.repository.JpaSubscriptionDetailRepository;

@Service
public class ErrorDetailService {

	private final JpaIngestionErrorDetailRepository errorDetailRepository;
	private final JpaSubscriptionDetailRepository subscriptionDetailRepository;
	private final ErrorDetailMapper errorDetailMapper;

	public ErrorDetailService(JpaIngestionErrorDetailRepository errorDetailRepository,
			JpaSubscriptionDetailRepository subscriptionDetailRepository, ErrorDetailMapper errorDetailMapper) {
		this.errorDetailRepository = errorDetailRepository;
		this.subscriptionDetailRepository = subscriptionDetailRepository;
		this.errorDetailMapper = errorDetailMapper;
	}

	public List<ErrorDetailDTO> getAllErrorDetails() {
		List<JpaIngestionErrorDetail> subscriptionDetails = errorDetailRepository.findAll();
		return subscriptionDetails.stream().map(errorDetailMapper::toDto).collect(Collectors.toList());
	}

	public Optional<ErrorDetailDTO> getErrorDetailById(UUID id) {
		Optional<JpaIngestionErrorDetail> subscriptionOptional = errorDetailRepository.findById(id);
		return subscriptionOptional.map(errorDetailMapper::toDto);
	}

	public List<ErrorDetailDTO> getErrorDetailBySubscription(UUID subscriptionIdDetailId) {
		// Retrieve JpaSubscriptionDetail based on subscriptionId
		JpaSubscriptionDetail jpaSubscriptionDetail = subscriptionDetailRepository.findById(subscriptionIdDetailId)
				.orElseThrow(EntityNotFoundException::new);
		List<JpaIngestionErrorDetail> subscriptionDetails = errorDetailRepository
				.findBySubscriptionDetail(jpaSubscriptionDetail);
		return subscriptionDetails.stream().map(errorDetailMapper::toDto).collect(Collectors.toList());
	}

	public void deleteErrorDetailById(UUID id) {
		errorDetailRepository.deleteById(id);
	}

	public void deleteErrorDetailBySubscription(UUID subscriptionDetailId) {
		errorDetailRepository.deleteBySubscriptionDetailId(subscriptionDetailId);
	}

	public boolean updateErrorDetail(UUID id, ErrorDetailDTO updatedErrorDetail) {
		Optional<JpaIngestionErrorDetail> existingErrorDetailOptional = errorDetailRepository.findById(id);

		if (existingErrorDetailOptional.isPresent()) {
			JpaIngestionErrorDetail existingErrorDetail = existingErrorDetailOptional.get();

			// Update the fields you want to change
			existingErrorDetail.setType(updatedErrorDetail.getType());
			existingErrorDetail.setErrorDetail(updatedErrorDetail.getErrorDetail());

			// Save the updated error detail
			errorDetailRepository.save(existingErrorDetail);

			return true; // Successfully updated
		}

		return false; // Error detail with the given ID not found
	}
}
