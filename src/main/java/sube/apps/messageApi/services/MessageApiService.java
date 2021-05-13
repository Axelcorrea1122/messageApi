package sube.apps.messageApi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import sube.apps.messageApi.context.ApiError_v2;
import sube.apps.messageApi.dao.ClientAccessKeyDao;

@Service
public class MessageApiService {
	
	@Value("${firebase.cloud.messaging.key}")
	private String fcmKey;
	@Value("${firebase.cloud.messaging.url.base}${firebase.cloud.messaging.url.send}")
	private String fcmUri;
	@Autowired
	private ValidationService validationService;
	
	@Autowired
	private ClientAccessKeyDao clientAccessKeyDao;
	
	private HttpHeaders createHeaderJsonWithAuthKey() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Key=" + fcmKey);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	public ResponseEntity<?> saveClientKey(String key, String clientId){
		ApiError_v2 apiError = validationService.validateKeyRequest(key);
		
		if (apiError != null) {
			return ResponseEntity.badRequest().body(apiError);
		}
		
		clientAccessKeyDao.save(key, clientId);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	public ResponseEntity<?> sendFcmPush(String deviceToken, String message){
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
