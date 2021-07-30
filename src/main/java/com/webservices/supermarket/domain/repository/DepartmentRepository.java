package com.webservices.supermarket.domain.repository;

import com.webservices.supermarket.persistence.model.Department;

public interface DepartmentRepository {

	//List<Producto> getAll();
	//Optional<List<Producto>> getByCategory(int categoryId);
	//Optional<List<Producto>> getScaresProducts(int quantity);
	//Optional<Producto> getProduct(int productId);
	Department save(Department department);
	//void delete(int productId);
	
}
