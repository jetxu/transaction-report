package com.jet.sample.TransactionReport;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors; 

public class ConcreteTransactionReportBuilder implements TransactionReportBuilder {

	private List<Transaction> transactions = new ArrayList<Transaction>();

	TransactionReport transactionReport = new TransactionReport();

	public ConcreteTransactionReportBuilder(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	 
	public void buildIncome() {
		BigDecimal incomeAmount = transactions.stream().map(ts -> ts.getAmount()).filter(item -> item.doubleValue() > 0)
				.reduce(new BigDecimal("0"), (a, b) -> {
					return a.add(b);
				});
		transactionReport.setIncomeAmount(incomeAmount);
	}

	@Override
	public void buildExpense() {
		BigDecimal expenseAmount = transactions.stream().map(ts -> ts.getAmount())
				.filter(item -> item.doubleValue() < 0).reduce(new BigDecimal("0"), (a, b) -> {
					return a.add(b);
				});
		transactionReport.setExpenseAmount(expenseAmount);
	}

	@Override
	public void buildSaving() {
		this.transactionReport.setSavingAmount(
				this.transactionReport.getIncomeAmount().add(this.transactionReport.getExpenseAmount()));
	}

	@Override
	public void buildTopExpneseCategory() {

		Map<String, List<Transaction>> map = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCategory));

		BigDecimal min = new BigDecimal("0");

		String topExpenseCategory = "";

		for (Entry<String, List<Transaction>> entry : map.entrySet()) {

			List<Transaction> list = entry.getValue();
			BigDecimal t = new BigDecimal("0");
			for (int j = 0; j < list.size(); j++) {
				t = t.add(list.get(j).getAmount());
			}
			if (t.compareTo(min) == -1) {
				min = t;
				topExpenseCategory = entry.getKey();
			}
		}

		this.transactionReport.setTopExpenseCategory(topExpenseCategory);
	}

 
	public void buildTopExpenseAmount() {

		Map<String, List<Transaction>> map = transactions.stream()
				.collect(Collectors.groupingBy(Transaction::getCategory));
		BigDecimal min = new BigDecimal("0");

		for (Entry<String, List<Transaction>> entry : map.entrySet()) {

			List<Transaction> list = entry.getValue();
			BigDecimal t = new BigDecimal("0");
			for (int j = 0; j < list.size(); j++) {
				t = t.add(list.get(j).getAmount());
			}
			if (t.compareTo(min) == -1) {
				min = t;
			}
		}

		this.transactionReport.setTopExpenseAmount(min);
	}

	@Override
	public TransactionReport getReport() {

		return this.transactionReport;
	}

	@Override
	public void build() {
		this.buildIncome();
		this.buildExpense();
		this.buildSaving();

		this.buildTopExpneseCategory();
		this.buildTopExpenseAmount();
	}

}
