package com.webservices.supermarket.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@GetMapping("all")
	public ResponseEntity<List<Department>> getAll() {
		return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
	}
	
	@GetMapping("/active-departments")
	public ResponseEntity<List<Department>> getActiveDepartments(){
		return departmentService.getActiveDepartments()
				.map(departments -> new ResponseEntity<>(departments, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save")
	public ResponseEntity<Department> save(@RequestBody Department department) {
		return new ResponseEntity<>(departmentService.save(department), HttpStatus.CREATED);
	}

	// MODIFICA LOS DATOS DE UN PRODUCTO
	@PutMapping("/update-department")
	public ResponseEntity<Department> updateDepartment(@RequestBody Department department) {
		Optional<Department> optionalDepartment = departmentService.getDepartment(department.getDepartmentId());
		if (optionalDepartment.isPresent()) {
			Department updateDepartment = optionalDepartment.get();
			updateDepartment.setDepartment(department.getDepartment());
			updateDepartment.setState(department.getState());
			return new ResponseEntity<>(departmentService.save(updateDepartment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") int departmentId) {
		return departmentService.getDepartment(departmentId)
				.map(department -> new ResponseEntity<>(department, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable("id") int departmentId) {
		if (departmentService.delete(departmentId)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	// REALIZA UNA ELIMINACIÓN LÓGICA DEL DEPARTAMENTO
	@PutMapping("delete-department-by-id/{departmentId}")
	public ResponseEntity<Department> deleteDepartmentById(@PathVariable("departmentId") int departmentId) {
		Optional<Department> optionalDepartment = departmentService.getDepartment(departmentId);
		if (optionalDepartment.isPresent()) {
			Department updateDepartment = optionalDepartment.get();
			updateDepartment.setState("I");
			return new ResponseEntity<>(departmentService.save(updateDepartment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
