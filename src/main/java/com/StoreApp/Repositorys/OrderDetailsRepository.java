package com.StoreApp.Repositorys;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.OrderItem;

public interface OrderDetailsRepository extends CrudRepository<OrderItem,Integer>{

	public ArrayList<OrderItem> getOrderDetailsByOrderId(Integer orderId);
	
}