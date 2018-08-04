package com.StoreApp.Repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.OrderDetail;

public interface OrderRepository extends CrudRepository<OrderDetail,Integer>{

	public Optional<OrderDetail> getOrderItemByOrderId(Integer orderId);
	
	public Optional<OrderDetail> getOrderItemByCustomerId(Integer customerId);

}