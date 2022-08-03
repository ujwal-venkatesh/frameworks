package com.example.relations.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.relations.entity.Address;
import com.example.relations.repository.AddressRepository;

public class AddressEmployeeImpl {
	@Autowired
	AddressRepository repository;

	public ResponseEntity<Object> saveAddress(Address address) {
		Address e=repository.save(address);
		return new ResponseEntity<Object>(e, HttpStatus.OK);
	}
}
