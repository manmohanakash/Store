package com.StoreApp.Models;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;


@Entity
public class OrderItem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column( columnDefinition="INTEGER(10) UNSIGNED")
	private Integer	orderId;
	
	@OneToOne 
	@JoinColumn(name="customer_id",foreignKey=@ForeignKey(name="Fk_order_customer"))	
	private Customer customerId;
	
	private Date orderDate;
	
	private Date shippingDate;
	
	@Column(length=50)
	private String tracking;
	
	@Column(nullable=false)
	@Min(0)
	private Integer orderTotal;
	
	@OneToMany(mappedBy="orderId")
	private Collection<OrderDetails> orderDetails = new ArrayList<>();

	public OrderItem(Integer orderId, Customer customerId, Date orderDate, Date shippingDate, String tracking,
			Integer orderTotal, Collection<OrderDetails> orderDetails) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.orderDate = orderDate;
		this.shippingDate = shippingDate;
		this.tracking = tracking;
		this.orderTotal = orderTotal;
		this.orderDetails = orderDetails;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public String getTracking() {
		return tracking;
	}

	public void setTracking(String tracking) {
		this.tracking = tracking;
	}

	public Integer getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(Integer orderTotal) {
		this.orderTotal = orderTotal;
	}

	public Collection<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Collection<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}
	

	
	
}
