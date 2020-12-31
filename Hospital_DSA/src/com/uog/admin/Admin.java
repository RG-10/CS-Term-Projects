package com.uog.admin;

import com.uog.staff.Staff;

public class Admin {
	private int Admin_ID;
	private Staff Staff_ID;
	private String Admin_Username;
	private String Admin_Password;
	
	public int getAdmin_ID() {
		return Admin_ID;
	}
	public void setAdmin_ID(int admin_ID) {
		Admin_ID = admin_ID;
	}
	public Staff getStaff_ID() {
		return Staff_ID;
	}
	public void setStaff_ID(Staff staff_ID) {
		Staff_ID = staff_ID;
	}
	public String getAdmin_Username() {
		return Admin_Username;
	}
	public void setAdmin_Username(String admin_Username) {
		Admin_Username = admin_Username;
	}
	public String getAdmin_Password() {
		return Admin_Password;
	}
	public void setAdmin_Password(String admin_Password) {
		Admin_Password = admin_Password;
	}
	@Override
	public String toString() {
		String str;
		str = this.Admin_ID
				+ "," + this.Staff_ID.getStaff_ID()
				+ "," + this.Admin_Username
				+ "," + this.Admin_Password;
		
		return str;
	}
	public String Display() {
		String str;
		str = "===================================\n\nAdmin ID is--> "+this.Admin_ID+"\nStaff ID is--> "+this.Staff_ID.getStaff_ID()+	
		"\nAdmin Name is--> "+this.Admin_Username+"\nAdmin Password is--> "+this.getAdmin_Password()+"\n\n===================================\n";
		
		return str;
	}
	
	
		
	
}
