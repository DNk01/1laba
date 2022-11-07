package com.example.brootforce.PasswordValidator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordValidatorService {
	private static final String PASSWORD_PATTERN = "((?=.*d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	private final Pattern pattern;

	public PasswordValidatorService() {
		pattern = Pattern.compile(PASSWORD_PATTERN);
	}

	public boolean validate(String password) {
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}
}
