package com.atm.main.customer;

public class Customer {

	public static String CustomerFile = "customer.csv";
	
	private int customerId;
	
	private String customerName;
	
	private int customerAge;
	
	private long customerBalance;
	
	private int customerNoOfTransactions;
	
	public Customer() {}

	public Customer(int customerId, String customerName, int customerAge, long customerBalance,int customerNoOfTransactions) {
		
		this.customerId = customerId;
		
		this.customerName = customerName;
		
		this.customerAge = customerAge;
		
		this.customerBalance = customerBalance;
		
		this.customerNoOfTransactions = customerNoOfTransactions;
	}

	
	
	public String toStringSave() {
		return customerId + ","+ customerName + ","+ customerAge+ ","+ customerBalance + ","+ customerNoOfTransactions;
		
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerAge() {
		return customerAge;
	}

	public void setCustomerAge(int customerAge) {
		this.customerAge = customerAge;
	}

	public long getCustomerBalance() {
		return customerBalance;
	}

	public void setCustomerBalance(long customerBalance) {
		this.customerBalance = customerBalance;
	}

	public int getCustomerNoOfTransactions() {
		return customerNoOfTransactions;
	}

	public void setCustomerNoOfTransactions(int customerNoOfTransactions) {
		this.customerNoOfTransactions = customerNoOfTransactions;
	}
	@Override
	public String toString() {
		
		return "Id=" + customerId + ","
				+ " Name = " + customerName + ","
				+ " Age = " + customerAge	+ ","
				+ " Balance = " + customerBalance + ","
				+ " Totall-Transactions = " + customerNoOfTransactions;
	
	
	
}
}
