package com.example.relations.service;

import org.springframework.http.ResponseEntity;

import com.example.relations.entity.Employee;



public interface EmployeeService {
	public ResponseEntity<Object> saveEmployee(Employee employee);
}
