package com.map.store.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class CustomerEntry implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String month;
    private Integer day;
    private Integer customerQuantity;
   
    public CustomerEntry() {};
    
	public CustomerEntry(Long id, String month, Integer day, Integer customerQuantity) {
		this.id = id;
		this.month = month;
		this.day = day;
		this.customerQuantity = customerQuantity;
	}

	public Long getId() {
		return id;
	}
	
	public String getMonth() {
		return month;
	}
	
	public void setMonth(String month) {
		this.month = month;
	}
	
	public Integer getDay() {
		return day;
	}
	
	public void setDay(Integer day) {
		this.day = day;
	}
	
	public Integer getCustomerQuantity() {
		return customerQuantity;
	}
	
	public void setCustomerQuantity(Integer customerQuantity) {
		this.customerQuantity = customerQuantity;
	}
}
