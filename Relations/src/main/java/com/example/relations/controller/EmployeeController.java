package com.example.relations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.relations.bean.EmployeeBean;
import com.example.relations.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService  service;

//    @PostMapping("/saveEmployees")
//    public ResponseEntity<Object> saveEmployees(@RequestBody EmployeeBean employee) {
//        return service.save(employee);  
//    }
    
    @PostMapping("/saveEmployees")
    public ResponseEntity<Object> saveEmployees(@RequestBody EmployeeBean employee) {
        return service.saveAll(employee);  
    }
//
//    @GetMapping("/getEmployees")
//    public ResponseEntity<Object> getEmployees(@RequestBody Employee employee){
//        return service.findAll(employee);
//    }
}

