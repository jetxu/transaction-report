package com.jet.sample.TransactionReport;

public class TransactionReportBuilderDirector {
	private TransactionReportBuilder transactionReportBuilder;

	public TransactionReportBuilderDirector(TransactionReportBuilder transactionReportBuilder) {
		this.transactionReportBuilder = transactionReportBuilder;
	}

	public void build() {
		this.transactionReportBuilder.buildIncome();
		this.transactionReportBuilder.buildExpense();
		this.transactionReportBuilder.buildSaving();
		this.transactionReportBuilder.buildTopExpneseCategory();
		this.transactionReportBuilder.buildTopExpenseAmount();

	}

	public TransactionReport getReport() {
		return this.transactionReportBuilder.getReport();
	}
}
