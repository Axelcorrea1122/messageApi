package sube.apps.messageApi.dtos;



public class PushMessageRequest extends MobilePushRequest {
	private String client;
	
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}

	public PushMessageRequest(String to, Notification notification, Data data, String client) {
		super(to, notification, data);
		this.client = client;
	}
	public PushMessageRequest() {
		super();
	}
}
