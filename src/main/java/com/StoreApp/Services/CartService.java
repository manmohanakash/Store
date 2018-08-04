package com.StoreApp.Services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.Cart;
import com.StoreApp.Repositorys.CartRepository;

@Service
public class CartService {

	@Autowired
	private CartRepository CartRepository;
	
	public ArrayList<Cart> getCartForCustomer(Integer customerId){
		return CartRepository.getCartByCartIdCustomerCustomerId(customerId);
	}

	public Cart addItemToCart(Cart cart) {
		return CartRepository.save(cart);
	}

	public void removeItemFromCart(Cart cart) {
		CartRepository.delete(cart);;
	}
	
	public void clearCart(Integer customerId){
		CartRepository.deleteByCartIdCustomerCustomerId(customerId);
	}
	
}
