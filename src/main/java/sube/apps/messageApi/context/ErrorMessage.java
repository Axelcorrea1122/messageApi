package sube.apps.messageApi.context;

public enum ErrorMessage {

	SERVICE_UNAVAILABLE_ERROR("Intentá más tarde."),
	BAD_REQUEST("Por favor, revisá los datos enviados."),
	BAD_REQUEST_ERROR_KEY("Cliente no tiene configuración para mandar notificaciones push."),
	BAD_HANDLED_EXCEPTION("Error al manejar $ExceptionType"),
	FCM_PUSH_NOTIFICATION_ERROR("Error al enviar notificación Push");

	private String errorMessage;

	ErrorMessage(String errorCode) {

		this.errorMessage = errorCode;

	}

	public String getErrorMessage() {

		return errorMessage;

	}

}
