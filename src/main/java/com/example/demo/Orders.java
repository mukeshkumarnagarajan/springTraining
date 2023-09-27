package com.example.demo;

import java.util.Date;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	Date createdDate;
	
	@Email(message = "Mail is Invalid")
	String email;
	
	@NotBlank()
	@Pattern(regexp = "^\\d{10}$", message="Invalid Number")
	String mobile;
	
   /**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

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
