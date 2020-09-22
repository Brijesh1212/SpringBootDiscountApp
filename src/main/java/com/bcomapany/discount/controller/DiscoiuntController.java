package com.bcomapany.discount.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcomapany.discount.service.DiscountService;

/*
 * Discount controller handles request related to discount 
 * DI done with constructor
 * 
 * */

@RestController
@RequestMapping("/discount")
public class DiscoiuntController {

	private final DiscountService discountService;

	public DiscoiuntController(DiscountService discountService) {
		super();
		this.discountService = discountService;
	}
	
	@GetMapping("/getDiscount/user/{userId}/product/{productId}")
	public ResponseEntity<Map<String, String>> getDiscount(@PathVariable String userId, @PathVariable String[] productId) throws Exception {
		try {
			return new ResponseEntity<Map<String, String>>(discountService.getDiscount(userId, productId), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
