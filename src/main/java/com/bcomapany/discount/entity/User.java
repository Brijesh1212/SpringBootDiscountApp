package com.bcomapany.discount.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*
 * This is user entity class which extends IdEntity class to get unique ID and implements Serializable interface 
 * This class uses javax validation to validate the bean
 *  
 *  */

@Entity
public class User extends IdEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
    @NotEmpty(message = "Please provide first name")
	@Size(min = 3, max = 25, message = "Minimum letters 3, max 25") // Max and min size of string is 25 and 3
	private String userFirstName;
	
    @NotEmpty(message = "Please provide last name")
	@Size(min = 3, max = 25, message = "Minimum letters 3, max 25") // Max and min size of string is 25 and 3
	private String userLastName;
		
    @NotEmpty(message = "Please provide phone number")
    @Digits(fraction = 0, integer = 10, message = "Please provide valid number") // To get numbers
	@Size(min = 10, max = 10, message = "Please proivide valid number") // Max and min size of phone number is 10
    private String phoneNumber;
	
	@NotEmpty(message = "Please provide email ID")
	@Email(message = "Please provide valid email ID") // Validate
	private String emailId;
	
	
	@OneToOne(cascade = CascadeType.MERGE, orphanRemoval = true)
	@JoinColumn(name = "userTypeId")
	private UserType userType;
	
	@OneToMany(mappedBy = "user", targetEntity = Bill.class)
	private List<Bill> bills;
	
	public User() {
		super();
	}

	public User(
			@NotEmpty(message = "Please provide first name") @Size(min = 3, max = 25, message = "Minimum letters 3, max 25") String userFirstName,
			@NotEmpty(message = "Please provide last name") @Size(min = 3, max = 25, message = "Minimum letters 3, max 25") String userLastName,
			@NotEmpty(message = "Please provide phone number") @Digits(fraction = 0, integer = 10, message = "Please provide valid number") @Size(min = 10, max = 10, message = "Please proivide valid number") String phoneNumber,
			@NotEmpty(message = "Please provide email ID") @Email(message = "Please provide valid email ID") String emailId, UserType userType) {
		super();
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.userType = userType;
	}

	public String getUserFirstName() {
		return userFirstName;
	}

	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}

	public String getUserLastName() {
		return userLastName;
	}

	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public UserType getUserType() {
		return userType;
	}

	public void setUserType(UserType userType) {
		this.userType = userType;
	}
	
	public List<Bill> getBills() {
		return bills;
	}
	
	@Override
	public String toString() {
		return "User ID : " + this.getId() + " First Name : " + this.getUserFirstName() + " Last Name : " + this.getUserLastName() 
		+ " Phone Number : " + this.getPhoneNumber() + " Email-ID : " + this.getEmailId() + " User Type : " + this.getUserType();
	}

}
