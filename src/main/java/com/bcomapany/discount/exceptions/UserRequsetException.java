package com.bcomapany.discount.exceptions;

public class UserRequsetException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserRequsetException(String message) {
		super(message);
	}

	public UserRequsetException(String message, Throwable cause) {
		super(message, cause);
	}
	
	

}
