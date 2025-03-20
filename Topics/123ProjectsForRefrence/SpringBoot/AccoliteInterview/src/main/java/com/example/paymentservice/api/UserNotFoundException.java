package com.example.paymentservice.api;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException() {
	
		super("User not found");
	}
}
