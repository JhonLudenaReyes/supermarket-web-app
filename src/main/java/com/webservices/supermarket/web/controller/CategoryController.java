package com.webservices.supermarket.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/save")
	public ResponseEntity<Category> save(@RequestBody Category category) {
		return new ResponseEntity<>(categoryService.save(category), HttpStatus.CREATED);
	}
	
	// MODIFICA LOS DATOS DE UN PRODUCTO
		@PutMapping("/update-category")
		public ResponseEntity<Category> updateCategory(@RequestBody Category category) {
			Optional<Category> optionalCategory = categoryService.getCategory(category.getCategoryId());
			if (optionalCategory.isPresent()) {
				Category updateCategory = optionalCategory.get();
				updateCategory.setCategory(category.getCategory());
				updateCategory.setDepartmentId(category.getDepartmentId());
				updateCategory.setState(category.getState());
				return new ResponseEntity<>(categoryService.save(updateCategory), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
