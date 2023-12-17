package com.map.store.domain.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Store implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private City city;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customer_entry_id")
	private CustomerEntry customerEntry;

	private String latitude;
    private String longitude;
    private String name;
    
    public Store() {};

    public Store(Long id, String latitude, String longitude, String name) {
		this.id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CustomerEntry getCustomerEntry() {
		return customerEntry;
	}

	public void setCustomerEntry(CustomerEntry customerEntry) {
		this.customerEntry = customerEntry;
	}

	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
    
	public City getCity() {
		return city;
	}
	
	public void setCity(City city) {
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
