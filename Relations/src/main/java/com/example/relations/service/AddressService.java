package com.example.relations.service;

import org.springframework.http.ResponseEntity;

import com.example.relations.entity.Address;



public interface AddressService {
	public ResponseEntity<Object> saveAddress(Address address);
}
