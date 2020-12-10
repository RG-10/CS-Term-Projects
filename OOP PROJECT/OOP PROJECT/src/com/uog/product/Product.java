package com.uog.product;

public class Product {
	public static String csvFile = "C:\\Users\\JD Computrz\\Desktop\\Excel\\Product.csv";
	private int PRODUCT_ID;
	private String PRODUCT_NAME;
	private int PRODUCT_PRICE;
	private ProductCategory PRODUCDCATEGORY_ID;
	private String PRODUCT_DESC;
	private String MANUFACTURE_DATE;
	private String EXPIRY_DATE;
	
	public int getPRODUCT_ID() 
	{
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(int pRODUCT_ID) 
	{
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getPRODUCT_NAME() 
	{
		return PRODUCT_NAME;
	}
	public void setPRODUCT_NAME(String pRODUCT_NAME) 
	{
		PRODUCT_NAME = pRODUCT_NAME;
	}
	public int getPRODUCT_PRICE() 
	{
		return PRODUCT_PRICE;
	}
	public void setPRODUCT_PRICE(int pRODUCT_PRICE) 
	{
		PRODUCT_PRICE = pRODUCT_PRICE;
	}
	public ProductCategory getPRODUCDCATEGORY_ID() 
	{
		return PRODUCDCATEGORY_ID;
	}
	public void setPRODUCDCATEGORY_ID(ProductCategory pRODUCDCATEGORY_ID) 
	{
		PRODUCDCATEGORY_ID = pRODUCDCATEGORY_ID;
	}
	public String getPRODUCT_DESC() 
	{
		return PRODUCT_DESC;
	}
	public void setPRODUCT_DESC(String pRODUCT_DESC) 
	{
		PRODUCT_DESC = pRODUCT_DESC;
	}
	public String getMANUFACTURE_DATE() 
	{
		return MANUFACTURE_DATE;
	}
	public void setMANUFACTURE_DATE(String mANUFACTURE_DATE) 
	{
		MANUFACTURE_DATE = mANUFACTURE_DATE;
	}
	public String getEXPIRY_DATE() 
	{
		return EXPIRY_DATE;
	}
	public void setEXPIRY_DATE(String eXPIRY_DATE) 
	{
		EXPIRY_DATE = eXPIRY_DATE;
	}
	public String toString() 
	{
		String str;
		str = this.PRODUCT_ID
				+","+this.PRODUCT_NAME
				+","+this.PRODUCDCATEGORY_ID
				+","+this.PRODUCT_PRICE
				+","+this.MANUFACTURE_DATE
				+","+this.EXPIRY_DATE
				+","+this.PRODUCT_DESC;
		return str;
	}	
}