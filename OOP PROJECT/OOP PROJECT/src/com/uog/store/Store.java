package com.uog.store;
import com.uog.product.Product;
import com.uog.stock.Stock;

public class Store 
{
	public static String csvFile="C:\\Users\\JD Computrz\\Desktop\\Excel\\Store.csv";
	private int STORE_ID;
	private Stock STOCK_ID;
	private Product PRODUCT_ID;
	private String STORE_NAME;
	private String STORE_TYPE;
	private String STORE_DESC;
	private String ADDRESS;
	public Stock getSTOCK_ID()
	{
		return STOCK_ID;
	}
	public void setSTOCK_ID(Stock sTOCK_ID) 
	{
		STOCK_ID = sTOCK_ID;
	}
	public Product getPRODUCT_ID()
	{
		return PRODUCT_ID;
	}
	public void setPRODUCT_ID(Product pRODUCT_ID)
	{
		PRODUCT_ID = pRODUCT_ID;
	}
	public String getADDRESS() 
	{
		return ADDRESS;
	}
	public void setADDRESS(String aDDRESS) 
	{
		ADDRESS = aDDRESS;
	}
	public int getSTORE_ID()
	{
		return STORE_ID;
	}
	public void setSTORE_ID(int sTORE_ID)
	{
		STORE_ID = sTORE_ID;
	}
	
	public String getSTORE_NAME() 
	{
		return STORE_NAME;
	}
	public void setSTORE_NAME(String sTORE_NAME)
	{
		STORE_NAME = sTORE_NAME;
	}
	public String getSTORE_TYPE() 
	{
		return STORE_TYPE;
	}
	public void setSTORE_TYPE(String sTORE_TYPE) 
	{
		STORE_TYPE = sTORE_TYPE;
	}
	public String getSTORE_DESC() 
	{
		return STORE_DESC;
	}
	public void setSTORE_DESC(String sTORE_DESC) 
	{
		STORE_DESC = sTORE_DESC;
	}
	public String toString() 
	{
		String str=null;
		str=this.STORE_ID
				+","+this.STOCK_ID
				+","+this.PRODUCT_ID
				+","+this.STORE_NAME
				+","+this.STORE_TYPE
				+","+this.STORE_DESC
				+"."+this.ADDRESS;
				
		return str;	
	}
}