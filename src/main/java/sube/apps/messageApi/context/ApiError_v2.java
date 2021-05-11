package sube.apps.messageApi.context;

import java.util.HashMap;
import java.util.Map;

public class ApiError_v2 {
	private String type;
	private String title;
	private Map<String, String> detail = new HashMap<>();
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Map<String, String> getDetail() {
		return detail;
	}
	public void setDetail(Map<String, String> detail) {
		this.detail = detail;
	}
	
	public ApiError_v2() {

	}
	
	public ApiError_v2(String type, String title) {
		super();
		this.type = type;
		this.title = title;
	}
	
	public ApiError_v2(String type, String title, Map<String, String> detail) {
		super();
		this.type = type;
		this.title = title;
		this.detail = detail;
	}
	
	
}