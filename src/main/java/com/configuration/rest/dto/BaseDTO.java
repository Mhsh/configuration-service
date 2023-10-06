package com.configuration.rest.dto;

import java.time.OffsetDateTime;

public class BaseDTO {

	private OffsetDateTime created;

	private OffsetDateTime updated;

	/**
	 * @return the created
	 */
	public OffsetDateTime getCreated() {
		return created;
	}

	/**
	 * @param created the created to set
	 */
	public void setCreated(OffsetDateTime created) {
		this.created = created;
	}

	/**
	 * @return the updated
	 */
	public OffsetDateTime getUpdated() {
		return updated;
	}

	/**
	 * @param updated the updated to set
	 */
	public void setUpdated(OffsetDateTime updated) {
		this.updated = updated;
	}

}
