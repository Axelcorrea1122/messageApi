package sube.apps.messageApi.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sube.apps.messageApi.entities.ClientAccessKey;
import sube.apps.messageApi.repositories.ClientAccesKeyRepository;

@Service
public class ClientAccessKeyDao {
	
	@Autowired
	private ClientAccesKeyRepository clientAccesKeyRepository;
	
	public ClientAccessKey getClientById(String clientId) {
		return clientAccesKeyRepository.findByClientId(clientId);
	}
	
}
