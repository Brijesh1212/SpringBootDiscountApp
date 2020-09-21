package com.bcomapany.discount.service;

import org.springframework.stereotype.Service;

import com.bcomapany.discount.entity.Bill;
import com.bcomapany.discount.repository.BillRepository;

/*
 * BillService implementation which provides business logic
 * DI done with constructor
 * 
 * */

@Service
public class BillServiceImpl implements BillService {
	
	private final BillRepository billRepository;

	public BillServiceImpl(BillRepository billRepository) {
		super();
		this.billRepository = billRepository;
	}

	@Override
	public Bill saveBill(Bill bill) throws Exception {
		try {
			return billRepository.save(bill);
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public boolean deleteByIdBill(String id) throws Exception {
		try {
			 billRepository.deleteById(id);
			 return true;
		} catch (Exception e) {
			throw new Exception();
		}
	}

	@Override
	public Bill getBillById(String id) throws Exception {
		try {
			return billRepository.findById(id).get();
		} catch (Exception e) {
			throw new Exception();
		}
	}

}
