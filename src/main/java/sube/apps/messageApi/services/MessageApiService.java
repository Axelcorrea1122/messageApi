package sube.apps.messageApi.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MessageApiService {
	
	@Value("${firebase.cloud.messaging.key}")
	private String fcmKey;
	@Value("${firebase.cloud.messaging.url.base}${firebase.cloud.messaging.url.send}")
	private String fcmUri;
	
	private HttpHeaders createHeaderJsonWithAuthKey() {
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.AUTHORIZATION, "Key=" + fcmKey);
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
	public ResponseEntity<?> saveClient(String key, String clientId){
		// AQUI VA LA LOGICA
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	
	public ResponseEntity<?> sendFcmPush(String deviceToken, String message){
		//AQUI VA LA LOGICA
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
}
