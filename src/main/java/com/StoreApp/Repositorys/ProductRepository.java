package com.StoreApp.Repositorys;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{
	
	public Optional<Product> getProductByProductId(Integer productId);

	public ArrayList<Product> getProductByCategory(Integer categoryId);
	
}
