package com.webservices.supermarket.domain.repository;

import java.util.List;
import java.util.Optional;

import com.webservices.supermarket.persistence.model.Department;

public interface DepartmentRepository {

	List<Department> getAll();
	//Optional<List<Producto>> getByCategory(int categoryId);
	Optional<List<Department>> getActiveDepartments();
	Optional<Department> getDepartment(int departmentId);
	Department save(Department department);
	void delete(int departmentId);
	
}
