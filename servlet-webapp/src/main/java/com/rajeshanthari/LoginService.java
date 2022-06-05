package com.rajeshanthari;

public class LoginService {
	public boolean validateUser(String user, String password) {
		return user.equalsIgnoreCase("rajesh") && password.equals("anthari");
	}

}