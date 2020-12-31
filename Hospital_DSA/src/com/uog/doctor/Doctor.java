package com.uog.doctor;


import com.uog.room.Room;
import com.uog.staff.Staff;

public class Doctor {
	private int Doctor_ID;
	private Staff Staff_ID;
	private Room Room_ID;
	private String Specialty;
	public String Display() {
		String str;
		str = "===================================\n\nDoctor ID is--> "+this.Doctor_ID+"\nStaff ID is--> "+this.Staff_ID.getStaff_ID()+"\nStaff Name is--> "+this.Staff_ID.getStaff_Name()
		+"\nSpecialist in--> "+this.Specialty+"\nRoom Number is--> "
		+this.Room_ID.getROOM_NAME()+"\n\n===================================\n";
		
		return str;
	}
	
	public Room getRoom_ID() {
		return Room_ID;
	}

	public void setRoom_ID(Room room_ID) {
		Room_ID = room_ID;
	}

	public int getDoctor_ID() {
		return Doctor_ID;
	}
	public void setDoctor_ID(int doctor_ID) {
		Doctor_ID = doctor_ID;
	}
	
	
	public String getSpecialty() {
		return Specialty;
	}
	public void setSpecialty(String specialty) {
		Specialty = specialty;
	}
	
	public Staff getStaff_ID() {
		return Staff_ID;
	}
	public void setStaff_ID(Staff staff_ID) {
		Staff_ID = staff_ID;
	}
	@Override
	public String toString() {
		String str;
		str = this.Doctor_ID
				+ "," + this.Staff_ID.getStaff_ID()
				+ "," + this.Specialty
				+ "," + this.Room_ID.getROOM_ID();
		
		return str;
	}
	
}
