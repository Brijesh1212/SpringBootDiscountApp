package com.bcomapany.discount.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

/*
 * Its an exception bean which provides body of custom exception and details which will be shown to user
 * 
 * */

public class ExceptionDetails {
	
	private final String message;
	
	private final HttpStatus httpStatus;
	
	private final ZonedDateTime timeStamp;
	
	private final String details;

	public ExceptionDetails(String message, HttpStatus httpStatus, ZonedDateTime timeStamp, String details) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
		this.timeStamp = timeStamp;
		this.details = details;
	}


	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public ZonedDateTime getTimeStamp() {
		return timeStamp;
	}


	public String getDetails() {
		return details;
	}
	

}
