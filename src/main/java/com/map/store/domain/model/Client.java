package com.map.store.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@NotBlank
    private String name;
	@OneToOne
	@JsonIgnore
	private Signature signature;
	@OneToOne
	private Store store;
	
	public Client() {};
    
    public Client(Long id, @NotBlank String name, Signature signature) {
		this.id = id;
		this.name = name;
		this.signature = signature;
	}

	public Long getId() {
		return id;
	}
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
