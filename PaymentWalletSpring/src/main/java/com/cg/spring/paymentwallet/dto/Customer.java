package com.cg.spring.paymentwallet.dto;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "paymentwallet")
public class Customer {

	@Id
	private String userId;
	private String name;
	private String phNumber;
	private String emailId;
	private BigDecimal balance;
	private String password;
	private String transaction;
	public Customer() {
		
	}
	public Customer(String userId, String name, String phNumber, String emailId, BigDecimal balance, String password,
			String transaction) {
		super();
		this.userId = userId;
		this.name = name;
		this.phNumber = phNumber;
		this.emailId = emailId;
		this.balance = balance;
		this.password = password;
		this.transaction = transaction;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNumber() {
		return phNumber;
	}
	public void setPhNumber(String phNumber) {
		this.phNumber = phNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public BigDecimal getBalance() {
		return balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}
	
	

}
