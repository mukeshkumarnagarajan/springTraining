package com.example.demo;

import java.util.Date;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Orders {
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	Integer id;
	
	@NotBlank(message = "Item name cannot be blank")
	String item;
	
	@Min(value = 1, message = "Price cannot be negative")
	float price;
	
	Date createdDate;
	
   public Date getCreatedDate() {
		return createdDate;
	}
   
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
    public String getItem() {
		return item;
	}
    
	public void setItem(String item) {
		this.item = item;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
		this.price = price;
	}
 
 
}
