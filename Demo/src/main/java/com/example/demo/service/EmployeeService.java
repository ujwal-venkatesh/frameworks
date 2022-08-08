package com.example.demo.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Employee;
import com.example.demo.response.Response;

public interface EmployeeService {
	public ResponseEntity<Object> saveEmployee(Employee employee);

	public ResponseEntity<Object> getEmployee();

	ResponseEntity<Object> searchByAll( String fname, String lname, String email) throws Exception;

	ResponseEntity<Object> srhByAll(String fname, String lname, String email);

//	ResponseEntity<Object> ExactsearchByAll(String fname, String lname, String email);

	ResponseEntity<Response<List<Employee>>> findEmployeeWithSorting(String field);

 Page<Employee> findProductWithPagination(int offset, int pageSize);

// ResponseEntity<Object> findByFname(String input);

	ResponseEntity<Response<Page<Employee>>> findEmpByPagination(int offset, int pageSize);

	ResponseEntity<Response<Page<Employee>>> srhByAll( String fname, String lname,
			String email, int offset, int pagesize);

}
