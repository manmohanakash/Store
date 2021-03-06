package com.StoreApp.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.OrderItem;
import com.StoreApp.Repositorys.OrderDetailsRepository;

@Service
public class OrderDetailsService {

	@Autowired
	private OrderDetailsRepository OrderDetailsRepository;
	
	public ArrayList<OrderItem> getOrderDetailsByOrderId(Integer orderId){
		return OrderDetailsRepository.getOrderDetailsByOrderId(orderId);
	}
	
}
