package edu.uog.timetable;

import edu.uog.campus.Room;
import edu.uog.teacher.TeacherCourse;

public class TimeTable {
	
	public static String csvFile = "C:\\Users\\Hp\\OneDrive\\TimeTable.csv";
    
	private int TIMETABLE_ID;
	
  	private TeacherCourse TEACHERCOURSE_ID;
  	
	private TimeSlot TIMESLOT_ID;
	
	private Room ROOM_ID;

	public int getTIMETABLE_ID() {
		return TIMETABLE_ID;
	}

	public void setTIMETABLE_ID(int tIMETABLE_ID) {
		TIMETABLE_ID = tIMETABLE_ID;
	}

	public TeacherCourse getTEACHERCOURSE_ID() {
		return TEACHERCOURSE_ID;
	}

	public void setTEACHERCOURSE_ID(TeacherCourse tEACHERCOURSE_ID) {
		TEACHERCOURSE_ID = tEACHERCOURSE_ID;
	}

	public TimeSlot getTIMESLOT_ID() {
		return TIMESLOT_ID;
	}

	public void setTIMESLOT_ID(TimeSlot tIMESLOT_ID) {
		TIMESLOT_ID = tIMESLOT_ID;
	}

	public Room getROOM_ID() {
		return ROOM_ID;
	}

	public void setROOM_ID(Room rOOM_ID) {
		ROOM_ID = rOOM_ID;
	}
        public String toString() {
		
		String str = null;
		
		str = this.TIMETABLE_ID
				+ "," + this.TEACHERCOURSE_ID.getSECTION()
				+ "," + this.TIMESLOT_ID.getTIMESLOT_ID()
				+ "," + this.ROOM_ID.getROOM_ID();
			
		return str;
		
	}

		public void setTEACHERCOURSE_ID(String teachercourse_id2) {
			// TODO Auto-generated method stub
			
		}

		public void setTIMESLOT_ID(int timeslot_id2) {
			// TODO Auto-generated method stub
			
		}

		public void setROOM_ID(String room_id2) {
			// TODO Auto-generated method stub
			
		}

		

		public void setTIMESLOT_ID(TimeTable findOne) {
			// TODO Auto-generated method stub
			
		}

}
