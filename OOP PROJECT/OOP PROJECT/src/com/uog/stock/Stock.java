package com.uog.stock;
public class Stock 
{
	public static String csvFile="C:\\Users\\JD Computrz\\Desktop\\Excel\\Stock.csv";
	private int STOCK_ID;
	private String STOCK_NAME;
	private String STOCK_TYPE;
	private String STOCK_NUMBER;
	private String STOCK_DESC;
	private String ISSUE_DATE;
	
	public String getISSUE_DATE() {
		return ISSUE_DATE;
	}
	public void setISSUE_DATE(String iSSUE_DATE) {
		ISSUE_DATE = iSSUE_DATE;
	}
	public int getSTOCK_ID() {
		return STOCK_ID;
	}
	public void setSTOCK_ID(int sTOCK_ID) {
		STOCK_ID = sTOCK_ID;
	}
	
	public String getSTOCK_NAME() {
		return STOCK_NAME;
	}
	public void setSTOCK_NAME(String sTOCK_NAME) {
		STOCK_NAME = sTOCK_NAME;
	}
	public String getSTOCK_TYPE() {
		return STOCK_TYPE;
	}
	public void setSTOCK_TYPE(String sTOCK_TYPE) {
		STOCK_TYPE = sTOCK_TYPE;
	}
	public String getSTOCK_NUMBER() {
		return STOCK_NUMBER;
	}
	public void setSTOCK_NUMBER(String sTOCK_NUMBER) {
		STOCK_NUMBER = sTOCK_NUMBER;
	}
	public String getSTOCK_DESC() {
		return STOCK_DESC;
	}
	public void setSTOCK_DESC(String sTOCK_DESC) {
		STOCK_DESC = sTOCK_DESC;
	}
	
	public String toString() {
		String str;
		str=this.STOCK_ID
			+","+this.STOCK_NAME
			+","+this.STOCK_TYPE
			+","+this.STOCK_NUMBER
			+","+this.STOCK_DESC
			+","+this.ISSUE_DATE;
		return str;
	}
}