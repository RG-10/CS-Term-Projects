package com.uog.staff;

public class Staff {
	private int Staff_ID;
	private String Staff_Name;
	private String Qualification;
	private String Phone_Number;
	private int Age;
	private int Salary;
	private String Staff_Duty;
	public String Display() {
		String str;
		str = "===================================\n\nStaff ID is--> "+this.Staff_ID+"\nStaff Name is--> "+this.Staff_Name+
				"\nQualification is--> "+this.Qualification+"\nPhone Number is--> "+this.Phone_Number+"\nAge is--> "
				+this.Age+"\nSalary is--> "+this.Salary+"\nStaff Duty is--> "+this.Staff_Duty+"\n\n===================================\n";
				
		
		return str;
	}
	
	public int getStaff_ID() {
		return Staff_ID;
	}
	public void setStaff_ID(int staff_ID) {
		Staff_ID = staff_ID;
	}
	public String getStaff_Name() {
		return Staff_Name;
	}
	public void setStaff_Name(String staff_Name) {
		Staff_Name = staff_Name;
	}
	public String getPhone_Number() {
		return Phone_Number;
	}
	public void setPhone_Number(String phone_Number) {
		Phone_Number = phone_Number;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getSalary() {
		return Salary;
	}
	public void setSalary(int salary) {
		Salary = salary;
	}
	public String getStaff_Duty() {
		return Staff_Duty;
	}
	public void setStaff_Duty(String staff_Duty) {
		Staff_Duty = staff_Duty;
	}
	public String getQualification() {
		return Qualification;
	}
	public void setQualification(String qualification) {
		Qualification = qualification;
	}
	public String toString() {
		String str;
		str = this.Staff_ID
				+ "," + this.Staff_Name
				+ "," + this.Staff_Duty
				+ "," + this.Qualification
				+ "," + this.Age
				+ "," + this.Salary
				+ "," + this.Phone_Number;
		return str;
		
	}

}
