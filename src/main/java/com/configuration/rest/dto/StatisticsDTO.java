package com.configuration.rest.dto;

public class StatisticsDTO {

	private Long success;

	private Long failure;

	private Long subscriptionByConnectorType;

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

	/**
	 * @return the subscriptionByConnectorType
	 */
	public Long getSubscriptionByConnectorType() {
		return subscriptionByConnectorType;
	}

	/**
	 * @param subscriptionByConnectorType the subscriptionByConnectorType to set
	 */
	public void setSubscriptionByConnectorType(Long subscriptionByConnectorType) {
		this.subscriptionByConnectorType = subscriptionByConnectorType;
	}

}
