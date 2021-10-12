package com.jet.sample.TransactionReport;

import java.math.BigDecimal;

public class TransactionReport {

	public BigDecimal getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(BigDecimal incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public BigDecimal getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(BigDecimal expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	public BigDecimal getSavingAmount() {
		return savingAmount;
	}

	public void setSavingAmount(BigDecimal savingAmount) {
		this.savingAmount = savingAmount;
	}

	public String getTopExpenseCategory() {
		return topExpenseCategory;
	}

	public void setTopExpenseCategory(String topExpenseCategory) {
		this.topExpenseCategory = topExpenseCategory;
	}

	public BigDecimal getTopExpenseAmount() {
		return topExpenseAmount;
	}

	public void setTopExpenseAmount(BigDecimal topExpenseAmount) {
		this.topExpenseAmount = topExpenseAmount;
	}

	private BigDecimal incomeAmount = new BigDecimal("0");
	private BigDecimal expenseAmount = new BigDecimal("0");
	private BigDecimal savingAmount = new BigDecimal("0");

	private String topExpenseCategory;
	private BigDecimal topExpenseAmount =new BigDecimal("0");

}
