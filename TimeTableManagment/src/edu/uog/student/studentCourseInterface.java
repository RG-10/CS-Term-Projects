package edu.uog.student;

import java.util.List;

import java.util.Scanner;

import edu.uog.course.courseData;

public class studentCourseInterface {

	@SuppressWarnings({ "resource", "static-access", "unused" })
	public static void StudentCourseMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                  StudentCourses Menu                         ");
			System.out.println("=====================================================");
			System.out.println("1.  Show All StudentCourses Data");
			System.out.println("2.  Insert StudentCourse Row");
			System.out.println("3.  Search StudentCourses By StudentCourse-ID");
			System.out.println("4.  Search StudentCourses By StudentCourse Name");
			System.out.println("5.  Delete StudentCourse By StudentCourse-ID");
			System.out.println("6.  Delete All StudentCourses Data");
			System.out.println("7.  Quit StudentCourse");;
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("        All StudentCourses Data       ");
				System.out.println("=================================");
				List<StudentCourse> studentcourse1 = studentCourseData.findAll();
				for (int i=0; i<studentcourse1.size(); i++) 
				    {    System.out.println(studentcourse1.get(i).toString()); 
				    
				    }
			    System.out.println("=================================");
				break;
			 case 2:
				System.out.println("=================================");
				System.out.println("        Insert StudentCourse Row          ");
				System.out.println("=================================");
				StudentCourse studentcourse2 = new StudentCourse();
				System.out.print("Enter Student ID: ");
				int studentid = scan.nextInt();
				studentcourse2.setSTUDENT_ID(studentData.findOne(studentid));
				
				System.out.print("Enter Course ID: ");
				int courseid = scan.nextInt();
				studentcourse2.setCOURSE_ID(courseData.findOne(courseid));
				System.out.print("Enter Section: ");
				String type = scan.nextLine();
				type+=scan.nextLine();
				studentcourse2.setSECTION(type);
				
				studentcourse2 = studentCourseData.Save(studentcourse2);
				System.out.println(studentcourse2.toString());
				System.out.println("=================================");
				break;
			case 3:
				System.out.println("=================================");
				System.out.println("       Search By StudentCourse ID         ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				studentCourseData studentcoursedata3 = new studentCourseData();
				Scanner search1=new Scanner(System.in);
				int x1=search1.nextInt();
				 StudentCourse studentcourse3 = studentCourseData.findOne(x1);
				 System.out.println(studentcourse3.toString());
				 System.out.println("================================");
				break;
			case 4:
				System.out.println("=================================");
				System.out.println("    Search StudentCourse By StudentCourse Name    ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				Scanner search2=new Scanner(System.in);
				String x2=search2.nextLine();
				studentCourseData studentcoursedata4 = new studentCourseData();
				List<StudentCourse> studentcourse4 = studentCourseData.findAll();
				studentcourse4= studentcoursedata4.search(x2);
				for (int i=0; i<studentcourse4.size(); i++)	
				    {    System.out.println(studentcourse4.get(i).toString());    }
				System.out.println("==================================");
				break;
			case 5:
				System.out.println("=================================");
				System.out.println("      Delete StudentCourse By ID          ");
				System.out.println("=================================");
				System.out.print("Enter StudentCourse ID: ");
				int delete = scan.nextInt();
				StudentCourse studentcourse5 = studentCourseData.deleteOne(delete);
				System.out.println(studentcourse5.toString());
				System.out.println("=================================");
				break;
			case 6:
				System.out.println("=================================");
				System.out.println("      Delete All StudentCourses           ");
				System.out.println("=================================");
				String studentcourse6 = studentCourseData.deleteAll(); 
			      System.out.println(studentcourse6); 
				break;
			case 7:
				System.out.println("=================================");
				System.out.println("             Quit                ");
				System.out.println("=================================");
				System.exit(0);
				break;
			}
		}
	}

}
