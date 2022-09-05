package com.sample.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.emp.model.Employee;
import com.sample.demo.emp.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
	
//	@PostMapping("add/id/name")
//	public void insert(int id, String name) {
//		
//	}

	@GetMapping("add")
	public Employee insert() {
		Employee emp = new Employee();
		emp.id = 3;
		emp.name = "Krishna";
		return employeeService.insertEmployee(emp);
	}
	
	@GetMapping("add/{id}/{name}")
	public Employee insert(@PathVariable("id") int id, @PathVariable("name") String name) {
		Employee emp = new Employee();
		emp.id = id;
		emp.name = name;
		return employeeService.insertEmployee(emp);
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "Deleted successfully";
	}
}
