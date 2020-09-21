package com.bcomapany.discount.entity;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Product extends IdEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private String productName;
	
	private String productType;
	
	private double price;

	public Product() {
		super();
	}

	public Product(String productName, String productType, double price) {
		super();
		this.productName = productName;
		this.productType = productType;
		this.price = price;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Product ID: " + this.getId() + " Product Name: " + this.getProductName() + " Product Type: " + this.getProductType() + " Price: " + this.getPrice();
	}
	

}
