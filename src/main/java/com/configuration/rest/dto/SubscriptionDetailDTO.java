package com.configuration.rest.dto;

import java.time.OffsetDateTime;

/**
 * Data Transfer Object (DTO) class representing subscription properties. This
 * class is used to transfer subscription property information between the
 * controller and service layers.
 */
public class SubscriptionDetailDTO extends BaseDTO {

	private Long id;

	private String properties;

	/**
	 * The duration of the subscription.
	 */
	private Integer duration;

	/**
	 * The date of the next scheduled event for the subscription.
	 */
	private OffsetDateTime nextSchedule;

	private String rawFileLocation;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the values
	 */
	public String getProperties() {
		return properties;
	}

	/**
	 * @param values the values to set
	 */
	public void setProperties(String properties) {
		this.properties = properties;
	}

	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	/**
	 * @return the nextSchedule
	 */
	public OffsetDateTime getNextSchedule() {
		return nextSchedule;
	}

	/**
	 * @param nextSchedule the nextSchedule to set
	 */
	public void setNextSchedule(OffsetDateTime nextSchedule) {
		this.nextSchedule = nextSchedule;
	}

	/**
	 * @return the rawFileLocation
	 */
	public String getRawFileLocation() {
		return rawFileLocation;
	}

	/**
	 * @param rawFileLocation the rawFileLocation to set
	 */
	public void setRawFileLocation(String rawFileLocation) {
		this.rawFileLocation = rawFileLocation;
	}
}
