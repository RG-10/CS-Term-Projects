package com.uog.bill;

import com.uog.store.Store;

import com.uog.customer.Customer;
import com.uog.product.Product;

public class Bill 
{
	public static String csvFile="C:\\Users\\JD Computrz\\Desktop\\Excel\\Bill.csv";
	private int BILL_ID;
	private String BILL_NAME;
	private Store STORE_ID;
	private Customer CUSTOMER_ID;
	private Product PRODUCT_ID;
	private String BILL_TYPE;
	private String BILLRECEIPT;
	private String BILL_DESC;
	public int getBILL_ID() 
	{
		return BILL_ID;
	}

	public void setBILL_ID(int bILL_ID) 
	{
		BILL_ID = bILL_ID;
	}

	public String getBILL_NAME() 
	{
		return BILL_NAME;
	}

	public void setBILL_NAME(String bILL_NAME) 
	{
		BILL_NAME = bILL_NAME;
	}

	public Store getSTORE_ID() 
	{
		return STORE_ID;
	}

	public void setSTORE_ID(Store sTORE_ID) 
	{
		STORE_ID = sTORE_ID;
	}

	public Customer getCUSTOMER_ID() 
	{
		return CUSTOMER_ID;
	}

	public void setCUSTOMER_ID(Customer cUSTOMER_ID) 
	{
		CUSTOMER_ID = cUSTOMER_ID;
	}

	public Product getPRODUCT_ID() 
	{
		return PRODUCT_ID;
	}

	public void setPRODUCT_ID(Product pRODUCT_ID) 
	{
		PRODUCT_ID = pRODUCT_ID;
	}

	public String getBILL_TYPE() 
	{
		return BILL_TYPE;
	}

	public void setBILL_TYPE(String bILL_TYPE) 
	{
		BILL_TYPE = bILL_TYPE;
	}

	public String getBILLRECEIPT() 
	{
		return BILLRECEIPT;
	}

	public void setBILLRECEIPT(String bILLRECEIPT) 
	{
		BILLRECEIPT = bILLRECEIPT;
	}

	public String getBILL_DESC() 
	{
		return BILL_DESC;
	}

	public void setBILL_DESC(String bILL_DESC) 
	{
		BILL_DESC = bILL_DESC;
	}
	
	public String toString() 
	{
		String str=null;
		str=this.BILL_ID
				+","+this.BILL_NAME
				+","+this.STORE_ID
				+","+this.CUSTOMER_ID
				+","+this.PRODUCT_ID
				+","+this.BILL_TYPE
				+","+this.BILLRECEIPT
				+","+this.BILL_DESC;
				
		return str;
	}
}