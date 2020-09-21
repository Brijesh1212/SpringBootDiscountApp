package com.bcomapany.discount.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcomapany.discount.entity.Product;
import com.bcomapany.discount.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private final ProductService productService;

	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception {
		try {
			return new ResponseEntity<Product>(productService.addProdct(product), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<Boolean>(productService.deleteProduct(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Product> getByProductId(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<Product>(productService.getProductById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public List<Product> saveAll(List<Product> products) throws Exception {
		try {
			return productService.saveAll(products);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
