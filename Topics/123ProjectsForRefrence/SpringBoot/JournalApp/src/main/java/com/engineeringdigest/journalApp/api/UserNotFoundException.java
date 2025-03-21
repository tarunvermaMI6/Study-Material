package com.engineeringdigest.journalApp.api;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
	
		super("User not found");
	}
}
