package sube.apps.messageApi.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@SequenceGenerator(name = "SEQ_CLIENT_ACCESS_KEY", initialValue = 1, allocationSize = 1, sequenceName = "SEQ_CLIENT_ACCESS_KEY")
@Table(name = "CLIENT_ACCESS_KEY", uniqueConstraints = {
		@UniqueConstraint(name = "UK_CLIENT_ACCESS_KEY", columnNames = { "clientId" })})
public class ClientAccessKey {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CLIENT_ACCESS_KEY")
	private Long Id;
	private String clientId;
	private String key;
	
	@Column(name = "INSERTION_DATE", updatable = true, nullable = false)
	@CreationTimestamp
	private Date insertionDate;
	
	
	public ClientAccessKey(String clientId, String key) {
		super();
		this.clientId = clientId;
		this.key = key;
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
