package edu.uog.timetable;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.campus.roomData;
import edu.uog.teacher.teacherCourseData;

public class timeTableData {
	@SuppressWarnings("resource")
	public static List<TimeTable> findAll() {
		
		List<TimeTable> timetables = new ArrayList<TimeTable>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeTable.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TimeTable timetable = new TimeTable();
				
				String[] timetableRow = line.split(",");
				
				timetable.setTIMETABLE_ID(Integer.parseInt(timetableRow[0]));
				timetable.setTEACHERCOURSE_ID(teacherCourseData.findOne(Integer.parseInt(timetableRow[1])));
				timetable.setTIMESLOT_ID(timeSlotData.findOne(Integer.parseInt(timetableRow[2])));
				timetable.setROOM_ID(roomData.findOne(Integer.parseInt(timetableRow[3])));
				
				 
				
				 timetables.add(timetable);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return timetables;
		
	}
@SuppressWarnings("resource")
public static TimeTable findOne(int timetable_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeTable.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TimeTable timetable = new TimeTable();
				
				String[] timetableRow = line.split(",");
				
				if(Integer.parseInt(timetableRow[0]) == timetable_ID){
				
					timetable.setTIMETABLE_ID(Integer.parseInt(timetableRow[0]));
					timetable.setTEACHERCOURSE_ID(teacherCourseData.findOne(Integer.parseInt(timetableRow[1])));
					timetable.setTIMESLOT_ID(timeSlotData.findOne(Integer.parseInt(timetableRow[2])));
					timetable.setROOM_ID(roomData.findOne(Integer.parseInt(timetableRow[3])));
					 
				 return timetable;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

@SuppressWarnings("resource")
public static TimeTable deleteOne(int timetable_ID)  {
	FileWriter filewriter;

	List<TimeTable> timetables = findAll();
	
	TimeTable timetable = findOne(timetable_ID);

	try {
		filewriter = new FileWriter(TimeTable.csvFile);

		for (int i=0; i<timetables.size(); i++) {
			if (timetables.get(i).getTIMETABLE_ID() != timetable_ID) {
				filewriter.append(timetables.get(i).toString());
				filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return timetable;
}
@SuppressWarnings("resource")
public static List<TimeTable> search(String search) {
		
	    List<TimeTable> timetables = new ArrayList<TimeTable>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeTable.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TimeTable timetable = new TimeTable();
				
				String[] timetableRow = line.split(",");
				
				if(timetableRow[1].contains(search) == true){
					
					
					timetable.setTIMETABLE_ID(Integer.parseInt(timetableRow[0]));
					timetable.setTEACHERCOURSE_ID(teacherCourseData.findOne(Integer.parseInt(timetableRow[1])));
					timetable.setTIMESLOT_ID(timeSlotData.findOne(Integer.parseInt(timetableRow[2])));
					timetable.setROOM_ID(roomData.findOne(Integer.parseInt(timetableRow[3])));
					 
					 
				 
					 timetables.add(timetable);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return timetables;
		
	}
     

public static TimeTable Save(TimeTable timetable) {
	FileWriter filewriter;

	List<TimeTable> timetables = findAll();

	try {
		filewriter = new FileWriter(TimeTable.csvFile);

		for (int i=0; i<timetables.size(); i++) {
			filewriter.append(timetables.get(i).toString());
			filewriter.append("\n");
		}
		if (timetables.size()>0)
			timetable.setTIMETABLE_ID(timetables.get(timetables.size()-1).getTIMETABLE_ID()+1);
		else
			timetable.setTIMETABLE_ID(1);
		filewriter.append(timetable.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return timetable;
}
public static String deleteAll() 
{
	FileWriter filewriter;
	List<TimeTable> timetables = findAll();
	try 
	{
		filewriter = new FileWriter(TimeTable.csvFile);
		
		for(int i=0;i<timetables.size();i++) 
		{
			timetables.remove(i);
		}
			filewriter.flush();
			filewriter.close();
    } 
	catch (IOException e) 
	{   
		System.out.println("CSV File cannot be Read!" +e);  
		e.printStackTrace();    
	}
	return "Removed Successfully";
}}