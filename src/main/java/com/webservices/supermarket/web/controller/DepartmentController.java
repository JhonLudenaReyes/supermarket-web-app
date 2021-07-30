package com.webservices.supermarket.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webservices.supermarket.domain.service.DepartmentService;
import com.webservices.supermarket.persistence.model.Department;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/save")
	public ResponseEntity<Department> save(@RequestBody Department department){
		return new ResponseEntity<>(departmentService.save(department), HttpStatus.CREATED);
	}

}
