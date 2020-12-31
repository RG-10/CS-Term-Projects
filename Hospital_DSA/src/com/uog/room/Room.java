package com.uog.room;

public class Room {

	private int ROOM_ID;
	private String ROOM_NAME;
	private int ROOM_FLOOR;
	private int ROOM_CAPACITY;
	private String ROOM_TYPE;
	
	public String Display() {
		String str;
		str = "===================================\n\nRoom ID is--> "+this.ROOM_ID+"\nRoom Name is--> "+this.ROOM_NAME+
				"\nFloor is--> "+this.ROOM_FLOOR+"\nRoom Capacity is--> "+this.ROOM_CAPACITY+"\nRoom type is--> "+this.ROOM_TYPE+"\n\n===================================\n";
				
		
		return str;
	}
	
	public Room() {
		super();
	}
	public Room( String rOOM_NAME, int rOOM_FLOOR, int rOOM_CAPACITY, String rOOM_TYPE) {
		super();
		
		ROOM_NAME = rOOM_NAME;
		ROOM_FLOOR = rOOM_FLOOR;
		ROOM_CAPACITY = rOOM_CAPACITY;
		ROOM_TYPE = rOOM_TYPE;
	}
	
	public int getROOM_ID() {
		return ROOM_ID;
	}
	public void setROOM_ID(int rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}
	public String getROOM_NAME() {
		return ROOM_NAME;
	}
	public void setROOM_NAME(String rOOM_NAME) {
		ROOM_NAME = rOOM_NAME;
	}
	public int getROOM_FLOOR() {
		return ROOM_FLOOR;
	}
	public void setROOM_FLOOR(int rOOM_FLOOR) {
		ROOM_FLOOR = rOOM_FLOOR;
	}
	public int getROOM_CAPACITY() {
		return ROOM_CAPACITY;
	}
	public void setROOM_CAPACITY(int rOOM_CAPACITY) {
		ROOM_CAPACITY = rOOM_CAPACITY;
	}
	public String getROOM_TYPE() {
		return ROOM_TYPE;
	}
	public void setROOM_TYPE(String rOOM_TYPE) {
		ROOM_TYPE = rOOM_TYPE;
	}
	
	public String toString() {
		
		String str;
		str = this.ROOM_ID 
				+ "," + this.ROOM_NAME
				+ ","+ this.ROOM_TYPE
				+ "," + this.ROOM_CAPACITY
				+ ","+ this.ROOM_FLOOR;
				
				
		return str;
	}
public String ToString() {
		
		String str;
		str = this.ROOM_ID 
				+ "," + this.ROOM_NAME
				+ ","+ this.ROOM_TYPE
				+ "," + this.ROOM_CAPACITY
				+ ","+ this.ROOM_FLOOR;
				
				
		return str;
	}
}
