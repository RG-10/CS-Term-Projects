package edu.uog.student;

import java.io.BufferedReader; 

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.student.studentData;
import edu.uog.course.courseData;

public class studentCourseData {

	@SuppressWarnings("resource")
	public static List<StudentCourse> findAll() {
		
		List<StudentCourse> studentcourses = new ArrayList<StudentCourse>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				StudentCourse studentcourse = new StudentCourse();
				
				String[] studentcourseRow = line.split(",");
				
				studentcourse.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
				studentcourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(studentcourseRow[1])));
				studentcourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(studentcourseRow[2])));
				studentcourse.setSECTION(studentcourseRow[3]);
				
				
				 studentcourses.add(studentcourse);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return studentcourses;
		
	}
@SuppressWarnings("resource")
public static StudentCourse findOne(int studentcourse_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				StudentCourse studentcourse = new StudentCourse();
				
				String[] studentcourseRow = line.split(",");
				
				if(Integer.parseInt(studentcourseRow[0]) == studentcourse_ID){
					

					studentcourse.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
					studentcourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(studentcourseRow[1])));
					studentcourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(studentcourseRow[2])));
					studentcourse.setSECTION(studentcourseRow[3]);
					 
				 return studentcourse;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
@SuppressWarnings("resource")
public static StudentCourse deleteOne(int studentCourse_ID)  {
	FileWriter filewriter;

	List<StudentCourse> studentcourses = findAll();
	StudentCourse studentCourse = findOne(studentCourse_ID);

	try {
		filewriter = new FileWriter(StudentCourse.csvFile);

		for (int i=0; i<studentcourses.size(); i++) {
			if (studentcourses.get(i).getSTUDENTCOURSE_ID() != studentCourse_ID) {
				filewriter.append(studentcourses.get(i).toString());
				filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return studentCourse;
}

@SuppressWarnings("resource")
public static List<StudentCourse> search(String search) {
		
	    List<StudentCourse> studentcourses = new ArrayList<StudentCourse>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(StudentCourse.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				StudentCourse studentcourse = new StudentCourse();
				
				String[]studentcourseRow = line.split(",");
				
				if(studentcourseRow[1].contains(search) == true){
				

					studentcourse.setSTUDENTCOURSE_ID(Integer.parseInt(studentcourseRow[0]));
					studentcourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(studentcourseRow[1])));
					studentcourse.setSTUDENT_ID(studentData.findOne(Integer.parseInt(studentcourseRow[2])));
					studentcourse.setSECTION(studentcourseRow[3]);
					 
				 
					 studentcourses.add(studentcourse);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return studentcourses;
		
	}
     

public static StudentCourse Save(StudentCourse studentcourse) {
	FileWriter filewriter;

	List<StudentCourse> studentcourses = findAll();

	try {
		filewriter = new FileWriter(StudentCourse.csvFile);

		for (int i=0; i<studentcourses.size(); i++) {
			filewriter.append(studentcourses.get(i).toString());
			filewriter.append("\n");
		}
		if (studentcourses.size()>0)
			studentcourse.setSTUDENTCOURSE_ID(studentcourses.get(studentcourses.size()-1).getSTUDENTCOURSE_ID()+1);
		else
			studentcourse.setSTUDENTCOURSE_ID(1);
		filewriter.append(studentcourse.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return studentcourse;
}
public static String deleteAll() 
{
	FileWriter filewriter;
	List<StudentCourse> studentcourses = findAll();
	try 
	{
		filewriter = new FileWriter(StudentCourse.csvFile);
		
		for(int i=0;i<studentcourses.size();i++) 
		{
			studentcourses.remove(i);
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
}
}
