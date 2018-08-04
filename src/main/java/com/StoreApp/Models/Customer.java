package com.StoreApp.Models;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="INTEGER(10) UNSIGNED")
	private Integer customerId;
	
	@Column(length=25)
	private String firstName;
	
	@Column(length=25)
	private String lastName;
	
	@Column(length=25)
	private String doorNumber;
	
	private String address;
	
	@Column(length=10)
	private String pincode;
	
	@Column(length=25)
	private String city;
	
	@Column(length=25)
	private String country;
	
	
	@Column(length=20)
	private String phone;
	
	@OneToOne
	@JoinColumn(name="user_id",columnDefinition="INTEGER(10) UNSIGNED NOT NULL UNIQUE",foreignKey=@ForeignKey(name="Fk_user_userId"))
	private User userId;
	
	@OneToMany(mappedBy="cartId.customer",fetch=FetchType.LAZY)
	@JsonBackReference
    private Collection<Cart> cart;
	

	public Customer() {}



	public Customer(Integer customerId, String firstName, String lastName, String doorNumber, String address,
			String pincode, String city, String country, String phone, User userId, Collection<Cart> cart) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.doorNumber = doorNumber;
		this.address = address;
		this.pincode = pincode;
		this.city = city;
		this.country = country;
		this.phone = phone;
		this.userId = userId;
		this.cart = cart;
	}




	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	public User getUserId() {
		return userId;
	}


	public void setUserId(User userId) {
		this.userId = userId;
	}


	public Collection<Cart> getCart() {
		return cart;
	}

	public void setCart(Collection<Cart> cart) {
		this.cart = cart;
	}
	
	
		    		   
}