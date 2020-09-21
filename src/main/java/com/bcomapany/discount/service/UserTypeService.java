package com.bcomapany.discount.service;

import java.util.List;

import com.bcomapany.discount.entity.UserType;

/*
 * This interface provides abstract methods to implement 
 * 
 * 
 * */

public interface UserTypeService {

     UserType addUserType(UserType userType) throws Exception;
     
     UserType updateUserType(UserType userType) throws Exception;
     
     List<UserType> getAllUserType() throws Exception;
     
     boolean deleteUserTypeById(String id) throws Exception;
     
     UserType getUserTypeById(String id) throws Exception;
}
