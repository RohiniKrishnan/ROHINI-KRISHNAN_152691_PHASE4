package com.cg.spring.paymentwallet.service;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.spring.paymentwallet.dto.Customer;
import com.cg.spring.paymentwallet.exception.IWalletException;
import com.cg.spring.paymentwallet.exception.PaymentWalletException;
import com.cg.spring.paymentwallet.repo.IPaymentWalletRepo;
@Service("paymentService")
public class PayemntWalletServiceImpl implements IPaymentWalletService {
	@Autowired
	 IPaymentWalletRepo repo;
	
	@Override
	public void createAccount(Customer customer) {
		repo.save(customer);
	}

	@Override
	public Customer getLogin(String userid, String pass) {
		Customer customer=repo.findById(userid).get();
		if(customer.getPassword().equals(pass)) {
			return customer;
		}else
		return null;
	}

	@Override
	public BigDecimal showBalance(String userid) {
		
		return repo.findById(userid).get().getBalance();
	}

	@Override
	public void depositAmount(String userId, BigDecimal amount) {
		Customer customer=repo.findById(userId).get();
		customer.setBalance(customer.getBalance().add(amount));
		customer.setTransaction(customer.getTransaction().concat("\n Rupees ")+amount+" deposited.");
		repo.save(customer);
		
	}

	@Override
	public String withDrawAmount(String userId, BigDecimal amount) throws PaymentWalletException {
		Customer customer=repo.findById(userId).get();
		if(customer.getBalance().compareTo(amount)==1) {
		customer.setBalance(customer.getBalance().subtract(amount));
		customer.setTransaction(customer.getTransaction().concat("\n Rupees "+amount+" withdrawn."));
		repo.save(customer);
		return amount+ " Withdrawn";
		}
		else  throw new PaymentWalletException(IWalletException.Error1);
	}

	@Override
	public String fundTransfer(String senderId, String receiverId, BigDecimal amount) throws PaymentWalletException {
		Customer sender=repo.findById(senderId).get();
		if(sender.getBalance().compareTo(amount)==1) {
		sender.setBalance((sender.getBalance()).subtract(amount));
		sender.setTransaction(sender.getTransaction().concat("\n Rupees "+amount+" transfered from "+senderId));
		repo.save(sender);
		
		Customer receiver=repo.findById(receiverId).get();
		receiver.setBalance((receiver.getBalance()).add(amount));
		receiver.setTransaction(receiver.getTransaction().concat("\n Rupees "+amount+" transfered to "+receiverId));
		repo.save(receiver);
		return amount+" Transfered successfull!!";
		}else
			throw new PaymentWalletException(IWalletException.Error1);
	}

	@Override
	public String printTransactions(String userId) {
		
		return repo.findById(userId).get().getTransaction();
	}

	@Override
	public boolean validate(Customer customer) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public ArrayList<Customer> showAllCustomer() {
		ArrayList<Customer>list=new ArrayList<>();
		repo.findAll().forEach(list::add);
		return list;
	}

}
