package com.lendbox.utilities;

import com.lendbox.auth.AuthUser;

public class AuthUserUtilities {

	public boolean checkIfUserCredentialsValid(AuthUser loginCredentialsObject) {
		System.out.println("Username ="+loginCredentialsObject.getUsername());
		System.out.println("Username ="+loginCredentialsObject.getPassword());
		return (loginCredentialsObject.getUsername().equalsIgnoreCase("prateek.jain") && loginCredentialsObject.getPassword().equals("lendbox@test"));
	}
}
