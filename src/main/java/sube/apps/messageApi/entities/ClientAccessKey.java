package sube.apps.messageApi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@SequenceGenerator(name = "seq_client_access_key", initialValue = 1, allocationSize = 1, sequenceName = "seq_client_access_key")
@Table(name= "client_access_key")
public class ClientAccessKey {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_client_access_key")
	private Long Id;
	private String clientId;
	private String key;
	
	@Column(name = "INSERTION_DATE", updatable = true, nullable = false)
	@CreationTimestamp
	private Date insertionDate;
	
	
	public ClientAccessKey(String clientId, String key, Date insertionDate) {
		super();
		this.clientId = clientId;
		this.key = key;
		this.insertionDate = insertionDate;
	}
	
	
	public ClientAccessKey() {
		super();
	}


	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public Date getInsertionDate() {
		return insertionDate;
	}
	public void setInsertionDate(Date insertionDate) {
		this.insertionDate = insertionDate;
	}
	
	
}
