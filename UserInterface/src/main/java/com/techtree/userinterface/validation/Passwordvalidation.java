package com.techtree.userinterface.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techtree.userinterface.entity.UserBean;



@Component
public class Passwordvalidation implements Validator {
	private static final String password_Format="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,15}$";
//			"^[((?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]))((?=.*[0-9])(?=.*[a-z])(?=.*[@$]))((?=.*[@$])(?=.*[a-z])(?=.*[A-Z]))](?=\\S+$).{8,20}$";

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public  void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors,"id", "id is empty");
		ValidationUtils.rejectIfEmpty(errors, "password", "password is empty");
//		ValidationUtils.rejectIfEmpty(errors,"ConfirmPassword", "ConfirmPassword is empty");
		UserBean u= (UserBean)target;
		if(!u.getPassword().matches(password_Format)){
			errors.rejectValue("password", "not matching");
		}

	}

}
