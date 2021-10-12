package com.jet.sample.TransactionReport;

import java.math.BigDecimal;

public class Transaction {

	private String date;
	private BigDecimal amount;

	private String category;

	public Transaction() {

	}

	public Transaction(String date, double amount, String category) {
		this.date = date;
		this.amount = new BigDecimal(amount);
		this.category = category;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = new BigDecimal(amount);
	}

	public String getCategory() {
		return category;
	}

	public String getDate() {
		return date;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setDate(String datea) {
		this.date = date;
	}

}
