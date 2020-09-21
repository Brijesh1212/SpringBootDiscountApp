package com.bcomapany.discount.service;

import java.util.List;

import com.bcomapany.discount.entity.Product;

public interface ProductService {
	
	Product addProdct(Product product) throws Exception;
	
	boolean deleteProduct(String id) throws Exception;
	
	Product getProductById(String id) throws Exception;
	
	List<Product> saveAll(List<Product> products) throws Exception;

}
