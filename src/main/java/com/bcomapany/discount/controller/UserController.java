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

import com.bcomapany.discount.entity.User;
import com.bcomapany.discount.service.UserService;

/*
 * This is user controller which will take incoming user api request 
 * DI is done with constructor
 * 
 * */

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<User> addUser(@RequestBody User user) throws Exception {
		try {
			return new ResponseEntity<User>(userService.addUser(user), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@PutMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User user) throws Exception {
		try {
			return new ResponseEntity<User>(userService.updateUser(user), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<User>> getAllUser() throws Exception {
		try {
			return new ResponseEntity<List<User>>(userService.getAllUser(), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteUserById(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<Boolean>(userService.deleteUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<User>(userService.getUserById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getByFirstName/{firstName}")
	public ResponseEntity<List<User>> getUserByFirstName(@PathVariable String firstName) throws Exception {
		try {
			return new ResponseEntity<List<User>>(userService.getUserByFirstName(firstName), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public List<User> saveAllUsers(List<User> users) {
		return userService.saveAll(users);
	}
}
