package com.sample.demo.emp.repository;

import org.springframework.data.repository.CrudRepository;

import com.sample.demo.emp.model.Employee;

public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
