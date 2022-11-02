package com.sample.demo.emp.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sample.demo.emp.model.Employee;

/**
 * 
 * <a href='https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods.query-creation'>Click here for Custom queries</a>
 * @author krishna
 *
 */
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
		
	  List<Employee> findByNameOrId(String name, String id);
	  
	 
	  List<Employee> findByNameContaining(String name);

}
