package sube.apps.messageApi.conf;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import com.fasterxml.jackson.databind.ObjectMapper;

import sube.apps.messageApi.context.ApiError_v2;
import sube.apps.messageApi.context.ErrorMessage;
import sube.apps.messageApi.ws.MessageApiWS;

@ControllerAdvice
public class RestTemplateExceptionHandler extends DefaultResponseErrorHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(MessageApiWS.class);

	@ExceptionHandler(value = { HttpServerErrorException.class, HttpClientErrorException.class })
	protected ResponseEntity<?> handleConflict(HttpClientErrorException e, HttpServletRequest request) {
		LOGGER.error("Falló en " + request.getRequestURI(), e);
		try {
			ObjectMapper mapper = new ObjectMapper();
			return ResponseEntity.badRequest().body(mapper.readValue(e.getResponseBodyAsString(), ApiError_v2.class));
		} catch (Exception ex) {
			LOGGER.error("Fallo en exceptionHandler: ", ex);
			return ResponseEntity.status(503).body(new ApiError_v2(ErrorMessage.SERVICE_UNAVAILABLE_ERROR.toString(),
					ErrorMessage.SERVICE_UNAVAILABLE_ERROR.getErrorMessage()));

		}

	}

}
