package sube.apps.messageApi.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import sube.apps.messageApi.context.ApiError_v2;
import sube.apps.messageApi.context.ErrorMessage;

@Service
public class ValidationService {
	
	public ApiError_v2 validateKeyRequest(String key) {
		Map<String, String> errors = new HashMap<>();
		errors.putAll(validateKey(key));
		
		if(errors.size() > 0) {
			return errorBuilder(errors);
		}
		return null;
		
	}
	
	private ApiError_v2 errorBuilder(Map<String, String> errors) {
		ApiError_v2 result = null;

		if (errors.size() > 0) {
			result = new ApiError_v2(ErrorMessage.BAD_REQUEST.toString(), ErrorMessage.BAD_REQUEST.getErrorMessage(),
					errors);
		}
		return result;
	}

	
	private static Map<String, String> validateKey(String key) {
		Map<String, String> result = new HashMap<>();
		if (!KeyUtil.validateKey(key)) {
			result.put("key", ErrorMessage.BAD_REQUEST_ERROR_KEY.getErrorMessage());
		}
		return result;
	}
	
}



