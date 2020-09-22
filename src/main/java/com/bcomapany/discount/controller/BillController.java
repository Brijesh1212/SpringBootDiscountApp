package com.bcomapany.discount.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bcomapany.discount.entity.Bill;
import com.bcomapany.discount.service.BillService;

/*
 * Bill controller which will handle API requests related to bills
 * DI is done with constructor
 * 
 * */
@RestController
@RequestMapping("/bill")
public class BillController {

	private final BillService billService;

	public BillController(BillService billService) {
		super();
		this.billService = billService;
	};
	
	@PostMapping("/add")
	public ResponseEntity<Bill> addBill(@RequestBody Bill bill) throws Exception {
		try {
			return new ResponseEntity<Bill>(billService.saveBill(bill), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteByBillId(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<Boolean>(billService.deleteByIdBill(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Bill> getByBillId(@PathVariable String id) throws Exception {
		try {
			return new ResponseEntity<Bill>(billService.getBillById(id), HttpStatus.OK);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
}
