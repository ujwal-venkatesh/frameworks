package com.example.relations.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.relations.entity.Employee;
import com.example.relations.repository.EmployeeRepository;

public class EmployeeServiceImpl {
	
	@Autowired
	EmployeeRepository repository;

	public ResponseEntity<Object> saveEmployee(Employee employee) {
		Employee e=repository.save(employee);
		return new ResponseEntity<Object>(e, HttpStatus.OK);
	}
}
