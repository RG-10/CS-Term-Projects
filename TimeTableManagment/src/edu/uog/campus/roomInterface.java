package edu.uog.campus;

import java.util.List;
import java.util.Scanner;

public class roomInterface {
		
	@SuppressWarnings({ "resource", "static-access", "unused" })
	public static void RoomMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                 WELCOME To Rooms Menu               ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All Rooms DATA");
			System.out.println("2.  INSERT Room ROW");
			System.out.println("3.  SEARCH Rooms By Room-ID");
			System.out.println("4.  SEARCH Rooms By Room Name");
			System.out.println("5.  DELETE Room By Room-ID");
			System.out.println("6.  DELETE All Rooms DATA");
			System.out.println("7.  QUIT Room");;
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("        All Rooms Data       ");
				System.out.println("=================================");
				
				List<Room> room1 = roomData.findAll();
				
				for (int i=0; i<room1.size(); i++) {
					
				       System.out.println(room1.get(i).toString()); 
				    
				}
			    System.out.println("=================================");
				break;
				
			 case 2:
				 
				System.out.println("=================================");
				System.out.println("        Insert Room Row          ");
				System.out.println("=================================");
				
				Room room2 = new Room();
				System.out.print("Enter Room Type: ");
				String type = scan.nextLine();
				type += scan.nextLine();
				room2.setROOM_TYPE(type);
				System.out.print("Enter Room Name: ");
				String roomname = scan.nextLine();
				room2.setROOM_NAME(roomname);
				System.out.print("Enter Room Floor: ");
				int flour = scan.nextInt();
				room2.setROOM_FLOUR(flour);
				System.out.print("Enter Room Capacity: ");
				int capacity = scan.nextInt();
				room2.setROOM_CAPACITY(capacity);
				
				room2 = roomData.Save(room2);
				System.out.println(room2.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 3:
				
				System.out.println("=================================");
				System.out.println("       Search By Room ID         ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				
				roomData roomdata3 = new roomData();
				Scanner search1=new Scanner(System.in);
				
				int U1 = search1.nextInt();
				
				 Room room3 = roomData.findOne(U1);
				 System.out.println(room3.toString());
				 
				 System.out.println("================================");
				 
				break;
				
			case 4:
				
				System.out.println("=================================");
				System.out.println("    Search Room By Room Name    ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				
				Scanner search2 = new Scanner(System.in);
				String U2 =  search2.nextLine();
				
				roomData roomdata4 = new roomData();
				List<Room> room4 = roomData.findAll();
				room4 = roomdata4.search(U2);
				
				for (int i=0; i<room4.size(); i++) {	
				       System.out.println(room4.get(i).toString());    }
				
				System.out.println("==================================");
				
				break;
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("      Delete Room By ID          ");
				System.out.println("=================================");
				System.out.print("Enter Room ID: ");
				
				int delete = scan.nextInt();
				
				Room room5 = roomData.deleteOne(delete);
				System.out.println(room5.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 6:
				
				System.out.println("=================================");
				System.out.println("      Delete All Rooms           ");
				System.out.println("=================================");
				String room6 = roomData.deleteAll(); 
			      System.out.println(room6); 
			      
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
