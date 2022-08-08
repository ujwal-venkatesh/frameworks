package com.example.relations.service;

import org.springframework.http.ResponseEntity;

import com.example.relations.bean.EmployeeBean;
import com.example.relations.entity.Employee;

public interface EmployeeService {

	ResponseEntity<Object> saveAll(EmployeeBean employee);


//	ResponseEntity<Object> findAll(Employee employee);

//	public ResponseEntity<Object> save(EmployeeBean employee);

//	ResponseEntity<Object> saveAll(EmployeeBean employee);
}
