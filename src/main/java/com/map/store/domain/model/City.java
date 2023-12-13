package com.map.store.domain.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.inject.internal.Nullable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
public class City implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Store> stores = new ArrayList<Store>();
    @OneToOne
    @JsonIgnore
	private Signature signature;

	public City() {};
    
	public City(Long id, @NotBlank String name, List<Store> stores, Signature signature) {
		this.id = id;
		this.name = name;
		this.stores = stores;
		this.signature = signature;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Store> getStores() {
		return stores;
	}
	
	public void setStores(List<Store> stores) {
		this.stores = stores;
	}
	
	public Signature getSignature() {
		return signature;
	}
	
	public void setSignature(Signature signature) {
		this.signature = signature;
	}
}
