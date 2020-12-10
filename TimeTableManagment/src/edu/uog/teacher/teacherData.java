package edu.uog.teacher;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class teacherData {

	@SuppressWarnings("resource")
	public static List<Teacher> findAll() {
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				Teacher teacher = new Teacher();
				
				String[] teacherRow = line.split(",");
				
				teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
				
				 teachers.add(teacher);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachers;
		
	}
@SuppressWarnings("resource")
public static Teacher findOne(int teacher_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				Teacher teacher = new Teacher();
				
				String[] teacherRow = line.split(",");
				
				if(Integer.parseInt(teacherRow[0]) == teacher_ID){
				
					teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
					
				 return teacher;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
@SuppressWarnings("resource")
public static Teacher deleteOne(int teacher_ID)  {
	FileWriter filewriter;

	List<Teacher> teachers = findAll();
	Teacher teacher = findOne(teacher_ID);

	try {
		filewriter = new FileWriter(Teacher.csvFile);

		for (int i=0; i<teachers.size(); i++) {
			if (teachers.get(i).getTEACHER_ID() != teacher_ID) {
				filewriter.append(teachers.get(i).toString());
				filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return teacher;
}

@SuppressWarnings("resource")
public static List<Teacher> search(String search) {
		
	    List<Teacher> teachers = new ArrayList<Teacher>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Teacher.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				Teacher teacher = new Teacher();
				
				String[] teacherRow = line.split(",");
				
				if(teacherRow[1].contains(search) == true){
					
					teacher.setTEACHER_ID(Integer.parseInt(teacherRow[0]));
					
					teachers.add(teacher);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachers;
		
	}
     

public static Teacher Save(Teacher teacher) {
	FileWriter filewriter;

	List<Teacher> teachers = findAll();

	try {
		filewriter = new FileWriter(Teacher.csvFile);

		for (int i=0; i<teachers.size(); i++) {
			filewriter.append(teachers.get(i).toString());
			filewriter.append("\n");
		}
		if (teachers.size()>0)
			teacher.setTEACHER_ID(teachers.get(teachers.size()-1).getTEACHER_ID()+1);
		else
			teacher.setTEACHER_ID(1);
		filewriter.append(teacher.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return teacher;
}public static String deleteAll() 
{
	FileWriter filewriter;
	List<Teacher> teachers = findAll();
	try 
	{
		filewriter = new FileWriter(Teacher.csvFile);
		
		for(int i=0;i<teachers.size();i++) 
		{
			teachers.remove(i);
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
