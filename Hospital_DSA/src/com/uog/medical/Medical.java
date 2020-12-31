package com.uog.medical;

public class Medical {
	private int Medicine_ID;
	private String Medicine_Name;
	private int Price;
	private String manufacturer;
	public String Display() {
		String str;
		str = "===================================\n\nMedicine ID is--> "+this.Medicine_ID+"\nMedicine Name is--> "+this.Medicine_Name+
				"\nPrice is--> "+this.Price+"\nManufacturing Company is--> "+this.manufacturer+"\n\n===================================\n";
				
		
		return str;
	}
	
	public int getMedicine_ID() {
		return Medicine_ID;
	}
	public void setMedicine_ID(int medicine_ID) {
		Medicine_ID = medicine_ID;
	}
	public String getMedicine_Name() {
		return Medicine_Name;
	}
	public void setMedicine_Name(String medicine_Name) {
		Medicine_Name = medicine_Name;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	
	@Override
	public String toString() {
		String str;
		str = this.Medicine_ID
				+ "," + this.Medicine_Name
				+ "," + this.Price
				+ "," + this.manufacturer;
				
		
		return str;
	}
}
