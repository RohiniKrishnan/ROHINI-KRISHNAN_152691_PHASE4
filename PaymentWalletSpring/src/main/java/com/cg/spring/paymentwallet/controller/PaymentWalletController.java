package com.cg.spring.paymentwallet.controller;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.spring.paymentwallet.dto.Customer;
import com.cg.spring.paymentwallet.exception.PaymentWalletException;
import com.cg.spring.paymentwallet.service.IPaymentWalletService;

@RestController
public class PaymentWalletController {

	@Autowired
    IPaymentWalletService service;

	@RequestMapping(value = "/paymentwallet/create", method = RequestMethod.POST)
	public void createAccount(@RequestBody Customer cust) {
		service.createAccount(cust);
	}

	@RequestMapping(value = "/paymentwallet/balance/{userid}", method = RequestMethod.GET)
	public BigDecimal showBalance(@PathVariable String userid) {
		return service.showBalance(userid);

	}
	
	@RequestMapping(value="/paymentwallet/deposit/{userId}/{amount}", method = RequestMethod.PUT)
	public void depositAmount(@PathVariable String userId,@PathVariable BigDecimal amount) {
		 service.depositAmount(userId, amount);
		
	}
	
	@RequestMapping(value="/paymentwallet/withdraw/{userId}/{amount}", method = RequestMethod.PUT)
	public String withDrawAmount(@PathVariable String userId,@PathVariable BigDecimal amount) {
		 try {
			return service.withDrawAmount(userId, amount);
		} catch (PaymentWalletException e) {
			return e.getMessage();
		}
		
	}
	@RequestMapping(value="/paymentwallet/fundtransfer/{senderId}/{receiverId}/{amount}", method = RequestMethod.PUT)
	public String fundTransfer(@PathVariable String senderId, @PathVariable String receiverId, @PathVariable BigDecimal amount) {
		try {
			return	service.fundTransfer(senderId, receiverId, amount);
		} catch (PaymentWalletException e) {
			// TODO Auto-generated catch block
			return e.getMessage();
		}
	}
	
	@RequestMapping(value="/paymentwallet/print/{userId}",method=RequestMethod.GET)
	public String printTransactions(@PathVariable String userId) {
		return service.printTransactions(userId);
		
	}
	@RequestMapping(value="/paymentwallet/show",method=RequestMethod.GET)
	public ArrayList<Customer> showAllCustomer(){
		return service.showAllCustomer();
	}
}
