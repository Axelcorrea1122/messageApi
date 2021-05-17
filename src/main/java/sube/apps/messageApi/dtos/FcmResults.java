package sube.apps.messageApi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FcmResults {
	@JsonProperty("message_id")
	private String messageId;

	public String getMessageId() {
		return messageId;
	}

	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}

	public FcmResults(String messageId) {
		super();
		this.messageId = messageId;
	}

	public FcmResults() {
		
	}
		
	
}
