package com.webservices.supermarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.supermarket.persistence.model.Category;

public interface CategoryRepository {
	
	Optional<List<Category>> getCategories();
	Optional<List<Category>> getActiveCategories();
	Optional<Category> getCategory(int categoryId);
	Category save(Category category);

}
