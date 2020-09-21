package com.bcomapany.discount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcomapany.discount.entity.Product;
import com.bcomapany.discount.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Product addProdct(Product product) throws Exception {
		try {
			return productRepository.save(product);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public boolean deleteProduct(String id) throws Exception {
		try {
		   productRepository.deleteById(id);
		   return true;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public Product getProductById(String id) throws Exception {
		try {
			return productRepository.getOne(id);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<Product> saveAll(List<Product> products) throws Exception {
		try {
			return productRepository.saveAll(products);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
