package com.bcomapany.discount.service;

import com.bcomapany.discount.entity.Bill;


/*
 * BillService interface which will be implemented by BillServiceImpl to provide business logic
 * 
 * */

public interface BillService {

	Bill saveBill(Bill bill) throws Exception;
	
	boolean deleteByIdBill(String id) throws Exception;
	
	Bill getBillById(String id) throws Exception;
}
