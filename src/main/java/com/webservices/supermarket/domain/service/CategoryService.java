package com.webservices.supermarket.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.supermarket.domain.repository.CategoryRepository;
import com.webservices.supermarket.persistence.model.Category;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Optional<List<Category>> getCategories(){
		return categoryRepository.getCategories();
	}
	
	public Optional<List<Category>> getActiveCategories(){
		return categoryRepository.getActiveCategories();
	}
	
	public Optional<Category> getCategory(int categoryId){
		return categoryRepository.getCategory(categoryId);
	}
	
	public Category save(Category category) {
		return categoryRepository.save(category);
	}
	
	public boolean delete(int categoryId) {
		return getCategory(categoryId).map(category -> {
			categoryRepository.delete(categoryId);
			return true;
		}).orElse(false);
	}

}
