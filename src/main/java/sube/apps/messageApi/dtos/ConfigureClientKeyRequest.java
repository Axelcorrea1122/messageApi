package sube.apps.messageApi.dtos;

public class ConfigureClientKeyRequest {

	private String key;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ConfigureClientKeyRequest(String key) {
		super();
		this.key = key;
	}

	public ConfigureClientKeyRequest() {
		super();
	}

}
