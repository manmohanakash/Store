package com.StoreApp.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.Product;
import com.StoreApp.Repositorys.ProductRepository;

@Service
public class ProductService{
	
	@Autowired
	private ProductRepository ProductRepository;
	
	public Optional<Product> getProductyById(Integer productId){
		return ProductRepository.getProductByProductId(productId);
	}
	

	public ArrayList<Product> getProductByCategory(Integer categoryId){
		return ProductRepository.getProductByCategory(categoryId);
	}


	public ArrayList<Product> getAllProducts() {
		return (ArrayList<Product>) ProductRepository.findAll();
	}
	
}