package com.StoreApp.Repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.OrderItem;

public interface OrderRepository extends CrudRepository<OrderItem,Integer>{

	public Optional<OrderItem> getOrderItemByOrderId(Integer orderId);
	
	public Optional<OrderItem> getOrderItemByCustomerId(Integer customerId);

}