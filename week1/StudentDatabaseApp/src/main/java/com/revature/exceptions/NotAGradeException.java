package com.revature.exceptions;

public class NotAGradeException extends RuntimeException{

	// alt + shift + s -> generate constructors from superclass
	public NotAGradeException(String message) {
		super(message);
		// I will be using this one
	}
	
	// Below are all possible options 0-- only here for demo purposes
	
	public NotAGradeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NotAGradeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	
	
	
}
