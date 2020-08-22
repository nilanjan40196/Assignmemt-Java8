package com.capg.beans;

import java.time.LocalDate;

public class Transaction {
	
	private String transactionId;
	private String accountId;
	private LocalDate postingDate;
	private double amount;
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public LocalDate getPostingDate() {
		return postingDate;
	}
	public void setPostingDate(LocalDate postingDate) {
		this.postingDate = postingDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Transaction(String transactionId, String accountId, LocalDate postingDate, double amount) {
		super();
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.postingDate = postingDate;
		this.amount = amount;
	}
	public Transaction() {
		super();
	}
	
	
	

}
