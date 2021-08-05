package sube.apps.messageApi.conf;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import sube.apps.messageApi.ws.MessageApiWS;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	private static final Logger LOGGER = LoggerFactory.getLogger(MessageApiWS.class);

	@ExceptionHandler(value = { RuntimeException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException e, HttpServletRequest request) {
		LOGGER.error("Error en " + request.getRequestURI(), e);
		return ResponseEntity.status(500).build();
	}
}