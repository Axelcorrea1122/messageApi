package sube.apps.messageApi.dtos;

public class ConfigureClientKeyRequest {

	private String clientId;
	private String key;

	public ConfigureClientKeyRequest(String clientId, String key) {
		super();
		this.clientId = clientId;
		this.key = key;
	}

	public ConfigureClientKeyRequest() {
		super();
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

}
