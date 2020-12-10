package edu.uog.teacher;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import edu.uog.course.courseData;

public class teacherCourseData {

	@SuppressWarnings("resource")
	public static List<TeacherCourse> findAll() {
		
		List<TeacherCourse> teachercourses = new ArrayList<TeacherCourse>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TeacherCourse teachercourse = new TeacherCourse();
			
				
				String[] teachercourseRow = line.split(",");
				
				teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
				teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(teachercourseRow[1])));
				teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(teachercourseRow[2])));
				teachercourse.setSECTION(teachercourseRow[3]);
				 
				
				 teachercourses.add(teachercourse);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachercourses;
		
	}
@SuppressWarnings("resource")
public static TeacherCourse findOne(int teachercourse_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TeacherCourse teachercourse = new TeacherCourse();
				
				String[] teachercourseRow = line.split(",");
				
				if(Integer.parseInt(teachercourseRow[0]) == teachercourse_ID){
				

					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
					teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(teachercourseRow[1])));
					teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(teachercourseRow[2])));
					teachercourse.setSECTION(teachercourseRow[3]);
					 
					 
					 
				 return teachercourse;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
@SuppressWarnings("resource")
public static TeacherCourse deleteOne(int teacherCourse_ID)  {
	FileWriter filewriter;

	List<TeacherCourse> teachertcourses = findAll();
	TeacherCourse teacherCourse = findOne(teacherCourse_ID);

	try {
		filewriter = new FileWriter(TeacherCourse.csvFile);

		for (int i=0; i<teachertcourses.size(); i++) {
			if (teachertcourses.get(i).getTEACHERCOURSE_ID() != teacherCourse_ID) {
				filewriter.append(teachertcourses.get(i).toString());
				filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return teacherCourse;
}
@SuppressWarnings("resource")
public static List<TeacherCourse> search(String search) {
		
	    List<TeacherCourse> teachercourses = new ArrayList<TeacherCourse>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(TeacherCourse.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				TeacherCourse teachercourse = new TeacherCourse();
				
				String[] teachercourseRow = line.split(",");
				
				if(teachercourseRow[1].contains(search) == true){
					

					teachercourse.setTEACHERCOURSE_ID(Integer.parseInt(teachercourseRow[0]));
					teachercourse.setCOURSE_ID(courseData.findOne(Integer.parseInt(teachercourseRow[1])));
					teachercourse.setTEACHER_ID(teacherData.findOne(Integer.parseInt(teachercourseRow[2])));
					teachercourse.setSECTION(teachercourseRow[3]);
					 
				 
					 teachercourses.add(teachercourse);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return teachercourses;
		
	}
     

public static TeacherCourse Save(TeacherCourse teachercourse) {
	FileWriter filewriter;

	List<TeacherCourse> teachercourses = findAll();

	try {
		filewriter = new FileWriter(TeacherCourse.csvFile);

		for (int i=0; i<teachercourses.size(); i++) {
			filewriter.append(teachercourses.get(i).toString());
			filewriter.append("\n");
		}
		if (teachercourses.size()>0)
			teachercourse.setTEACHERCOURSE_ID(teachercourses.get(teachercourses.size()-1).getTEACHERCOURSE_ID()+1);
		else
			teachercourse.setTEACHERCOURSE_ID(1);
		filewriter.append(teachercourse.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return teachercourse;
}
public static String deleteAll() 
{
	FileWriter filewriter;
	List<TeacherCourse> teachercourses = findAll();
	try 
	{
		filewriter = new FileWriter(TeacherCourse.csvFile);
		
		for(int i=0;i<teachercourses.size();i++) 
		{
			teachercourses.remove(i);
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
