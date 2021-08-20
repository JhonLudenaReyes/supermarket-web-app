package com.webservices.supermarket.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.supermarket.domain.repository.CategoryRepository;
import com.webservices.supermarket.persistence.dao.CategoryDaoRepository;
import com.webservices.supermarket.persistence.model.Category;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository{
	
	@Autowired
	private CategoryDaoRepository categoryDaoRepository;

	@Override
	public Optional<List<Category>> getCategories() {
		// TODO Auto-generated method stub
		Optional<List<Category>> categories = categoryDaoRepository.getCategDepat();
		return categories;
	}

}
