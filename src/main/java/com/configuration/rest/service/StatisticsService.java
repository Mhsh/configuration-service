package com.configuration.rest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.configuration.rest.dto.QueueDetails;
import com.configuration.rest.dto.RateDetailDTO;
import com.storage.jpa.Enums.ConnectorType;
import com.storage.repository.JpaErrorDetailRepository;
import com.storage.repository.JpaRssDigestRepository;
import com.storage.repository.JpaSubscriptionDetailRepository;

@Service
public class StatisticsService {

	@Autowired
	private JpaErrorDetailRepository errorDetailRepository;

	@Autowired
	private JpaRssDigestRepository rssDigestRepository;

	@Autowired
	private JpaSubscriptionDetailRepository subscriptionDetailRepository;

	@Autowired
	private RestTemplate restTemplate;

	@Value("${ingestion.rate.url}")
	private String brokerUrl;

	@Value("${ingestion.rate.username}")
	private String user;

	@Value("${ingestion.rate.password}")
	private String password;
	// Existing methods...

	/**
	 * Get count of error details from public.error_detail table.
	 *
	 * @return The count of error details.
	 */
	public Long getCountOfErrorDetails() {
		return errorDetailRepository.count();
	}

	/**
	 * Get count of error details grouped by error_detail from public.error_detail
	 * table.
	 *
	 * @return The result set containing error_detail and its count.
	 */
	public List<Map<String, Long>> getCountGroupedByErrorDetail() {
		return errorDetailRepository.getCountGroupedByErrorDetail();
	}

	/**
	 * Get count of rows from public.rss_digest table.
	 *
	 * @return The count of rows in public.rss_digest table.
	 */
	public Long getCountOfRssDigest() {
		return rssDigestRepository.count();
	}

	/**
	 * Get count of rows from public.subscription_detail where connectorType='RSS'.
	 *
	 * @return The count of rows matching the condition.
	 */
	public Long getSubscriptionDetailsByConnectorType(ConnectorType connectorType) {
		return subscriptionDetailRepository.countByConnectorType(connectorType);
	}

	public List<RateDetailDTO> invokeOtherService() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth(user, password);
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		ResponseEntity<QueueDetails[]> responseEntity = restTemplate.exchange(brokerUrl, HttpMethod.GET, requestEntity,
				QueueDetails[].class);
		QueueDetails[] queueDetails = null;
		if (responseEntity.getStatusCode().is2xxSuccessful()) {
			queueDetails = responseEntity.getBody();
		} else {
			queueDetails = new QueueDetails[0];
		}
		return convertQueueDetailsToRateDetailDTO(queueDetails);
	}

	public List<RateDetailDTO> convertQueueDetailsToRateDetailDTO(QueueDetails[] queueDetailsList) {
		List<RateDetailDTO> rateDetailDTOList = new ArrayList<>();

		for (QueueDetails queueDetails : queueDetailsList) {
			RateDetailDTO rateDetailDTO = new RateDetailDTO();
			rateDetailDTO.setQueueName(queueDetails.getName());

			// Check if messageStats is not null and has deliverGetDetails
			if (queueDetails.getMessageStats() != null
					&& queueDetails.getMessageStats().getDeliverGetDetails() != null) {
				double rate = queueDetails.getMessageStats().getDeliverGetDetails().getRate();
				rateDetailDTO.setRate(rate);
			}
			rateDetailDTOList.add(rateDetailDTO);
		}

		return rateDetailDTOList;
	}
}
