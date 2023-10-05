package com.configuration.rest.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.configuration.rest.dto.SubscriptionDetailDTO;
import com.configuration.rest.mapper.SubscriptionDetailMapper;
import com.storage.jpa.JpaSubscription;
import com.storage.jpa.JpaSubscriptionDetail;
import com.storage.repository.JpaSubscriptionDetailRepository;
import com.storage.repository.JpaSubscriptionRepository;

@Service
public class SubscriptionDetailService {

	private final JpaSubscriptionDetailRepository subscriptionDetailRepository;
	private final SubscriptionDetailMapper subscriptionDetailMapper;
	private final JpaSubscriptionRepository subscriptionRepository;

	public SubscriptionDetailService(JpaSubscriptionDetailRepository subscriptionDetailRepository,
			SubscriptionDetailMapper subscriptionDetailMapper, JpaSubscriptionRepository subscriptionRepository) {
		this.subscriptionDetailRepository = subscriptionDetailRepository;
		this.subscriptionDetailMapper = subscriptionDetailMapper;
		this.subscriptionRepository = subscriptionRepository;
	}

	public List<SubscriptionDetailDTO> getAllSubscriptionDetailsBySubscription(Long subscriptionId) {
		JpaSubscription subscription = subscriptionRepository.findById(subscriptionId)
				.orElseThrow(EntityNotFoundException::new);
		List<JpaSubscriptionDetail> subscriptionDetails = subscriptionDetailRepository.findBySubscription(subscription);
		return subscriptionDetails.stream().map(subscriptionDetailMapper::toDto).collect(Collectors.toList());
	}

	public SubscriptionDetailDTO createSubscriptionDetail(SubscriptionDetailDTO subscriptionDetailDTO,
			Long subscriptionId) {
		JpaSubscriptionDetail subscriptionDetail = subscriptionDetailMapper.toEntity(subscriptionDetailDTO,
				subscriptionId);
		subscriptionDetail = subscriptionDetailRepository.save(subscriptionDetail);
		return subscriptionDetailMapper.toDto(subscriptionDetail);
	}

	public Optional<SubscriptionDetailDTO> updateSubscriptionDetail(Long id,
			SubscriptionDetailDTO subscriptionDetailDTO) {
		Optional<JpaSubscriptionDetail> existingSubscriptionDetailOptional = subscriptionDetailRepository.findById(id);
		if (existingSubscriptionDetailOptional.isEmpty()) {
			return Optional.empty();
		}

		JpaSubscriptionDetail existingSubscriptionDetail = existingSubscriptionDetailOptional.get();

		// Update the existingSubscriptionDetail with values from subscriptionDetailDTO
		// You can add your update logic here

		JpaSubscriptionDetail updatedSubscriptionDetail = subscriptionDetailRepository.save(existingSubscriptionDetail);

		return Optional.of(subscriptionDetailMapper.toDto(updatedSubscriptionDetail));
	}

	public boolean deleteSubscriptionDetail(Long id) {
		Optional<JpaSubscriptionDetail> subscriptionDetailOptional = subscriptionDetailRepository.findById(id);
		if (subscriptionDetailOptional.isPresent()) {
			JpaSubscriptionDetail subscriptionDetail = subscriptionDetailOptional.get();
			subscriptionDetailRepository.delete(subscriptionDetail);
			return true;
		}
		return false;
	}
}
