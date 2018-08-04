package com.StoreApp.Models;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
@Entity
public class Cart{

	@EmbeddedId
	private CartId cartId;
	
	@Column( columnDefinition="INTEGER(10) UNSIGNED")
	private Integer quantity;

	
	public Cart() {};
	
	public Cart(CartId cartId, Integer quantity) {
		super();
		this.cartId = cartId;
		this.quantity = quantity;
	}

	public CartId getCartId() {
		return cartId;
	}

	public void setCartId(CartId cartId) {
		this.cartId = cartId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


}