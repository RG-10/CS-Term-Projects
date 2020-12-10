
package edu.uog;
import java.util.Scanner;
import edu.uog.course.courseInterface;
import edu.uog.person.personInterface;

import edu.uog.timetable.timeSlotInterface;
import edu.uog.timetable.timeTableInterface;
import edu.uog.timetable.weekDayInterface;
import edu.uog.campus.roomInterface;
import edu.uog.student.*;
import edu.uog.teacher.teacherCourseInterface;
import edu.uog.teacher.teacherInterface;

public class TimeTableManagement {

	
	public static void main(String[] args) {
		

	
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			int choice=-1;
			choice=-1;
			while (choice!=10) 
			{
				MainMenu();
				choice = scan.nextInt();
				switch (choice) 
				{
				case 1:
					roomInterface.RoomMenu();
					choice=-1;
					break;
				case 2:
					courseInterface.CourseMenu();
					choice=-1;
					break;
				case 3:
					personInterface.PersonMenu();
					choice=-1;
					break;
				case 4:
					studentinterface.StudentManu();
					choice=-1;
					break;
				case 5:
					studentCourseInterface.StudentCourseMenu();
					choice=-1;
					break;
			    case 6:
					teacherInterface.TeacherInterface();
					choice=-1;
					break;
				case 7:
					teacherCourseInterface.TeacherCourseManu();
					choice=-1;
					break;
				
				case 8:
					timeSlotInterface.TimeSlotManu();
					choice=-1;
					break;
				case 9:
					timeTableInterface.TimeTableMenu();
					choice=-1;
					break;
				case 10:
					weekDayInterface.WeekDayManu();
					choice=-1;
					break;
			       }
				}
		}

		  static void MainMenu() {
		
			System.out.println("=====================================================");
			System.out.println("                   Main Menu                         ");
			System.out.println("=====================================================");
			System.out.println("1.   Rooms Data");
			System.out.println("2.   Courses Data");
			System.out.println("3.   Persons Data");
			System.out.println("4.   Students Data");
			System.out.println("5.   StudentCourse Data");
			System.out.println("6.   Teachers Data");
			System.out.println("7.   TeacherCourse Data");
			System.out.println("8.   TimeSlots Data");
			System.out.println("9.   TimeTables Data");
			System.out.println("10.  WeekDays Data");
			System.out.print("Enter Your Choice[1-10]: ");
		}
}

		
		

	
	
	

		 
		
	
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	




	       // roomData roomdata = new roomData();
          
//		
//	        personData persondata = new personData();
//   	    studentData studentdata = new studentData();
//		
//	
//		
//	            	//These are Room class Calling Objects//
		
	//	System.out.println("FindOne");
	 //   Room room = roomdata.findOne(4);
	//    System.out.println(room.toString());
	//	System.out.println("-----------------------------------\n-----------------------------------\n");
		

	//	System.out.println("FindAll");
	//	List<Room> rooms = roomdata.findAll();
	//	for(int i=0; i<rooms.size(); i++) {
    //	System.out.println(rooms.get(i).toString());
    //	}
	//	System.out.println("-----------------------------------\n-----------------------------------\n");
	//	
	//	System.out.println("Search");
	//	rooms =roomdata.search("CR-01");
	//	for(int i=0; i<rooms.size(); i++) {
	//	System.out.println(rooms.get(i).toString());
	//	}
	//	System.out.println("-----------------------------------\n-----------------------------------\n");
	//	
	//
				
	//	System.out.println("Save");
	 //   room.setROOM_ID(1);
	//	room.setROOM_NAME("CR-01");
	//	room.setROOM_FLOUR(1);
	//	room.setROOM_CAPASITY(60);
	//	room.setROOM_TYPE("Lab Room");
	//	
	//	room = roomdata.Save(room);
	//	System.out.println(rooms.toString());
	//	System.out.println("-----------------------------------\n-----------------------------------\n");
//		
	
