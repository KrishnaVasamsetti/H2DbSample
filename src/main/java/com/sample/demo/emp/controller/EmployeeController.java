package com.sample.demo.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sample.demo.emp.model.Employee;

@Controller
public class EmployeeController {

	@Autowired
	RestTemplate restTemplate;
	
	
	@RequestMapping("/home")
	public String getAllEmployees(Model model) {
		
		HttpEntity<String> entity = new HttpEntity<>(null);
		
		Class<List<Employee>> listOfEmployees = generify(List.class);

		ResponseEntity<List<Employee>> result = restTemplate.exchange("http://localhost:8081/employee/all", HttpMethod.GET, entity, listOfEmployees);
		model.addAttribute("isSuccess", result.getStatusCode()== HttpStatus.OK);
		model.addAttribute("allEmployees", result.getBody());
		
		
		return "employee_home";
	}
	
	@SuppressWarnings("unchecked")
	private static <T> Class<T> generify(Class<?> cls) {
	    return (Class<T>)cls;
	}
	

}
