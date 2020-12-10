package edu.uog.timetable;

import java.io.BufferedReader;


import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class timeSlotData {

	@SuppressWarnings("resource")
	public static List<TimeSlot> findAll() {
		
		List<TimeSlot> timeslots = new ArrayList<TimeSlot>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeSlot.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TimeSlot timeslot = new TimeSlot();
				
								
				String[] timeslotRow = line.split(",");
				
				timeslot.setTIMESLOT_ID(Integer.parseInt(timeslotRow[0]));
				timeslot.setWEEKDAY_ID(weekDayData.findOne(Integer.parseInt(timeslotRow[1])));
				timeslot.setTIMESLOT_START(timeslotRow[2]);
			    timeslot.setTIMESLOT_END(timeslotRow[3]);
				 
				
				 timeslots.add(timeslot);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return timeslots;
		
	}
@SuppressWarnings("resource")
public static TimeSlot findOne(int timeslot_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeSlot.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TimeSlot timeslot = new TimeSlot();
				
				String[] timeslotRow = line.split(",");
				
				if(Integer.parseInt(timeslotRow[0]) == timeslot_ID){
				
					timeslot.setTIMESLOT_ID(Integer.parseInt(timeslotRow[0]));
					timeslot.setWEEKDAY_ID(weekDayData.findOne(Integer.parseInt(timeslotRow[1])));
					timeslot.setTIMESLOT_START(timeslotRow[2]);
				    timeslot.setTIMESLOT_END(timeslotRow[3]);
					 
					 
				 return timeslot;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

@SuppressWarnings("resource")
public static TimeSlot deleteOne(int timeslot_ID)  {
	FileWriter filewriter;

	List<TimeSlot> timeslots = findAll();
	TimeSlot timeslot = findOne(timeslot_ID);

	try {
		filewriter = new FileWriter(TimeSlot.csvFile);

		for (int i=0; i<timeslots.size(); i++) {
			if (timeslots.get(i).getTIMESLOT_ID() != timeslot_ID) {
				filewriter.append(timeslots.get(i).toString());
				filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return timeslot;
}
@SuppressWarnings("resource")
public static List<TimeSlot> search(String search) {
		
	    List<TimeSlot> timeslots = new ArrayList<TimeSlot>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TimeSlot.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TimeSlot timeslot = new TimeSlot();
				
				String[] timeslotRow = line.split(",");
				
				if(timeslotRow[1].contains(search) == true){
					
					timeslot.setTIMESLOT_ID(Integer.parseInt(timeslotRow[0]));
					timeslot.setWEEKDAY_ID(weekDayData.findOne(Integer.parseInt(timeslotRow[1])));
					timeslot.setTIMESLOT_START(timeslotRow[2]);
				    timeslot.setTIMESLOT_END(timeslotRow[3]);
					 
					 
				 
					 timeslots.add(timeslot);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return timeslots;
		
	}
     

public static TimeSlot Save(TimeSlot timeslot) {
	FileWriter filewriter;

	List<TimeSlot> timeslots = findAll();

	try {
		filewriter = new FileWriter(TimeSlot.csvFile);

		for (int i=0; i<timeslots.size(); i++) {
			filewriter.append(timeslots.get(i).toString());
			filewriter.append("\n");
		}
		if (timeslots.size()>0)
			timeslot.setTIMESLOT_ID(timeslots.get(timeslots.size()-1).getTIMESLOT_ID()+1);
		else
			timeslot.setTIMESLOT_ID(1);
		
		filewriter.append(timeslot.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return timeslot;
}
public static String deleteAll() 
{
	FileWriter filewriter;
	List<TimeSlot> timeslots = findAll();
	try 
	{
		filewriter = new FileWriter(TimeSlot.csvFile);
		
		for(int i=0;i<timeslots.size();i++) 
		{
			timeslots.remove(i);
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
