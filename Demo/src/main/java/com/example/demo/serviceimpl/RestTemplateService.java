package com.example.demo.serviceimpl;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestTemplateService {
	
	
	RestTemplate restTemplate=new RestTemplate();
	
	private static final String get_All_Employee_URL="http://localhost:8088/Employee/getList";

	
	public ResponseEntity<Object> allEmployee(){
	HttpHeaders headers=new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	
	HttpEntity<Object> entity=new HttpEntity<Object>("param", headers);
	
	ResponseEntity<Object> response=restTemplate.exchange(get_All_Employee_URL, HttpMethod.GET, entity, Object.class);
	return response;
	}
}
