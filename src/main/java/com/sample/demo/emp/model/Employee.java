package com.sample.demo.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Emp")
@Table(name = "Emp")
public class Employee {

	@Id
	@Column
	public int id;

	@Column
	public String name;

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}
