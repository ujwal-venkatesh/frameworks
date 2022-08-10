package com.techtree.userinterface.controller;

import java.io.UnsupportedEncodingException;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techtree.userinterface.entity.User;
import com.techtree.userinterface.entity.UserBean;
import com.techtree.userinterface.entity.UserProfileBean;
import com.techtree.userinterface.serviceimpl.UserServiceImpl;
import com.techtree.userinterface.validation.MobileNumberValidation;
import com.techtree.userinterface.validation.Passwordvalidation;

@Transactional
@Controller
@RequestMapping("/home")
public class UserController {

	@Autowired
	Passwordvalidation passwordvalidation;

	@Autowired
	MobileNumberValidation mobileValidation;

	@Autowired
	UserServiceImpl service;
	
	@PostMapping("/register")
	public ResponseEntity<Object> Registration(@RequestBody UserBean user) {
		try {
				return service.register(user.getMobilenumber());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/setpin")
	public ResponseEntity<Object> setPin(@RequestBody UserBean userBean) {
		try {
			return service.setpin(userBean.getUid(), userBean.getPassword(), userBean.getConfirmpassword());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/verify")
	public ResponseEntity<Object> verfiy(@RequestBody User login) {
		return service.verfiyLogIn(login.getUid(), login.getPassword());	
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<Object> update(@RequestBody UserProfileBean userprofilebean) {
		return service.update(userprofilebean);
	}
	
	@PostMapping("/view/{id}")
	public ResponseEntity<Object> view(@PathVariable("id") Long id){
		return service.view(id);
	}
	
//	@PutMapping("/setpin")
//	public ResponseEntity<Object> setPin(@RequestBody UserBean userBean, BindingResult result)
//			throws UnsupportedEncodingException {
//		try {
//			passwordvalidation.validate(userBean, result);
//			if (result.hasErrors()) {
//				return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
//			}
//			return service.setpin(userBean.getUid(), userBean.getPassword(), userBean.getConfirmpassword());
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
	
//	@PostMapping("/register")
//	public ResponseEntity<Object> Registration(@RequestBody UserBean user, BindingResult result) {
//		try {
//			mobileValidation.validate(user, result);
//				if (result.hasErrors()) {
//					return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
//				}
//				return service.register(user.getMobilenumber());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
//	}
}
