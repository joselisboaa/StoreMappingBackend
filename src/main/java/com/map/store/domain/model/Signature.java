package com.map.store.domain.model;

import java.io.Serializable;

import org.hibernate.type.descriptor.sql.internal.CapacityDependentDdlType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Entity
@Data
public class Signature implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Client client;
    
    public Signature() {};
    
	public Signature(Long id, Client client, City city) {
		this.id = id;
		this.client = client;
	}

	public Long getId() {
		return id;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
}
