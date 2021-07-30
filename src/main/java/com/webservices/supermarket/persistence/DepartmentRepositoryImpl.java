package com.webservices.supermarket.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservices.supermarket.domain.repository.DepartmentRepository;
import com.webservices.supermarket.persistence.dao.DepartmentDaoRepository;
import com.webservices.supermarket.persistence.model.Department;

@Repository
public class DepartmentRepositoryImpl implements DepartmentRepository{
	
	@Autowired
	private DepartmentDaoRepository departmentDaoRepository;

	@Override
	public Department save(Department department) {
		// TODO Auto-generated method stub
		return departmentDaoRepository.save(department);
	}

}
