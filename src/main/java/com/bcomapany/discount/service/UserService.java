package com.bcomapany.discount.service;

import java.util.List;

import com.bcomapany.discount.entity.User;

/*
 * UserService interface which will be implemented by UserServiceImpl to provide business logic
 * 
 * */

public interface UserService {
	
     User addUser(User user) throws Exception;
     
     User updateUser(User user) throws Exception;
     
     List<User> getAllUser() throws Exception;
     
     boolean deleteUserById(String id) throws Exception;
     
     User getUserById(String id) throws Exception;
     
     List<User> getUserByFirstName(String name) throws Exception;
     
     List<User> saveAll(List<User> users);

}
