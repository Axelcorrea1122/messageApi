package sube.apps.messageApi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sube.apps.messageApi.entities.ClientAccessKey;


public interface ClientAccesKeyRepository extends JpaRepository<ClientAccessKey, Long>{
	
	@Query("select c from ClientAccessKey c where client_id = :client_id")
	public ClientAccessKey findByClientId(@Param("client_id") String clientId);
	
}
