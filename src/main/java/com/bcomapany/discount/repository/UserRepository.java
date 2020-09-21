package com.bcomapany.discount.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcomapany.discount.entity.User;

/* 
 * This is User interface for repository which extends JpaRepository to provide mapping of entity bean and database corresponding table
 * 
 * */

@Repository
public interface UserRepository extends JpaRepository<User, String>{

	List<User> findByUserFirstName(String userFirstName);
	
	
}
