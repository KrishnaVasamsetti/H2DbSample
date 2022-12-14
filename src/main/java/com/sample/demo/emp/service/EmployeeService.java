package com.sample.demo.emp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.demo.emp.model.Employee;
import com.sample.demo.emp.repository.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo repository;
	
	public List<Employee> getAllEmployees() {
		Iterator<Employee> iterator = repository.findAll().iterator();
		ArrayList<Employee> employees = new ArrayList<Employee>();
		while(iterator.hasNext()) {
			Employee emp = iterator.next();
			employees.add(emp);
		}
		return employees;
	}
	
	public Employee getEmployeeById(int employeeId) {
		Optional<Employee> emp = repository.findById(employeeId);
		if(emp.isPresent()) {
			return emp.get();
		}
		return null;
//		return emp.get();
	}
	
	public Employee insertEmployee(Employee employee) {
		Employee saved = repository.save(employee);
		return saved;
	}
	
	public void deleteEmployee(Employee employee) {
		repository.delete(employee);
	}
	
	public void deleteEmployee(int employeeId) {
		repository.deleteById(employeeId);
	}
	
	public boolean isExists(int employeeId) {
		return repository.existsById(employeeId);
	}
	
	public List<Employee> searchEmployeeByNameOrId(String name) {
		return repository.findByNameContaining(name);
	}

}
