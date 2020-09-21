package com.bcomapany.discount.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.bcomapany.discount.entity.UserType;
import com.bcomapany.discount.repository.UserTypeRepository;

/*
 * This class implements UserTypeRepository to provide business logic
 * 
 * */

@Service
public class UserTypeServiceImpl implements UserTypeService {
	
	private final UserTypeRepository userTypeRepository;

	public UserTypeServiceImpl(UserTypeRepository userTypeRepository) {
		super();
		this.userTypeRepository = userTypeRepository;
	}

	@Override
	public UserType addUserType(UserType userType) throws Exception {
		try {
			return userTypeRepository.save(userType);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public UserType updateUserType(UserType userType) throws Exception {
		try {
			return userTypeRepository.save(userType);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@Override
	public List<UserType> getAllUserType() throws Exception {
		try {
			return userTypeRepository.findAll();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public boolean deleteUserTypeById(String id) throws Exception {
		try {
			userTypeRepository.deleteById(id);
			return true;
		} catch (Exception e) {
			throw new Exception(e);
		}
	}

	@Override
	public UserType getUserTypeById(String id) throws Exception {
		try {
			return userTypeRepository.findById(id).get();
		} catch (Exception e) {
			throw new Exception(e);
		}
	}


}
