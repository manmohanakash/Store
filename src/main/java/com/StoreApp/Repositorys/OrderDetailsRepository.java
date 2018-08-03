package com.StoreApp.Repositorys;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.OrderDetails;

public interface OrderDetailsRepository extends CrudRepository<OrderDetails,Integer>{

	public ArrayList<OrderDetails> getOrderDetailsByOrderId(Integer orderId);
	
}