package com.webservices.supermarket.persistence;

import java.util.List;
import java.util.Optional;

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

	@Override
	public List<Department> getAll() {
		// TODO Auto-generated method stub
		List<Department> departments = departmentDaoRepository.findAll();
		return departments;
	}

	@Override
	public void delete(int departmentId) {
		// TODO Auto-generated method stub
		departmentDaoRepository.deleteById(departmentId);
	}

	@Override
	public Optional<Department> getDepartment(int departmentId) {
		// TODO Auto-generated method stub
		return departmentDaoRepository.findById(departmentId);
	}

	@Override
	public Optional<List<Department>> getActiveDepartments() {
		// TODO Auto-generated method stub
		Optional<List<Department>> departments = departmentDaoRepository.findByState("A");
		return departments;
	}

}
