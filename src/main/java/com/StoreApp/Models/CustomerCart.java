package com.StoreApp.Models;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;

@Embeddable
public class CustomerCart implements Serializable {

	private static final long serialVersionUID = 1L;

	@JoinColumn(name="customer_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="Fk_cart_customer"))
	private Integer customerId;
	
	@JoinColumn(name="product_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="Fk_cart_product"))
    private Integer productId;
	
	CustomerCart(){}

	public CustomerCart(Integer customerId, Integer productId) {
		super();
		this.customerId = customerId;
		this.productId = productId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	};
	
	
}
