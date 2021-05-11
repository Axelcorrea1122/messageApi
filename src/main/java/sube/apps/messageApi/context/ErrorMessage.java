package sube.apps.messageApi.context;

public enum ErrorMessage {

	SERVICE_UNAVAILABLE_ERROR("Intentá más tarde.");

	private String errorMessage;

	ErrorMessage(String errorCode) {

		this.errorMessage = errorCode;

	}

	public String getErrorMessage() {

		return errorMessage;

	}

}
