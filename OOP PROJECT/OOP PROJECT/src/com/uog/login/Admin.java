package com.uog.login;

import com.uog.person.Person;

public class Admin 
{
	@SuppressWarnings("unused")
	private static String cvsFile = "C:\\Users\\JD Computrz\\Desktop\\Excel\\Admin.csv";	
	
	private int ADMIN_ID;
	private Person Person_ID;
	private String ADMIN_USERNAME;
	private String ADMIN_PASSWORD;
	
	
	public String toString() {
		String str=null;
		
		str=this.ADMIN_ID
				+","+this.Person_ID
				+","+this.ADMIN_USERNAME
				+","+this.ADMIN_PASSWORD;
				
		return str;
	}
	public void show() {
		System.out.println("Admin ID is :"+this.getADMIN_ID()
							+this.Person_ID.show()
							+ "\nAdmin Username :"+this.ADMIN_USERNAME
							+ "\nAdmin Password :"+this.ADMIN_PASSWORD);
	}
	
	public Admin() {
		super();
	}
	public Admin( Person person_ID, String aDMIN_USERNAME, String aDMIN_PASSWORD) {
		
		
		Person_ID = person_ID;
		ADMIN_USERNAME = aDMIN_USERNAME;
		ADMIN_PASSWORD = aDMIN_PASSWORD;
	}
	public int getADMIN_ID() {
		return ADMIN_ID;
	}
	public void setADMIN_ID(int aDMIN_ID) {
		ADMIN_ID = aDMIN_ID;
	}
	public String getADMIN_USERNAME() {
		return ADMIN_USERNAME;
	}
	public void setADMIN_USERNAME(String aDMIN_USERNAME) {
		ADMIN_USERNAME = aDMIN_USERNAME;
	}
	public String getADMIN_PASSWORD() {
		return ADMIN_PASSWORD;
	}
	public void setADMIN_PASSWORD(String aDMIN_PASSWORD) {
		ADMIN_PASSWORD = aDMIN_PASSWORD;
	}
	public Person getPerson_ID() {
		return Person_ID;
	}
	public void setPerson_ID(Person person_ID) {
		Person_ID = person_ID;
	}
	
	
	

}