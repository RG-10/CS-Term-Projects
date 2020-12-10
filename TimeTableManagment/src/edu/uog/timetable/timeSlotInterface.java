package edu.uog.timetable;

import java.util.List;

import java.util.Scanner;

public class timeSlotInterface {

	@SuppressWarnings({ "resource", "static-access" })
	public static void TimeSlotManu() {
		
		{
			Scanner scan = new Scanner(System.in);
			int choice=-1;
			choice = -1;
			while (choice!=10) 
			{
				System.out.println("*****************************************************");
				System.out.println("                  TimeSlots Menu                     ");
				System.out.println("*****************************************************");
				System.out.println("1.  Show All TimeSlots Data");
				System.out.println("2.  Insert TimeSlot Row");
				System.out.println("3.  Search TimeSlots By TimeSlot-ID");
				System.out.println("4.  Delete TimeSlot By TimeSlot-ID");
				System.out.println("5.  Delete All TimeSlots Data");
				System.out.println("6.  Quit TimeSlot");;
				System.out.print("Enter Your Choice [1-7]: ");
				choice = scan.nextInt();
				switch (choice) 
				{
				  case 1:
					System.out.println("=================================");
					System.out.println("     Show All TimeSlots Data     ");
					System.out.println("=================================");
					List<TimeSlot> timeslot1 = timeSlotData.findAll();
					for (int i=0; i<timeslot1.size(); i++) 
					    {    System.out.println(timeslot1.get(i).toString());    }
				    System.out.println("=================================");
					break;
				 case 2:
					System.out.println("=================================");
					System.out.println("        Insert TimeSlot Row          ");
					System.out.println("=================================");
					TimeSlot timeslot2 = new TimeSlot();
					System.out.print("Enter WeekDay ID: ");
					int dayid = scan.nextInt();
					
					timeslot2.setWEEKDAY_ID(weekDayData.findOne(dayid));
					System.out.print("Enter TimeSlot Start: ");
					String startdate = scan.nextLine();
					timeslot2.setTIMESLOT_START(startdate);
					System.out.print("Enter TimeSlot End: ");
					String enddate = scan.nextLine();
					timeslot2.setTIMESLOT_END(enddate);
					timeslot2 = timeSlotData.Save(timeslot2);
					System.out.println(timeslot2.toString());
					System.out.println("=================================");
					break;
				case 3:
					System.out.println("=================================");
					System.out.println("       Search By TimeSlot ID         ");
					System.out.println("=================================");
					System.out.print("Enter search: ");
					timeSlotData timeslotdata3 = new timeSlotData();
					Scanner search1=new Scanner(System.in);
					int x1=search1.nextInt();
					 TimeSlot timeslot3 = timeslotdata3.findOne(x1);
					 System.out.println(timeslot3.toString());
					 System.out.println("=================================");
					break;
				case 4:
					System.out.println("=================================");
					System.out.println("      Delete TimeSlot By ID          ");
					System.out.println("=================================");
					System.out.print("Enter TimeSlot ID: ");
					int delete = scan.nextInt();
					TimeSlot timeslot5 = timeSlotData.deleteOne(delete);
					System.out.println(timeslot5.toString());
					System.out.println("=================================");
					break;
				case 5:
					System.out.println("=================================");
					System.out.println("      Delete All TimeSlots           ");
					System.out.println("=================================");
					String timeslot6 = timeSlotData.deleteAll(); 
				      System.out.println(timeslot6); 
					break;
				case 6:
					System.out.println("=================================");
					System.out.println("        Quit TimeSlot            ");
					System.out.println("=================================");
					
					break;
				}
			}
		}
	}
}
