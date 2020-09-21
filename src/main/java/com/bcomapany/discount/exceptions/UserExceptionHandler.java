package com.bcomapany.discount.exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
	
	@ExceptionHandler(value = {UserRequsetException.class})
	public ResponseEntity<Object> userExceptionHandler(UserRequsetException e) {
		
		UserException userException = new UserException(e.getMessage(),
				                                        HttpStatus.BAD_REQUEST, 
				                                        ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<Object>(userException, HttpStatus.BAD_REQUEST);
	}

}
