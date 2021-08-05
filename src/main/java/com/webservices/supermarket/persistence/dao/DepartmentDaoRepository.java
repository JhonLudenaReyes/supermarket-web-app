package com.webservices.supermarket.persistence.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.supermarket.persistence.model.Department;

public interface DepartmentDaoRepository extends JpaRepository<Department, Integer>{
	
	Optional<List<Department>> findByState(String state);
}
