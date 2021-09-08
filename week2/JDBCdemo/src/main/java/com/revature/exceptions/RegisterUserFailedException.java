package com.revature.exceptions;

public class RegisterUserFailedException extends RuntimeException{

	private static final long serialVersionUID = -2019034035947439975L;

	public RegisterUserFailedException(String message) {
		super(message);
		// This is the constructor I'll be passing a specific message to
		
	}
	

}
