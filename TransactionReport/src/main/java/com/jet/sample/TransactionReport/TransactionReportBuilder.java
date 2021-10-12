package com.jet.sample.TransactionReport;

public interface TransactionReportBuilder {

	void buildIncome();

	void buildExpense();

	void buildSaving();

	void buildTopExpneseCategory();

	void buildTopExpenseAmount();

	TransactionReport getReport();
	
	void build();
}
