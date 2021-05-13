package sube.apps.messageApi.context;

public enum ErrorMessage {

	SERVICE_UNAVAILABLE_ERROR("Intentá más tarde."),
	BAD_REQUEST("Por favor, revisá los datos ingresados."),
	BAD_REQUEST_ERROR_KEY("Revisá la key ingresada.");

	private String errorMessage;

	ErrorMessage(String errorCode) {

		this.errorMessage = errorCode;

	}

	public String getErrorMessage() {

		return errorMessage;

	}

}
