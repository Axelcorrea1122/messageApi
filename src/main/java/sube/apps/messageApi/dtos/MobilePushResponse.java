package sube.apps.messageApi.dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MobilePushResponse {
	
	@JsonProperty("multicast_id")
	private String multicastId;
	private int success;
	private int failure;
	@JsonProperty("canonical_id")
	private int canonicalId;
	
	private List<FcmResults> results;
	
	public String getMulticastId() {
		return multicastId;
	}
	public void setMulticastId(String multicastId) {
		this.multicastId = multicastId;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFailure() {
		return failure;
	}
	public void setFailure(int failure) {
		this.failure = failure;
	}
	public int getCanonicalId() {
		return canonicalId;
	}
	public void setCanonicalId(int canonicalId) {
		this.canonicalId = canonicalId;
	}
	public List<FcmResults> getResults() {
		return results;
	}
	public void setResults(List<FcmResults> results) {
		this.results = results;
	}
	
	public MobilePushResponse(String multicastId, int success, int failure, int canonicalId, List<FcmResults> results) {
		super();
		this.multicastId = multicastId;
		this.success = success;
		this.failure = failure;
		this.canonicalId = canonicalId;
		this.results = results;
	}

	public MobilePushResponse() {
		
	}
}
