package com.bcomapany.discount.service;

import com.bcomapany.discount.entity.Bill;

public interface BillService {

	Bill saveBill(Bill bill) throws Exception;
	
	boolean deleteByIdBill(String id) throws Exception;
	
	Bill getBillById(String id) throws Exception;
}
