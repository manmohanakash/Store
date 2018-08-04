package com.StoreApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.OrderDetail;
import com.StoreApp.Repositorys.OrderRepository;



@Service
public class OrderItemService{
	
	@Autowired
	private OrderRepository OrderRepository;
	
	public Optional<OrderDetail> getOrderItemByOrderId(Integer orderId){
		return OrderRepository.getOrderItemByOrderId(orderId);
	}
	

	public Optional<OrderDetail> getOrderItemByCustomerId(Integer customerId){
		return OrderRepository.getOrderItemByCustomerId(customerId);
	}
	
}