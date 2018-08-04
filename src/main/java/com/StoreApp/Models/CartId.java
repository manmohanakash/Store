package com.StoreApp.Models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Embeddable
public class CartId implements Serializable{

	private static final long serialVersionUID = 1L;


	@ManyToOne
	@JoinColumn(name="product_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="Fk_Cart_Product"))
	private Product product;
	

	@ManyToOne
	@JoinColumn(name="customer_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="Fk_Cart_Customer"))
	@JsonBackReference
	private Customer customer;


	public CartId() {};
	
	public CartId(Product product, Customer customer) {
		super();
		this.product = product;
		this.customer = customer;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
