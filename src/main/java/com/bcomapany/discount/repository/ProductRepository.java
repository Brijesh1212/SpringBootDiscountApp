package com.bcomapany.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bcomapany.discount.entity.Product;

public interface ProductRepository extends JpaRepository<Product, String>{

}
