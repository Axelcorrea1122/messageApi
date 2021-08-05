package sube.apps.messageApi.dtos;

public class MobilePushRequest {
	private String to;
	private Notification notification;
	private Data data;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Notification getNotification() {
		return notification;
	}
	public void setNotification(Notification notification) {
		this.notification = notification;
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}
	
	public MobilePushRequest(String to, Notification notification, Data data) {
		super();
		this.to = to;
		this.notification = notification;
		this.data = data;
	}
	
	public MobilePushRequest() {
	}
	
	

}
