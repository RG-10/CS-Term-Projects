package com.uog.patient;

import com.uog.doctor.Doctor;

public class Patient {

	private int Patient_ID;
	private String Patient_Name;
	private String Disease;
	private String DateOfBirth;
	private String Gender;
	private String Weight;
	private String Status;
	private String Address;
	private Doctor Doc_App;
	public String Display() {
		String str;
		str = "===================================\n\nPatient ID is--> "+this.Patient_ID+"\nPatient Name is--> "+this.Patient_Name+"\nDoctor Appointed is--> "+this.Doc_App.getStaff_ID().getStaff_Name()+
				"\nDisease is--> "+this.Disease+"\nGender is--> "+this.Gender+"\nWeight[kg] is--> "+this.Weight+"\nStatus is--> "+this.Status+"\nAddress is--> "+this.Address+"\n\n===================================\n";
				
		
		return str;
	}
	public String DisplayWithOutDoctor() {
		String str;
		str = "===================================\n\nPatient ID is--> "+this.Patient_ID+"\nPatient Name is--> "+this.Patient_Name+
				"\nDisease is--> "+this.Disease+"\nGender is--> "+this.Gender+"\nWeight is--> "+this.Weight+"\nStatus is--> "+this.Status+"\nAddress is--> "+this.Address+"\nDoctor for this Record not found :(\n===================================\n";
				
		
		return str;
	}
	public int getPatient_ID() {
		return Patient_ID;
	}
	public void setPatient_ID(int patient_ID) {
		Patient_ID = patient_ID;
	}
	public String getPatient_Name() {
		return Patient_Name;
	}
	public void setPatient_Name(String patient_Name) {
		Patient_Name = patient_Name;
	}
	public String getDisease() {
		return Disease;
	}
	public void setDisease(String disease) {
		Disease = disease;
	}
	public String getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getWeight() {
		return Weight;
	}
	public void setWeight(String weight) {
		Weight = weight;
	}
	public String isStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	public Doctor getDoc_App() {
		return Doc_App;
	}

	public void setDoc_App(Doctor doc_App) {
		Doc_App = doc_App;
	}

	public String getStatus() {
		return Status;
	}

	@Override
	public String toString() {
		String str;
		str = this.Patient_ID
				+ "," + this.Patient_Name
				+ "," + this.Gender
				+ "," + this.Weight
				+ "," + this.Address
				+ "," + this.Disease
				+ "," + this.Status
				+ "," + this.Doc_App.getStaff_ID().getStaff_ID();
		
		return str;
	}
	
}
