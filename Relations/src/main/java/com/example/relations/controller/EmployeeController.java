package com.example.relations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.relations.entity.Employee;
import com.example.relations.repository.EmployeeRepository;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository rep;

    @PostMapping("/saveEmployees")
    public Employee saveEmployees(@RequestBody Employee employee) {
        return rep.save(employee);
       
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees(){
        return rep.findAll();
    }
}

