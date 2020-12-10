package com.uog.person;
public class Person 
{
	private int Person_ID;
	private String Fore_Name;
	private String Sur_Name;
	private int Age;
	private String Gender;
	private String Address;
public String toString() {
		
		String str = "null";
		str = this.Person_ID
				+ "," + this.Fore_Name
				+ "," + this.Sur_Name
				+ "," + this.Age
				+ "," + this.Gender
				+ "," + this.Address;
				
		return str;
	}
	public String show() {
		String str;
		str="\nPerson ID is :"+this.Person_ID
							+ "\nPerson Forname is :"+this.Fore_Name
							+ "\nPerson Surname is :"+this.Sur_Name
							+ "\nPerson Age is :"+this.Age
							+ "\nPerson Gender is :"+this.Gender
							+ "\nPerson Address is :"+this.Address;
		return str;
	}
	public int getPerson_ID() {
		return Person_ID;
	}
	public void setPerson_ID(int person_ID) {
		Person_ID = person_ID;
	}
	public String getFore_Name() {
		return Fore_Name;
	}
	public void setFore_Name(String fore_Name) {
		Fore_Name = fore_Name;
	}
	public String getSur_Name() {
		return Sur_Name;
	}
	public void setSur_Name(String sur_Name) {
		Sur_Name = sur_Name;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}	
}