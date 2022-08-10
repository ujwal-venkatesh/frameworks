package com.techtree.userinterface.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.techtree.userinterface.entity.UserBean;


@Component
public class MobileNumberValidation implements Validator {

	private final static String MobileNumberFormat = "[6-9][0-9]{9,11}";

	@Override
	public boolean supports(Class<?> clazz) {
		return UserBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "MobileNumber", "Moble Number is empty");
		UserBean user=(UserBean) target;
		if(!user.getMobilenumber().matches(MobileNumberFormat)) {
			errors.rejectValue("MobileNumber", "Mobile Number is not matching");
		}
	}
	
}

