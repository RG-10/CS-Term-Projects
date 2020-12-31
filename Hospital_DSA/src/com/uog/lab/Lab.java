package com.uog.lab;

import com.uog.staff.Staff;

public class Lab {
	private int Appratus_ID;
	private String Lab_Name;
	private Staff Supervisor;
	private String Apparatus;
	private String Lab_Detail;
	public String Display() {
		String str;
		str = "===================================\n\nApparatus ID is--> "+this.Appratus_ID+"\nLab Name is--> "+this.Lab_Name+
				"\nSuperVisor Staff ID is--> "+this.Supervisor.getStaff_ID()+"\nSupervisor Name is--> "+this.Supervisor.getStaff_Name()+"\nApparatus Name is"
				+this.Apparatus+"\nLab Detail is--> "+this.Lab_Detail+"\n\n===================================\n";
		
		return str;
	}
	
	public int getAppratus_ID() {
		return Appratus_ID;
	}
	public void setAppratus_ID(int appratus_ID) {
		Appratus_ID = appratus_ID;
	}
	public String getLab_Name() {
		return Lab_Name;
	}
	public void setLab_Name(String lab_Name) {
		Lab_Name = lab_Name;
	}
	public String getLab_Detail() {
		return Lab_Detail;
	}
	public void setLab_Detail(String lab_Detail) {
		Lab_Detail = lab_Detail;
	}
	public Staff getSupervisor() {
		return Supervisor;
	}
	public void setSupervisor(Staff supervisor) {
		Supervisor = supervisor;
	}
	public String getApparatus() {
		return Apparatus;
	}
	public void setApparatus(String apparatus) {
		Apparatus = apparatus;
	}
	@Override
	public String toString() {
		String str;
		str = this.Appratus_ID
				+ "," + this.Lab_Name
				+ "," + this.Supervisor.getStaff_ID()
				+ "," + this.Apparatus
				+ "," + this.Lab_Detail;
		
		return str;
	}
}
