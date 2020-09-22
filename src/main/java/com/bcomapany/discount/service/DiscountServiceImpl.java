package com.bcomapany.discount.service;


import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.bcomapany.discount.entity.Product;
import com.bcomapany.discount.entity.User;
import com.bcomapany.discount.exceptions.ProdutTypeNotFoundException;
import com.bcomapany.discount.util.ProductCategory;


/*
 * DiscountServiceImpl class which implements DiscoiuntService to provide business logic
 * 
 * */


@Service
public class DiscountServiceImpl implements DiscountService {
	
	private final UserService userService;
	
	private final ProductService productService;
	

	public DiscountServiceImpl(UserService userService, ProductService productService) {
		super();
		this.userService = userService;
		this.productService = productService;
	}


	@Override
	public Map<String, String> getDiscount(String userId, String[] products) throws Exception {
		try {
			
		    User user = userService.getUserById(userId); //Gets user details with given user ID
		    
			int numberOfProducts = products.length; //  number of products given in bill
			
			double totalDiscount = 0.00;
			
			double totalAmount = 0.00;
			
			for(int i = 0; i < numberOfProducts; i++) {
				
				Product product = productService.getProductById(products[i]); // Gets product one by one in loop to get best discount 
				
				totalAmount += product.getPrice();
				String productType = product.getProductType();
				
				if(productType.equalsIgnoreCase(ProductCategory.GROCERIES.toString())) { // If product is grocery then no percentage based discount
					
				  int discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100.00)) * 5; // discount of 5 on each 100 
				  totalDiscount += discoiuntAmountOnEacch100;
				  
				} else if (productType.equalsIgnoreCase(ProductCategory.OTHER.toString())) { // If product is other then gets percentage based discount on basis of user type
					
					int discoiuntAmountOnEacch100 = 0;
					
					switch (user.getUserType().getUserType()) {
						case "Employee":
							            discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100.00)) * 5; // discount of 5 on each 100
							            totalDiscount += discoiuntAmountOnEacch100;
							            totalDiscount += (product.getPrice()*30)/100.00; // Employee gets 30%
							            break;
						case "Affiliate":
									 discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100.00)) * 5;  // discount of 5 on each 100
							            totalDiscount += discoiuntAmountOnEacch100;
							            totalDiscount += (product.getPrice()*10)/100.00;	// Affiliate gets 10%	
							            break;
						case "Regular Customer":
									    discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100.00)) * 5; // discount of 5 on each 100 
							            totalDiscount += discoiuntAmountOnEacch100;
										totalDiscount += (product.getPrice()*5)/100.00; // Customer with more than 2 years history(Regular customer) gets 5%
										break;
						}
				} else {
					throw new ProdutTypeNotFoundException("Product type is not valid"); // if any other category is add by mistake it shows exception
				}
			}
			
			DecimalFormat df = new DecimalFormat("#.##");
			
			Map<String, String> result = new HashMap<String, String>(); // to produce result
			result.put("Total amount was", df.format(totalAmount));
			result.put("Total Disount is", df.format(totalDiscount));
			result.put("After discount payable amount", df.format(totalAmount - totalDiscount));
			
			return result;
			
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
