package com.StoreApp.Repositorys;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.Cart;
import com.StoreApp.Models.CustomerCart;



public interface CartRepository extends CrudRepository<Cart,CustomerCart>{

	public ArrayList<Cart> getCartBycartIdCustomerId(Integer customerId);
	
	@Transactional
	public void deleteBycartIdCustomerId(Integer customerId);
	
}