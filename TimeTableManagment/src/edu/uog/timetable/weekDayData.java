package edu.uog.timetable;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class weekDayData {

	@SuppressWarnings("resource")
	public static List<WeekDay> findAll() {
		
		List<WeekDay> weekdays = new ArrayList<WeekDay>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				WeekDay weekday = new WeekDay();
				
				String[] studentRow = line.split(",");
				
				weekday.setWEEKDAY_ID(Integer.parseInt(studentRow[0]));
				weekday.setWEEKDAY_NAME(studentRow[1]);
				
				
				 weekdays.add(weekday);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return weekdays;
		
	}
@SuppressWarnings("resource")
public static WeekDay findOne(int student_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				WeekDay weekday = new WeekDay();
				
				String[] studentRow = line.split(",");
				
				if(Integer.parseInt(studentRow[0]) == student_ID){
				

					weekday.setWEEKDAY_ID(Integer.parseInt(studentRow[0]));
					weekday.setWEEKDAY_NAME(studentRow[1]);
					 
				 return weekday;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

@SuppressWarnings("resource")
     public static WeekDay deleteOne(int weekday_ID)  {
	                 FileWriter filewriter;

	                  List<WeekDay> weekdays = findAll();
	                  WeekDay weekday = findOne(weekday_ID);

	     try {
		           filewriter = new FileWriter(WeekDay.csvFile);

		           for (int i=0; i<weekdays.size(); i++) {
			   if (weekdays.get(i).getWEEKDAY_ID() != weekday_ID) {
				    filewriter.append(weekdays.get(i).toString());
				    filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		
		// TODO Auto-generated catch block
		
		e.printStackTrace();
	}
	
	return weekday;
}
@SuppressWarnings("resource")
public static List<WeekDay> search(String search) {
		
	    List<WeekDay> weekdays = new ArrayList<WeekDay>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(WeekDay.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				WeekDay weekday = new WeekDay();
				
				String[] studentRow = line.split(",");
				
				if(studentRow[1].contains(search) == true){
				

					weekday.setWEEKDAY_ID(Integer.parseInt(studentRow[0]));
					weekday.setWEEKDAY_NAME(studentRow[1]);
				 
					 weekdays.add(weekday);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return weekdays;
		
	}
     

public static WeekDay Save(WeekDay weekday) {
	FileWriter filewriter;

	List<WeekDay> weekdays = findAll();

	try {
		filewriter = new FileWriter(WeekDay.csvFile);

		for (int i=0; i<weekdays.size(); i++) {
			filewriter.append(weekdays.get(i).toString());
			filewriter.append("\n");
		}
		if (weekdays.size()>0)
			weekday.setWEEKDAY_ID(weekdays.get(weekdays.size()-1).getWEEKDAY_ID()+1);
		else
			weekday.setWEEKDAY_ID(1);
		filewriter.append(weekday.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return weekday;
}
public static String deleteAll() 
{
	FileWriter filewriter;
	List<WeekDay> weekdays = findAll();
	try 
	{
		filewriter = new FileWriter(WeekDay.csvFile);
		
		for(int i=0;i<weekdays.size();i++) 
		{
			weekdays.remove(i);
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
