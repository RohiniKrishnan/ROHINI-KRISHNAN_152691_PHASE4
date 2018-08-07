package com.cg.spring.paymentwallet.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import com.cg.spring.paymentwallet.dto.Customer;
import com.cg.spring.paymentwallet.exception.PaymentWalletException;

public interface IPaymentWalletService {
	public void createAccount(Customer cust);
	public Customer getLogin(String userid, String pass);
	public BigDecimal showBalance(String userid);
	public void depositAmount(String userId,BigDecimal amount);
	public String withDrawAmount(String userId, BigDecimal amount) throws PaymentWalletException;
	public String fundTransfer(String senderNumber,String receiverNumber,BigDecimal amount) throws PaymentWalletException;
	public String printTransactions(String userId);
	public boolean validate(Customer customer);
	public ArrayList<Customer>showAllCustomer();

}
