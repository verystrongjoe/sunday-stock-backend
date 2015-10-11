package org.skeleton.core.validator;

import org.skeleton.mvc.entity.Users;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TestValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(Users.class);
	}

	@Override
	public void validate(Object o, Errors errors) {
		Users user = (Users) o;
		validateToken(user.getPassword(), errors);
	}

	private void validateToken(String pwd, Errors errors) {
		if(pwd == null || pwd.equals(""))  errors.rejectValue("token", "foo", "Token is invalid");
	}

}