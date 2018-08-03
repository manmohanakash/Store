package com.StoreApp.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class OrderDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="INTEGER(50) UNSIGNED")
	private Integer orderDetailsId;
	
	
	@ManyToOne
	@JoinColumn(name="order_id",foreignKey=@ForeignKey(name="Fk_order_orderDetails"))
	private OrderItem orderId;
	
	
	@OneToOne 
	@JoinColumn(name="product_id",columnDefinition="INTEGER(10) UNSIGNED",foreignKey=@ForeignKey(name="Fk_orderDetails_product"))	
	private Product	product;
	
	@Column(columnDefinition="INTEGER(10) UNSIGNED")
	private Integer quantity;
	
	@Column(nullable=false)
	private Integer unitPrice=1;
	
	

	OrderDetails(){}

	public OrderDetails(OrderItem orderId, Product product, Integer quantity, Integer unitPrice) {
		this.orderId = orderId;
		this.product = product;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	public OrderItem getOrderId() {
		return orderId;
	}

	public void setOrderId(OrderItem orderId) {
		this.orderId = orderId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(Integer unitPrice) {
		this.unitPrice = unitPrice;
	}

	
}
