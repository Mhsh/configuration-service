package com.configuration.rest.dto;

public class ETLStatisticsDTO {

	private Long success;

	private Long failure;

	/**
	 * @return the success
	 */
	public Long getSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(Long success) {
		this.success = success;
	}

	/**
	 * @return the failure
	 */
	public Long getFailure() {
		return failure;
	}

	/**
	 * @param failure the failure to set
	 */
	public void setFailure(Long failure) {
		this.failure = failure;
	}

}
