package sube.apps.messageApi.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import sube.apps.messageApi.context.ApiError_v2;
import sube.apps.messageApi.dtos.ConfigureClientKeyRequest;
import sube.apps.messageApi.dtos.PushMessageRequest;
import sube.apps.messageApi.entities.CurrentUser;
import sube.apps.messageApi.entities.UserDetails;
import sube.apps.messageApi.services.MessageApiService;

@RestController
@RequestMapping("/v1/messageApi")
public class MessageApiWS {

	@Autowired
	private MessageApiService messageService;

	@PostMapping(path = "/configureClientKey", produces = "application/json")
	@ApiOperation(value = "Configura un key para un cliente.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Error en petición", response = ApiError_v2.class) })
	public ResponseEntity<?> configureClientKey(@RequestBody ConfigureClientKeyRequest params) {
		return messageService.saveClientKey(params.getKey(), params.getClientId());
	}

	@PutMapping(path = "/sendPushMessage", produces = "application/json")
	@ApiOperation(value = "Envia mensaje push a un cliente/dispositivo.")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Created"),
			@ApiResponse(code = 500, message = "Internal Server Error"),
			@ApiResponse(code = 400, message = "Error en petición", response = ApiError_v2.class) })
	public ResponseEntity<?> sendPushMessage( @RequestBody PushMessageRequest req , @CurrentUser UserDetails userdetails) {
		return messageService.sendFcmPush(req, userdetails);
	}
}
