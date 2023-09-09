package com.configuration.rest.dto;

public class ConnectorMetadataDTO {

	private Long id;
	private String key;
	private boolean multiValued;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public boolean isMultiValued() {
		return multiValued;
	}

	public void setMultiValued(boolean multiValued) {
		this.multiValued = multiValued;
	}

	@Override
	public String toString() {
		return "ConnectorMetadataDTO [id=" + id + ", key=" + key + ", multiValued=" + multiValued + "]";
	}

}
