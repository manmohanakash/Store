package com.StoreApp.Services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.StoreApp.Models.Category;
import com.StoreApp.Repositorys.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository CategoryRepository;
	
	public Optional<Category> getCategoryById(Integer categoryId){
		return CategoryRepository.getCategoryByCategoryId(categoryId);
	}

	public Category addCategory(Category category) {
		return CategoryRepository.save(category);
	}
	
}
