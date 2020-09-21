package com.bcomapany.discount.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcomapany.discount.service.DiscountService;

@RestController
@RequestMapping("/discount")
public class DiscoiuntController {

	private final DiscountService discountService;

	public DiscoiuntController(DiscountService discountService) {
		super();
		this.discountService = discountService;
	}
	
	@PostMapping("/getDiscount/{totalAmount}/user/{userId}/product/{productId}")
	public ResponseEntity<Map<String, Double>> getDiscount(@PathVariable double totalAmount, @PathVariable String userId, @PathVariable String[] productId) throws Exception {
		try {
			Map<String, Double> result = new HashMap<String, Double>();
			result.put("Total amount was", totalAmount);
			result.put("After discount payable amount", discountService.getDiscount(totalAmount, userId, productId));
			return new ResponseEntity<Map<String, Double>>(result, HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
