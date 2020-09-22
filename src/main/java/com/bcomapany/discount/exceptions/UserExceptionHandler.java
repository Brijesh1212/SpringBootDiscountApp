package com.bcomapany.discount.exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/*
 * Custom exception handler which give structured exception as response
 * 
 * */

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> userExceptionHandler(Exception e) {
		
		ExceptionDetails userException = new ExceptionDetails(e.getMessage(),
						                                        HttpStatus.BAD_REQUEST, 
						                                        ZonedDateTime.now(),
						                                        "It occurs due to wrong input or something not exist"
						                                        );
		return new ResponseEntity<Object>(userException, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ProdutTypeNotFoundException.class)
	public ResponseEntity<Object> userOrProductNotFountException(ProdutTypeNotFoundException e) {
		
		ExceptionDetails userException = new ExceptionDetails(e.getMessage(),
												                HttpStatus.BAD_REQUEST, 
												                ZonedDateTime.now(),
												                "It occurs due to wrong input or something not exist"
												                );
       return new ResponseEntity<Object>(userException, HttpStatus.BAD_REQUEST);
	}

}
