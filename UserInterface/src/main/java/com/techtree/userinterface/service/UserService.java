package com.techtree.userinterface.service;

import org.springframework.http.ResponseEntity;

import com.techtree.userinterface.entity.User;
import com.techtree.userinterface.entity.UserProfile;

public interface UserService {
	 public	ResponseEntity<Object> register(UserProfile user);



	ResponseEntity<Object> setpin(User id);
}
