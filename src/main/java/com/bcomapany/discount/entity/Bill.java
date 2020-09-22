package com.bcomapany.discount.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.bcomapany.discount.util.UniqueIdGenerator;

/*
 * Bill entity mapped to database but not required now
 * 
 * */

@Entity
public class Bill {
	
	@Id
	@GeneratedValue(generator = UniqueIdGenerator.generatorName) // UniqueIdGenerator class will generate unique ID
	@GenericGenerator(name = UniqueIdGenerator.generatorName, strategy = "com.bcomapany.discount.util.UniqueIdGenerator" )
	private String id;

	@ManyToMany(cascade = CascadeType.MERGE)
	@JoinColumn(name = "productId")
	private List<Product> product;
	
	private double totalAmount;
	
	private double bestDiscount;
	
	private double afterDiscountPayableAmount;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "userId")
	private User user;

	public Bill() {
		super();
	}

	public Bill(List<Product> product, double totalAmount, double bestDiscount, double afterDiscountPayableAmount,
			User user) {
		super();
		this.product = product;
		this.totalAmount = totalAmount;
		this.bestDiscount = bestDiscount;
		this.afterDiscountPayableAmount = afterDiscountPayableAmount;
		this.user = user;
	}
	
	public String getId() {
		return id;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public double getBestDiscount() {
		return bestDiscount;
	}

	public void setBestDiscount(double bestDiscount) {
		this.bestDiscount = bestDiscount;
	}

	public double getAfterDiscountPayableAmount() {
		return afterDiscountPayableAmount;
	}

	public void setAfterDiscountPayableAmount(double afterDiscountPayableAmount) {
		this.afterDiscountPayableAmount = afterDiscountPayableAmount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	
}
