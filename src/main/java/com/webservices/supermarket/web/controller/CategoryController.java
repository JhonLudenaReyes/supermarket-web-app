package com.webservices.supermarket.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.supermarket.domain.service.CategoryService;
import com.webservices.supermarket.persistence.model.Category;

@RestController
@RequestMapping("/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/department-with-categories")
	public ResponseEntity<List<Category>> getCategories(){
		return categoryService.getCategories()
				.map(categories -> new ResponseEntity<>(categories, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
