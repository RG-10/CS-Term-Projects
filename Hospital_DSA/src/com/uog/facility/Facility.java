package com.uog.facility;

public class Facility {
	private int Facility_ID;
	private String Facility_Name;
	private int Facility_Cost;
	public String Display() {
		String str;
		str = "===================================\n\nFacility ID is--> "+this.Facility_ID+"\nFacility Name is--> "+this.Facility_Name+
				"\nFacility Cost is--> "+this.Facility_Cost+"\n\n===================================\n";
		
		return str;
	}
	
	public int getFacility_ID() {
		return Facility_ID;
	}
	public void setFacility_ID(int facility_ID) {
		Facility_ID = facility_ID;
	}
	public String getFacility_Name() {
		return Facility_Name;
	}
	public void setFacility_Name(String facility_Name) {
		Facility_Name = facility_Name;
	}
	public int getFacility_Cost() {
		return Facility_Cost;
	}
	public void setFacility_Cost(int facility_Cost) {
		Facility_Cost = facility_Cost;
	}
	
	@Override
	public String toString() {
		String str;
		str = this.Facility_ID
				+ "," + this.Facility_Name
				+ "," + this.Facility_Cost;
		
		return str;
	}

}
