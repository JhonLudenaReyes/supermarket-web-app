package com.webservices.supermarket.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Query;

import com.webservices.supermarket.persistence.model.Category;

public interface CategoryDaoRepository extends JpaRepository<Category, Integer> {

	//TRAE LA LISTA DE LAS CATEGORIAS QUE ESTÁN ACTIVAS
	Optional<List<Category>> findByState(String state);
	
	@Query(value = "select d.department_id, d.department, c.category_id, c.category, c.state from departments as d, categories as c where d.department_id = c.department_id and c.state = 'A'", nativeQuery = true)
	Optional<List<Category>> getCategDepat();

}
