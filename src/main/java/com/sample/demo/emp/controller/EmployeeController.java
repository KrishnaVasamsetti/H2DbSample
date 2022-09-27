package com.sample.demo.emp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.sample.demo.emp.model.Employee;
import com.sample.demo.helper.SuccessDTO;

@Controller
public class EmployeeController {

	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/home")
	public String getAllEmployees(Model model) {
		
		HttpEntity<String> entity = new HttpEntity<>(null);
		
		Class<List<Employee>> listOfEmployees = generify(List.class);

		String getUrl = "http://localhost:8081/employee/all";
		ResponseEntity<List<Employee>> result = restTemplate.exchange(getUrl, HttpMethod.GET, entity, listOfEmployees);
		model.addAttribute("isSuccess", result.getStatusCode()== HttpStatus.OK);
		model.addAttribute("allEmployees", result.getBody());
		
		
		return "employee_home";
	}
	
	@PostMapping("saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		System.out.println("Employee:"+employee);
		System.out.println("EmployeeDetails:"+employee.id+"  Name: "+employee.name);
		String saveUrl = "http://localhost:8081/employee/create";
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Employee> entity = new HttpEntity<Employee>(employee, headers);
		ResponseEntity<Employee> result = restTemplate.exchange(saveUrl, HttpMethod.POST, entity, Employee.class);
		System.out.println("Res:"+result.getBody());
		return "//:redirect";
	}
	
	@RequestMapping("addEmployee")
	public String addEmployee(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "employee_add";
	}
	
	@RequestMapping("updateEmployee/{id}")
	public String updateEmployee(@PathVariable ( value = "id") int id, Model model) {
		
		String getEmployeeByIdUrl = "http://localhost:8081/employee/get/"+id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Integer> entity = new HttpEntity<>(headers);
		ResponseEntity<Employee> result = restTemplate.exchange(getEmployeeByIdUrl, HttpMethod.GET, entity, Employee.class);
		
		Employee employee = result.getBody();
//		Employee employee = new Employee();
		System.out.println("Employee:"+employee);
		
		model.addAttribute("employee", employee);
		return "employee_add";
	}
	

	@RequestMapping("deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable ( value = "id") int id) {
		
		String getEmployeeByIdUrl = "http://localhost:8081/employee/delete/"+id;
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Integer> entity = new HttpEntity<>(headers);
		ResponseEntity<String> result = restTemplate.exchange(getEmployeeByIdUrl, HttpMethod.DELETE, entity, String.class);
		
		String message = result.getBody();
//		Employee employee = new Employee();
		System.out.println("message:"+message);
		return "redirect:/home";
	}
	
	@SuppressWarnings("unchecked")
	private static <T> Class<T> generify(Class<?> cls) {
	    return (Class<T>)cls;
	}
	
}

class BaseResponse<T> {
	
	
	private String message = "";
	private T body;
	
	public BaseResponse() {
	}
	
	public BaseResponse(T body, String message) {
		this.body = body;
		this.message = message;
	}
	
	public T getBody() {
		return body;
	}
	public void setBody(T body) {
		this.body = body;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
