package com.bcomapany.discount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bcomapany.discount.entity.User;
import com.bcomapany.discount.repository.UserRepository;

/*
 * UserService implementation to provide business logic
 * DI is done with constructor 
 * 
 * */

@Service
public class UserServiceImpl implements UserService {
	
	private final UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User addUser(User user) throws Exception {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public User updateUser(User user) throws Exception {
		try {
			return userRepository.save(user);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public List<User> getAllUser() throws Exception {
		try {
			return userRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public boolean deleteUserById(String id) throws Exception {
		try {
			 userRepository.deleteById(id);
			 return true;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public User getUserById(String id) throws Exception {
		try {
			return userRepository.findById(id).get();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public List<User> getUserByFirstName(String userFirstName) throws Exception {
		try {
			return userRepository.findByUserFirstName(userFirstName);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	public List<User> saveAll(List<User> users) {
		return userRepository.saveAll(users);
	}
	

}
