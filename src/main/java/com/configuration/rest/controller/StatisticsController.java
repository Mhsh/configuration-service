package com.configuration.rest.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.configuration.rest.dto.RateDetailDTO;
import com.configuration.rest.dto.ETLStatisticsDTO;
import com.configuration.rest.dto.IngestionStatisticsDTO;
import com.configuration.rest.service.StatisticsService;
import com.storage.jpa.Enums.ConnectorType;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;

	/**
	 * Get count of error details from public.error_detail table.
	 *
	 * @return The count of error details.
	 */
	@GetMapping("/ingestion")
	@Operation(tags = { "Statistics" })
	public IngestionStatisticsDTO getIngestionStatistics(@RequestParam ConnectorType connectorType) {
		IngestionStatisticsDTO statisticsDTO = new IngestionStatisticsDTO();
		statisticsDTO.setFailure(statisticsService.getIngestionErrorDetails());
		statisticsDTO
				.setSubscriptionByConnectorType(statisticsService.getSubscriptionDetailsByConnectorType(connectorType));
		statisticsDTO.setSuccess(statisticsService.getCountOfRssDigest());
		return statisticsDTO;
	}

	/**
	 * Get count of error details from public.error_detail table.
	 *
	 * @return The count of error details.
	 */
	@GetMapping("/etl")
	@Operation(tags = { "Statistics" })
	public ETLStatisticsDTO getETLStatistics() {
		ETLStatisticsDTO statisticsDTO = new ETLStatisticsDTO();
		statisticsDTO.setFailure(statisticsService.getETLErrorDetails());
		statisticsDTO.setSuccess(statisticsService.getETLSucessCount());
		return statisticsDTO;
	}

	@GetMapping("/rate")
	@Operation(tags = { "Statistics" })
	public List<RateDetailDTO> invokeOtherService() {
		return statisticsService.invokeOtherService();
	}

	@GetMapping("/ingestion/errorGroup")
	@Operation(tags = { "Statistics" })
	public List<Map<String, Long>> getIngestionErrorGroup() {
		return statisticsService.getIngestionErrorByErrorDetail();
	}

	@GetMapping("/etl/errorGroup")
	@Operation(tags = { "Statistics" })
	public List<Map<String, Long>> getETLErrorGroup() {
		return statisticsService.getETLErrorByErrorDetail();
	}

}
