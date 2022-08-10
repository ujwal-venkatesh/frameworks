package com.techtree.userinterface.service;

import org.springframework.http.ResponseEntity;

import com.techtree.userinterface.entity.UserProfileBean;

public interface UserService {
	

	ResponseEntity<Object> register(String mobilenumber);

	ResponseEntity<Object> setpin(long uid, String password, String confirmPassword);

	ResponseEntity<Object> verfiyLogIn(long uid, String password);

	ResponseEntity<Object> view(long uid);

	ResponseEntity<Object> update(UserProfileBean user);


}
