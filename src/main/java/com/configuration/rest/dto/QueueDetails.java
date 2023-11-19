package com.configuration.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QueueDetails {

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the messageStats
	 */
	public MessageStats getMessageStats() {
		return messageStats;
	}

	/**
	 * @param messageStats the messageStats to set
	 */
	public void setMessageStats(MessageStats messageStats) {
		this.messageStats = messageStats;
	}

	@JsonProperty("message_stats")
	private MessageStats messageStats;

	// Constructors, getters, and setters
	// ...

	public static class MessageStats {

		@JsonProperty("deliver_get_details")
		private DeliverGetDetails deliverGetDetails;

		// Getters and setters for deliverGetDetails
		// ...

		public static class DeliverGetDetails {

			private double rate;

			/**
			 * @return the rate
			 */
			public double getRate() {
				return rate;
			}

			/**
			 * @param rate the rate to set
			 */
			public void setRate(double rate) {
				this.rate = rate;
			}

		}

		/**
		 * @return the deliverGetDetails
		 */
		public DeliverGetDetails getDeliverGetDetails() {
			return deliverGetDetails;
		}

		/**
		 * @param deliverGetDetails the deliverGetDetails to set
		 */
		public void setDeliverGetDetails(DeliverGetDetails deliverGetDetails) {
			this.deliverGetDetails = deliverGetDetails;
		}

	}

}
