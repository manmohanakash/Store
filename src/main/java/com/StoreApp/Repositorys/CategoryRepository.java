package com.StoreApp.Repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.StoreApp.Models.Category;


public interface CategoryRepository extends CrudRepository<Category,Integer>{

	public Optional<Category> getCategoryByCategoryId(Integer categoryId);
	
}