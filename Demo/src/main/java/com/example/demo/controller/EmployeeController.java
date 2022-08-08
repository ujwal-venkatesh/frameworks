package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entity.Employee;
import com.example.demo.response.Response;
import com.example.demo.serviceimpl.EmployeeServiceImpl;

@RestController
@RequestMapping(value = "/Employee")
public class EmployeeController {

	
	@Autowired
	private EmployeeServiceImpl service;

	private static final String get_All_Employee_URL="http://localhost:8088/Employee/getList";
	
	@PostMapping("/save")
	private ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {
		return service.saveEmployee(employee);
	}

	@GetMapping("/getList")
	private ResponseEntity<Object> getEmployees() {
		return service.getEmployee();
	}

//	@PostMapping("/likesearch")
//	private ResponseEntity<Object> searchByAll(@RequestParam String query) throws Exception {
//		return service.searchByAll(query, query, query);
//	}

//	@PostMapping("/Exactsearch")
//	private ResponseEntity<Object> exactSearchByAll(@RequestParam String query) {
//		return service.searchByAll(query, query, query);
//	}

	@PostMapping("/pagination/{offset}/{pageSize}/exactsearch")
	private ResponseEntity<Response<Page<Employee>>> srhByAll(@RequestParam("query") String query,@PathVariable int offset, @PathVariable int pageSize) {
		return service.srhByAll( query, query, query,offset, pageSize);
	}

	@GetMapping("/{fiels}")
	private ResponseEntity<Response<List<Employee>>> getEmployeeWithSort(@PathVariable String field) {
		return service.findEmployeeWithSorting(field);
	}
	
	@GetMapping("/pagination/{offset}/{pageSize}")
	private ResponseEntity<Response<Page<Employee>>> getEmployeeWithSort(@PathVariable int offset, @PathVariable int pageSize) {
		return service.findEmpByPagination(offset, pageSize);
	}
//
// @PostMapping("/search")
// private ResponseEntity<Object> findByFname(@RequestParam String input){
// return service.findByFname(input);
// }
}
