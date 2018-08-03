package com.StoreApp.Models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.validation.constraints.Min;

@Entity
public class Cart {

	@EmbeddedId
	private CustomerCart cartId;
	
	@Min(0)
	@Column( columnDefinition="INTEGER(10) UNSIGNED")
	private Integer quantity;
	
	Cart(){}

	public Cart(CustomerCart cartProduct, @Min(1) Integer quantity) {
		super();
		this.cartId = cartProduct;
		this.quantity = quantity;
	}

	public CustomerCart getCartProduct() {
		return cartId;
	}

	public void setCartProduct(CustomerCart cartProduct) {
		this.cartId = cartProduct;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
}
