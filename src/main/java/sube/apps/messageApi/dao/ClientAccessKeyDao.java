package sube.apps.messageApi.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sube.apps.messageApi.entities.ClientAccessKey;
import sube.apps.messageApi.repositories.ClientAccesKeyRepository;

@Service
public class ClientAccessKeyDao{
	
	@Autowired
	private ClientAccesKeyRepository clientAccesKeyRepository;
	
	public ClientAccessKey getClientById(String clientId) {
		return clientAccesKeyRepository.findByClientId(clientId);
	}
	
	public ClientAccessKey save(String key, String clientId) {
		ClientAccessKey clientKey = clientAccesKeyRepository.findByClientId(clientId);
		if(clientKey == null) {
			clientKey = new ClientAccessKey();
			clientKey.setClientId(clientId);
		}
		clientKey.setKey(key);
		clientKey.setInsertionDate(new Date());

		return clientAccesKeyRepository.save(clientKey);
	}
	
}