//		System.out.println("FindAll");
//		rooms = roomdata.findAll();
//		for (int i=0; i<rooms.size(); i++) {
//			System.out.println(rooms.get(i).toString());
//	}
	//}
//}
	
//	
//
//
//
//		System.out.println("-----------------------------------\n-----------------------------------\n"); 
//}
//}
	
//                           // THESE ARE COURSE CLASS OBJECTS//
//	{   
//		
//	courseData coursedata = new courseData();
//	
//		
//		System.out.println("FindOne");
//	
//		Course course = coursedata.findOne(1);
//		
//		System.out.println(course.toString());
//		System.out.println("-----------------------------------\n-----------------------------------\n");
//		
//		
//		
//		System.out.println("Find All");
//		
//		List<Course> courses = coursedata.findAll();
//		for(int j=0; j<courses.size(); j++) {
//			System.out.println(courses.get(j).toString());
//		}
//		System.out.println("-----------------------------------\n-----------------------------------\n");
//		
//		
//		
//      
//        System.out.println("Search");
//        courses = coursedata.search("CS-");
//        for(int k=0; k<courses.size(); k++) {
//        	
//        	System.out.println(courses.get(k).toString());
//        }
//        System.out.println("-----------------------------------\n-----------------------------------\n");
//        
//       
//        
//        System.out.println("Save");
//       course.setCOURSE_CODE("CS-104");
//        course.setCOURSE_TITLE("Object Oriented Programming");
//        course.setCOURSE_DESC("This is a Programming Course");
//        course.setCOURSE_CREDITHOUR(4);
//       
//        
//        course = coursedata.Save(course);
//        System.out.println(course.toString());
//        System.out.println("-----------------------------------\n-----------------------------------\n");
//        
//        
//        System.out.println("Find All After Save");
//        
//        courses = coursedata.findAll();
//        for(int i=0; i<courses.size(); i++) {
//        	
//        	System.out.println(courses.get(i).toString());
//        }
//        System.out.println("-----------------------------------\n-----------------------------------\n");
//      
//	}
//
//
//
//
//}
//
//
//
//                              // THESE ARE PERSON CLASS OBJECTS //
//
////
////		personData persondata = new personData();
////		
////		
////		System.out.println("FindOne");
////		
////		Person person = personData.findOne();
////		
////		System.out.println(person.toString());
////		System.out.println("-----------------------------------\n-----------------------------------\n");
////		
////		
////		
////		System.out.println("Find All");
////		
////		List<Person> persons = personData.findAll(2);
////		for(int i=0; i<persons.size(); i++) {
////			System.out.println(persons.get(i).toString());
////		}
////		System.out.println("-----------------------------------\n-----------------------------------\n");
////		
////		
////		
////      
////        System.out.println("Search");
////        persons = persondata.search("CS-");
////        for(int i=0; i<persons.size(); i++) {
////        	
////        	System.out.println(persons.get(i).toString());
////        }
////        System.out.println("-----------------------------------\n-----------------------------------\n");
////        
////       
////        
////        System.out.println("Save");
////         person.setPERSON_ID(Integer.parseInt(personRow[0]));
////		 person.setTITLE(personRow[1]);
////		 person.setFORE_NAME(personRow[2]);
////		 person.setSUR_NAME(personRow[3]);
////		 person.setAGE(Integer.parseInt(personRow[4]));
////		 person.setGENDER(personRow[5]);
////		 person.setADDRESS(personRow[6]);
////       
////        
////		 
////        person = persondata.Save(person);
////        System.out.println(person.toString());
////        System.out.println("-----------------------------------\n-----------------------------------\n");
////        
////        
////        System.out.println("Find All After Save");
////        
////        persons = persondata.findAll();
////        for(int i=0; i<persons.size(); i++) {
////        	
////        	System.out.println(persons.get(i).toString());
////        }
////        System.out.println("-----------------------------------\n-----------------------------------\n");
////      
////	}
////}
////
//
//
//
//
//
//
//
//
//
//
//
//
//
//		
				 