package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.serviceimpl.RestTemplateService;

@RestController
@RequestMapping("/RestTemplate")
public class RestTemplateController {
	
	@Autowired
	RestTemplateService service;
	
	@GetMapping("/getList")
	public ResponseEntity<Object> getAllEmployee(){
		return service.allEmployee();
		}
}
