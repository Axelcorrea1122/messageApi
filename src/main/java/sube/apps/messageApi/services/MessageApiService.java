package sube.apps.messageApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import sube.apps.messageApi.context.ApiError_v2;
import sube.apps.messageApi.context.ErrorMessage;
import sube.apps.messageApi.dao.ClientAccessKeyDao;
import sube.apps.messageApi.dtos.MobilePushRequest;
import sube.apps.messageApi.dtos.MobilePushResponse;
import sube.apps.messageApi.dtos.PushMessageRequest;
import sube.apps.messageApi.entities.ClientAccessKey;
import sube.apps.messageApi.entities.UserDetails;

@Service
public class MessageApiService {

//	@Value("${firebase.cloud.messaging.key}")
//	private String fcmKey;
	@Value("${firebase.cloud.messaging.url.base}${firebase.cloud.messaging.url.send}")
	private String fcmUri;
	@Autowired
	private ValidationService validationService;

	@Autowired
	private ClientAccessKeyDao clientAccessKeyDao;

	private HttpHeaders createHeaderJsonWithAuthKey(String key) {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "key=" + key);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}

	public ResponseEntity<?> saveClientKey(String key, String clientId) {
		ApiError_v2 apiError = validationService.validateKeyRequest(key);
		if (apiError != null) {
			return ResponseEntity.badRequest().body(apiError);
		}
		clientAccessKeyDao.save(key, clientId);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}

	public ResponseEntity<?> sendFcmPush(PushMessageRequest req, UserDetails userdetails) {

		ClientAccessKey clientAccessKey = clientAccessKeyDao.getClientById(req.getClient());
		if (clientAccessKey == null) {
			return ResponseEntity.badRequest().body(new ApiError_v2(ErrorMessage.BAD_REQUEST_ERROR_KEY.toString(),
					ErrorMessage.BAD_REQUEST_ERROR_KEY.getErrorMessage()));
		}
		HttpHeaders headers = createHeaderJsonWithAuthKey(clientAccessKey.getKey());
		HttpEntity<?> entity = new HttpEntity<>(new MobilePushRequest(req.getTo(), req.getNotification(), req.getData()), headers);
		try {
			new RestTemplate().exchange(fcmUri, HttpMethod.POST,
					entity, MobilePushResponse.class);
		} catch (HttpClientErrorException e) {
			return ResponseEntity.badRequest().body(new ApiError_v2(ErrorMessage.FCM_PUSH_NOTIFICATION_ERROR.toString(),
					ErrorMessage.FCM_PUSH_NOTIFICATION_ERROR.getErrorMessage()));
		}
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
