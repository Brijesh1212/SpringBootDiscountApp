package com.bcomapany.discount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bcomapany.discount.entity.Bill;

@Repository
public interface BillRepository extends JpaRepository<Bill, String>{

}
