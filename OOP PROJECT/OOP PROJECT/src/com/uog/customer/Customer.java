package com.uog.customer;

import com.uog.bill.Bill;

public class Customer {

	public static String csvFile = "C:\\Users\\JD Computrz\\Desktop\\Excel\\Customer.csv";

	private int CUSTOMER_ID;
	
	private String CUSTOMER_NAME;
	
	private String CUSTOMER_MOBILE;
	
	private String CUSTOMER_EMAIL;
	
	private String CUSTOMER_ADDRESS;
	
	
	
	public int getCUSTOMER_ID() {
		return CUSTOMER_ID;
	}


	public void setCUSTOMER_ID(int cUSTOMER_ID) {
		CUSTOMER_ID = cUSTOMER_ID;
	}

	


	public String getCUSTOMER_NAME() {
		return CUSTOMER_NAME;
	}


	public void setCUSTOMER_NAME(String cUSTOMER_NAME) {
		CUSTOMER_NAME = cUSTOMER_NAME;
	}


	public String getCUSTOMER_MOBILE() {
		return CUSTOMER_MOBILE;
	}


	public void setCUSTOMER_MOBILE(String cUSTOMER_MOBILE) {
		CUSTOMER_MOBILE = cUSTOMER_MOBILE;
	}


	public String getCUSTOMER_EMAIL() {
		return CUSTOMER_EMAIL;
	}


	public void setCUSTOMER_EMAIL(String cUSTOMER_EMAIL) {
		CUSTOMER_EMAIL = cUSTOMER_EMAIL;
	}


	public String getCUSTOMER_ADDRESS() {
		return CUSTOMER_ADDRESS;
	}


	public void setCUSTOMER_ADDRESS(String cUSTOMER_ADDRESS) {
		CUSTOMER_ADDRESS = cUSTOMER_ADDRESS;
	}


	public String toString() {
		String str = null;
		
		str = this.CUSTOMER_ID
				+ "," +this.CUSTOMER_NAME
				+ "," +this.CUSTOMER_MOBILE
				+ "," +this.CUSTOMER_EMAIL
				+ "," +this.CUSTOMER_ADDRESS;
				
				
		return str;
	}

		
	}
	