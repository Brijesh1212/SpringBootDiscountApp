package com.bcomapany.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcomapany.discount.entity.Product;

/* 
 * This is Product interface for repository which extends JpaRepository to provide mapping of entity bean and database corresponding table
 * 
 * */

@Repository
public interface ProductRepository extends JpaRepository<Product, String>{

}
