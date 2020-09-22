package com.bcomapany.discount.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcomapany.discount.entity.UserType;
import com.bcomapany.discount.service.UserTypeService;

/*
 * User type controller which will handle API requests related to user type
 * DI is done with constructor
 * 
 * */

@RestController
@RequestMapping("/userType")
public class UserTypeController {
	
	private final UserTypeService userTypeService;
	
	public UserTypeController(UserTypeService userTypeService) {
		super();
		this.userTypeService = userTypeService;
	}

	@PostMapping("/add")
	public ResponseEntity<UserType> addUserType(@RequestBody UserType userType) throws Exception {
		try {
			return new ResponseEntity<UserType>(userTypeService.addUserType(userType), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<UserType> updateUserType(@RequestBody UserType userType) throws Exception {
		try {
			return new ResponseEntity<UserType>(userTypeService.updateUserType(userType), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<UserType>> getAllUserType() throws Exception {
		try {
			return new ResponseEntity<List<UserType>>(userTypeService.getAllUserType(), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteUserTypeById(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<Boolean>(userTypeService.deleteUserTypeById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<UserType> getUserById(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<UserType>(userTypeService.getUserTypeById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

}
