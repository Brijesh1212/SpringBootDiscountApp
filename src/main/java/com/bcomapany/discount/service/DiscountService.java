package com.bcomapany.discount.service;


public interface DiscountService {
	
	double getDiscount(double totalAmount, String userId, String[] products) throws Exception;

}
