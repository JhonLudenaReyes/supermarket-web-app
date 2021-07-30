package com.webservices.supermarket.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservices.supermarket.persistence.model.Department;

public interface DepartmentDaoRepository extends JpaRepository<Department, Integer>{

}
