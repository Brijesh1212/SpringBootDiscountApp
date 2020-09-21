package com.bcomapany.discount.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
 * This is UserType entity class which extends IdEntity class to get unique ID and implements Serializable interface 
 * This class uses javax validation to validate the bean
 * This entity gives the type of user which will help to differentiate between users 
 * 
 *  */

@Entity
public class UserType extends IdEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Please provide userType")
	private String userType;
	
	@OneToMany(mappedBy = "userType", targetEntity = User.class)
	@JsonIgnore
	private Set<User> users;
	
	public UserType() {
		super();
	}

	public UserType(@NotEmpty(message = "Please provide userType") String userType) {
		super();
		this.userType = userType;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public UserType(Set<User> users) {
		super();
		this.users = users;
	}

	@Override
	public String toString() {
		return "ID : " + this.getId() + " User Type : " + this.getUserType();
	}

}
