package com.jet.sample.TransactionReport;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		List<Transaction> transactions = new ArrayList<Transaction>();
		Transaction t1 = new Transaction("2120", 100, "A");
		transactions.add(t1);
		Transaction t2 = new Transaction("2120", 200, "B");
		transactions.add(t2);
		Transaction t3 = new Transaction("2120", 300, "C");
		transactions.add(t3);

		Transaction t4 = new Transaction("2120", -200, "E");
		transactions.add(t4);
		Transaction t5 = new Transaction("2120", -300, "E");
		transactions.add(t5);

		Transaction t6 = new Transaction("2120", -200, "E");
		transactions.add(t6);
		Transaction t7 = new Transaction("2120", -300, "F");
		transactions.add(t7);

		ConcreteTransactionReportBuilder builder = new ConcreteTransactionReportBuilder(transactions);
		builder.build();
		TransactionReport transactionReport = builder.getReport();

		System.out.println("Total Income:" + transactionReport.getIncomeAmount());
		System.out.println("Total Expnese:" + transactionReport.getExpenseAmount());
		System.out.println("Total Saving:" + transactionReport.getSavingAmount());
		System.out.println("Top Expnese Category:" + transactionReport.getTopExpenseCategory());
		System.out.println("Top Expnese:" + transactionReport.getTopExpenseAmount());
		
		
	}

}
