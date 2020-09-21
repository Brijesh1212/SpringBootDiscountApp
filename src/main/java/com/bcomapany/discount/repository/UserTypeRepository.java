package com.bcomapany.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcomapany.discount.entity.UserType;

/* 
 * This is UserType interface for repository which extends JpaRepository to provide mapping of entity bean and database corresponding table
 * 
 * */

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, String>{

}
