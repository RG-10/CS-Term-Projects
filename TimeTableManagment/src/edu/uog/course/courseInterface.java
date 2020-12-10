package edu.uog.course;

import java.util.List;

import java.util.Scanner;

public class courseInterface {

	@SuppressWarnings({ "static-access", "resource" })
	public static void CourseMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                   Welcome to COURSES MENU           ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All COURSES DATA");
			System.out.println("2.  INSERT Course ROW");
			System.out.println("3.  SEARCH Courses By COURSE-ID");
			System.out.println("4.  SEARCH Courses By COURSE-Code");
			System.out.println("5.  DELETE Course By COURSE-ID");
			System.out.println("6.  SELETE All COURSES DATA");
			System.out.println("7.  QUIT COURSES");;
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("     Show All Courses DATA       ");
				System.out.println("=================================");
				List<Course> course1 = courseData.findAll();
				for (int i=0; i<course1.size(); i++) 
					
				    {System.out.println(course1.get(i).toString());}
				
			    System.out.println("=================================");
			    
				break;
				
			 case 2:
				System.out.println("=================================");
				System.out.println("        Insert Course ROW         ");
				System.out.println("=================================");
				Course course2 = new Course();
				System.out.print("Enter Course Code: ");
				String code = scan.nextLine();
				code += scan.nextLine();
				course2.setCOURSE_CODE(code);
				System.out.print("Enter Course Title: ");
				String title = scan.nextLine();
				course2.setCOURSE_TITLE(title);
				System.out.print("Enter Course Description: ");
				String desc = scan.nextLine();
				course2.setCOURSE_DESC(desc);
				System.out.print("Enter Course CreditHours: ");
				int credithour = scan.nextInt();
				course2.setCOURSE_CREDITHOUR(credithour);
				System.out.print("Enter Course Prerequist-ID: ");
				int prerequist = scan.nextInt();
				course2.setPREREQUISITE_ID(courseData.findOne(prerequist));
				course2 = courseData.Save(course2);
				System.out.println(course2.toString());
				System.out.println("=================================");
				
				break;
				 
			case 3:
				
				System.out.println("=================================");
				System.out.println("   Search Course By Course-ID    ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				courseData coursedata3 = new courseData();
				Scanner search1 = new Scanner(System.in);
				int x1 = search1.nextInt();
				Course course3 = coursedata3.findOne(x1);
				System.out.println(course3.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 4:
				
				System.out.println("=================================");
				System.out.println("  Search Course By Course-Title   ");
				System.out.println("================================="); 
				System.out.print("Enter search: ");
				courseData coursedata4 = new courseData();
				Scanner search2=new Scanner(System.in);
				String x2 = search2.nextLine();
				
				coursedata4.search(x2);
				
				List<Course> course4 = coursedata4.findAll();
				
				for (int i=0; i<course4.size(); i++) {	
			        System.out.println(course4.get(i).toString());    }
				
			    System.out.println("=================================");
			    
				break;
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("   Delete Course By Course-ID    ");
				System.out.println("=================================");
				System.out.print("Enter Course ID: ");
				
				int delete = scan.nextInt();
				
				Course course5 = courseData.deleteOne(delete);
				System.out.println(course5.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 6:
				System.out.println("=================================");
				System.out.println("       Delete All Courses        ");
				System.out.println("=================================");
				String course6 = courseData.deleteAll(); 
			    System.out.println(course6); 
			    
				break;
				
			case 7:
				
				break;
			}
		}
	}
}



