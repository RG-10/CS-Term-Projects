package com.uog.product;

public class ProductCategory {

	public static String csvFile = "C:\\Users\\JD Computrz\\Desktop\\Excel\\ProductCategory.csv";
	private int ProductCategory_ID;
	private String ProductCategory_NAME;
	private String ProductCategory_TYPE;
	private String ProductCategory_DESC;
	
	public String toString() {
		String str;
		str = this.ProductCategory_ID
				+","+this.ProductCategory_NAME
				+","+this.ProductCategory_TYPE
				+","+this.ProductCategory_DESC;
		return str;
	}
	public int getProductCategory_ID() {
		return ProductCategory_ID;
	}
	public void setProductCategory_ID(int productCategory_ID) {
		ProductCategory_ID = productCategory_ID;
	}
	public String getProductCategory_NAME() {
		return ProductCategory_NAME;
	}
	public void setProductCategory_NAME(String productCategory_NAME) {
		ProductCategory_NAME = productCategory_NAME;
	}
	public String getProductCategory_TYPE() {
		return ProductCategory_TYPE;
	}
	public void setProductCategory_TYPE(String productCategory_TYPE) {
		ProductCategory_TYPE = productCategory_TYPE;
	}
	public String getProductCategory_DESC() {
		return ProductCategory_DESC;
	}
	public void setProductCategory_DESC(String productCategory_DESC) {
		ProductCategory_DESC = productCategory_DESC;
	}
	
	
}