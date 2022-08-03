package com.example.relations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.relations.entity.Address;
import com.example.relations.repository.EmployeeRepository;

public class AddressController {
	 @Autowired
	    private EmployeeRepository rep;

	    @PostMapping("/saveEmployee")
	    public Address saveAddress(@RequestBody Address address) {
	        return rep.save(address);
	       
	    }
}
