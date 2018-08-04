package com.StoreApp.Repositorys;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.Cart;
import com.StoreApp.Models.CartId;



public interface CartRepository extends CrudRepository<Cart,CartId>{

	public ArrayList<Cart> getCartByCartIdCustomerCustomerId(Integer customerId);
	
	@Transactional
	public void deleteByCartIdCustomerCustomerId(Integer customerId);
	
}