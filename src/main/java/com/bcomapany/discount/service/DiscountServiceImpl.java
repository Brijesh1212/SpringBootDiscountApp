package com.bcomapany.discount.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bcomapany.discount.entity.Product;
import com.bcomapany.discount.entity.User;
import com.bcomapany.discount.exceptions.UserRequsetException;
import com.bcomapany.discount.util.ProductCategory;

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
	public double getDiscount(double totalAmount, String userId, String[] products) throws Exception {
		try {
			User user = userService.getUserById(userId);
			int numberOfProducts = products.length;
			double payableAmount = totalAmount;
//			Bill bill = new Bill();
			List<Product> productsArr = new ArrayList<Product>();
			for(int i = 0; i < numberOfProducts; i++) {
				Product product = productService.getProductById(products[i]);
				if(product.getProductType().equalsIgnoreCase(ProductCategory.GROCERIES.toString())) { 
				  int discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100)) * 5;
				  payableAmount -= discoiuntAmountOnEacch100;
				} else {
					int discoiuntAmountOnEacch100 = 0;
					switch (user.getUserType().getUserType()) {
						case "Employee":
							            discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100)) * 5;
							            payableAmount -= discoiuntAmountOnEacch100;
							            payableAmount -= (product.getPrice()*30)/100;
							            break;
						case "Affiliate":
									 discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100)) * 5;
							            payableAmount -= discoiuntAmountOnEacch100;
							            payableAmount -= (product.getPrice()*10)/100;		
							            break;
						case "Regular Customer":
									    discoiuntAmountOnEacch100 = ((int) (product.getPrice()/100)) * 5;
							            payableAmount -= discoiuntAmountOnEacch100;
													payableAmount -= (product.getPrice()*5)/100;
										break;
						}
				}
				productsArr.add(product);
			}
//			bill.setAfterDiscountPayableAmount(payableAmount);
//			bill.setBestDiscount(bill.getTotalAmount() - payableAmount);
//			bill.setProduct(productsArr);
//			bill.setUser(user);
			
//			return billService.saveBill(bill);
			return payableAmount;
			
		}  catch (UserRequsetException e) {
			throw new UserRequsetException("User request failed");
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
