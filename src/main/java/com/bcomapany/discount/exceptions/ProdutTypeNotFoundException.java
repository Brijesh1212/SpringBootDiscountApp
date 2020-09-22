package com.bcomapany.discount.exceptions;


/*
 * Custom product type not fount exception, shown when a product with unknown type encounters
 * 
 * */

public class ProdutTypeNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public ProdutTypeNotFoundException() {
		super();
	}

	public ProdutTypeNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ProdutTypeNotFoundException(String message) {
		super(message);
	}
	
	
	

}
