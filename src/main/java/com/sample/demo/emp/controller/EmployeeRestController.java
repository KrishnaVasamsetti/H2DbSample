package com.sample.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.sample.demo.emp.model.Employee;
import com.sample.demo.emp.service.EmployeeService;
import com.sample.demo.helper.ErrorDTO;
import com.sample.demo.helper.SuccessDTO;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeService employeeService;


	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getEmployeeById(@PathVariable("id") int id) {
		Employee emp = employeeService.getEmployeeById(id);
		if(emp != null) {
			SuccessDTO<Employee> success = new SuccessDTO<Employee>(emp, "Success");
			return ResponseEntity.ok(success);
		}
		else {
			ErrorDTO<Employee> error = new ErrorDTO<Employee>(null, "No employee exist with id");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(error);
			return ResponseEntity.ok(error);
		}
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<Employee> getEmployeeByIdLatest(@PathVariable("id") int id) {
		Employee emp = employeeService.getEmployeeById(id);
		if(emp != null) {
			return ResponseEntity.ok(emp);
		}
		else {
			return ResponseEntity.noContent().build();
		}
	}

	@PostMapping("create")
	public Employee insert(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}

	@PutMapping("add/{id}/{name}")
	public Employee insert(@PathVariable("id") int id, @PathVariable("name") String name) {
		Employee emp = new Employee();
		emp.id = id;
		emp.name = name;
		return employeeService.insertEmployee(emp);
	}

	@PutMapping("update")
	public Employee update(@RequestBody Employee employee) {
		return employeeService.insertEmployee(employee);
	}

	@DeleteMapping("delete/{id}")
	public String delete(@PathVariable("id") int id) {
		employeeService.deleteEmployee(id);
		return "Deleted successfully";
	}
}
