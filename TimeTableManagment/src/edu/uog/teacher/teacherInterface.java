package edu.uog.teacher;

import java.util.List;


import java.util.Scanner;

public class teacherInterface {

	@SuppressWarnings({ "resource", "static-access" })
	public static void TeacherInterface (){
		
		{
			Scanner scan = new Scanner(System.in);
			int choice=-1;
			choice = -1;
			while (choice!=10) 
			{
				System.out.println("*****************************************************");
				System.out.println("                  Teacher Menu                         ");
				System.out.println("*****************************************************");
				System.out.println("1.  Show All Teacher Data");
				System.out.println("2.  Insert Teacher Row");
				System.out.println("3.  Search Teacher By Teacher-ID");
				System.out.println("4.  Search Teacher By Teacher Name");
				System.out.println("5.  Delete Teacher By Teacher-ID");
				System.out.println("6.  Delete All TeacherCourses Data");
				System.out.println("7.  Quit Teacher");;
				System.out.print("Enter Your Choice [1-7]: ");
				choice = scan.nextInt();
				switch (choice) 
				{
				  case 1:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("      All Teachers Data          ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					List<Teacher> teacher1 = teacherData.findAll();
					for (int i=0; i<teacher1.size(); i++) 
					    {    System.out.println(teacher1.get(i).toString()); 
					    
					    }
				    System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					break;
				 case 2:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("     Insert Teacher Row          ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					Teacher teacher2 = new Teacher();
					System.out.print("Enter Teacher ID: ");
				//	int teacherid = scan.nextInt();
				//	teacher2.setTEACHER_ID(teacherData.findOne(teacherid));
					
					
					
					
					teacher2 = teacherData.Save(teacher2);
					System.out.println(teacher2.toString());
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					break;
				case 3:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("       Search By Teacher ID         ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.print("Enter search: ");
					@SuppressWarnings("unused")
					teacherData teacherdata3 = new teacherData();
					Scanner search1=new Scanner(System.in);
					int x1=search1.nextInt();
					 Teacher teacher3 = teacherData.findOne(x1);
					 System.out.println(teacher3.toString());
					 System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					break;
				case 4:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("    Search TeacherBy Teacher Name    ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.print("Enter search: ");
					Scanner search2=new Scanner(System.in);
					String x2=search2.nextLine();
					teacherData teacherdata4 = new teacherData();
					List<Teacher> teacher4 = teacherData.findAll();
					teacher4= teacherdata4.search(x2);
					for (int i=0; i<teacher4.size(); i++)	
					    {    System.out.println(teacher4.get(i).toString());    }
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					break;
				case 5:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("      Delete Teacher By ID          ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.print("Enter Teacher ID: ");
					int delete = scan.nextInt();
					Teacher teacher5 = teacherData.deleteOne(delete);
					System.out.println(teacher5.toString());
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					break;
				case 6:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("      Delete All Teacher           ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					String teacher6 = teacherData.deleteAll(); 
				      System.out.println(teacher6); 
					break;
				case 7:
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.out.println("             Quit                ");
					System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
					System.exit(0);
					break;
				}
			}
		}
	}


}
