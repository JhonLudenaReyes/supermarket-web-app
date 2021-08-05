package com.webservices.supermarket.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservices.supermarket.domain.repository.DepartmentRepository;
import com.webservices.supermarket.persistence.model.Department;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getAll(){
		return departmentRepository.getAll();
	}
	
	public Optional<List<Department>> getActiveDepartments(){
		return departmentRepository.getActiveDepartments();
	}
	
	public Department save(Department department) {
		return departmentRepository.save(department);
	}
	
	public Optional<Department> getDepartment(int departmentId){
		return departmentRepository.getDepartment(departmentId);
	}
	
	public boolean delete(int departmentId) {
		return getDepartment(departmentId).map(department -> {
			departmentRepository.delete(departmentId);
			return true;
		}).orElse(false);
	}

}
