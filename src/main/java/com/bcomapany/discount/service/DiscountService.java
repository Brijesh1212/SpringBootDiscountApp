package com.bcomapany.discount.service;

import java.util.Map;

/*
 * DiscountService interface which will be implemented by DiscountServiceImpl to provide business logic
 * 
 * */

public interface DiscountService {
	
	Map<String, String> getDiscount(String userId, String[] products) throws Exception;

}
