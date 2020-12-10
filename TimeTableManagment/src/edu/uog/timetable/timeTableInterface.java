package edu.uog.timetable;

import java.util.List;

import java.util.Scanner;

import edu.uog.campus.roomData;
import edu.uog.teacher.teacherCourseData;

public class timeTableInterface {

	@SuppressWarnings({ "resource", "unused", "static-access" })
	public static void TimeTableMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("*****************************************************");
			System.out.println("                  TimeTables Menu                      ");
			System.out.println("*****************************************************");
			System.out.println("1.  Show All TimeTables Data");
			System.out.println("2.  Insert TimeTable Row");
			System.out.println("3.  Search TimeTables By TimeTable-ID");
			System.out.println("4.  Search TimeTables By TimeTable-Name");
			System.out.println("5.  Delete TimeTable By TimeTable-ID");
			System.out.println("6.  Delete All TimeTables Data");
			System.out.println("7.  Quit TimeTable");;
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("       Show All TimeTables Data       ");
				System.out.println("=================================");
				List<TimeTable> TimeTable1 = timeTableData.findAll();
				for (int i=0; i<TimeTable1.size(); i++) 
				    {    System.out.println(TimeTable1.get(i).toString());    }
			    System.out.println("=================================");
				break;
			 case 2:
				System.out.println("=================================");
				System.out.println("        Insert TimeTable Row          ");
				System.out.println("=================================");
				TimeTable TimeTable2 = new TimeTable();
				
				System.out.print("Enter Teacher Course ID: ");
				int id2 = scan.nextInt();
				TimeTable2.setTEACHERCOURSE_ID(teacherCourseData.findOne(id2));
				System.out.print("Enter TimeSlot ID: ");
				int id3 = scan.nextInt();
		//		TimeTable2.setTIMESLOT_ID(timeTableData.findOne(id3));
				System.out.print("Enter Room ID: ");
				int id4 = scan.nextInt();
				TimeTable2.setROOM_ID(roomData.findOne(id4));
				
				
				TimeTable2 = timeTableData.Save(TimeTable2);
				System.out.println(TimeTable2.toString());
				System.out.println("=================================");
				break;
			case 3:
				System.out.println("=================================");
				System.out.println("       Search By TimeTable ID         ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				timeTableData TimeTabledata3 = new timeTableData();
				Scanner search1=new Scanner(System.in);
				int x1=search1.nextInt();
				 TimeTable TimeTable3 = timeTableData.findOne(x1);
				 System.out.println(TimeTable3.toString());
				 System.out.println("=================================");
				break;
			case 4:
				System.out.println("=================================");
				System.out.println(" Search TimeTable By TimeTable Name ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				Scanner search2=new Scanner(System.in);
				String x2=search2.nextLine();
				timeTableData TimeTabledata4 = new timeTableData();
				List<TimeTable> TimeTable4 = TimeTabledata4.findAll();
				TimeTable4= TimeTabledata4.search(x2);
				for (int i=0; i<TimeTable4.size(); i++)	
				    {    System.out.println(TimeTable4.get(i).toString());    }
				System.out.println("=================================");
				break;
			case 5:
				System.out.println("=================================");
				System.out.println("      Delete TimeTable By ID          ");
				System.out.println("=================================");
				System.out.print("Enter TimeTable ID: ");
				int delete = scan.nextInt();
				TimeTable TimeTable5 = timeTableData.deleteOne(delete);
				System.out.println(TimeTable5.toString());
				System.out.println("=================================");
				break;
			case 6:
				System.out.println("=================================");
				System.out.println("      Delete All TimeTables           ");
				System.out.println("=================================");
				String TimeTable6 = timeTableData.deleteAll(); 
			      System.out.println(TimeTable6); 
				break;
			case 7:
				System.out.println("=================================");
				System.out.println("             Quit                ");
				System.out.println("=================================");
				
				break;
			}
		}
	}
}

