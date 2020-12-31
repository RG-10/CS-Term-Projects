package com.uog.room;


import java.util.List;
import java.util.Scanner;



public class Room_Menu {
	@SuppressWarnings("resource")
	public static void Menu() {
			
			String choice;
			boolean  i = true;
			Scanner scanner = new Scanner(System.in);
			while(i) {
				System.out.println("Please Select Choice\n"
						+ "-----------------------------"
								 + "\n1 - Print List of All Records"
								 + "\n2 - Print one Record with ID"
								 + "\n3 - Print Record/s with name/Equivalent"
								 + "\n4 - Save Record"
								 + "\n5 - Update Record"
								 + "\n6 - Delete One Record"
								 + "\n7 - Delete All Records"
								 + "\n8 - Exit"
						+ "\n-----------------------------");
				choice = scanner.next();
		
			switch(choice) {
			case "1":
				List<Room> rooms = Room_Data.FindAll();
				
				if(rooms.size()!=0) {
					for(int j=0;j<rooms.size();j++) {
						System.out.println(rooms.get(j).Display());
					}
					
			}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter Room ID(Integer)");
				int showone=scanner.nextInt();
				if(Room_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
					
				}
				else {
					System.out.println(Room_Data.FindOne(showone).Display());
				}
				break;
			case "3":
				System.out.println("Please Enter Room Name(String)");
				String searchone = scanner.next();
				if(Room_Data.Search(searchone).isEmpty() == true) {
					System.out.println("Match did'nt found");
				
				}
				else {
					List<Room> rooms1 = Room_Data.Search(searchone);
					
					if(rooms1.size()!=0) {
						for(int j=0;j<rooms1.size();j++) {
							System.out.println(rooms1.get(j).Display());
						}
						
				}
				}
				break;
			case "4":
				Room room = new Room();
				
				System.out.println("Please Enter Room name");
				String Username  = scanner.next();
				
					
				room.setROOM_NAME(Username);
				System.out.println("Please Enter Room Floor");
				int floor = scanner.nextInt();
						
				room.setROOM_FLOOR(floor);
				System.out.println("Please Enter Room Capacity");
				int capacity= scanner.nextInt();
				room.setROOM_CAPACITY(capacity);
									
				System.out.println("Enter Room Type");
				String type  = scanner.next();
				room.setROOM_TYPE(type);
									
				Room_Data.Save(room);
				System.out.println("New Record Saved");
						
					
				
						
				
				
				
				break;
			case "5":
				
				
				
				Room room1 = new Room();
				
				System.out.println("Please Enter New Room name");
				String Username1  = scanner.next();
				
					
				room1.setROOM_NAME(Username1);
				System.out.println("Please Enter New Room Floor");
				int floor1 = scanner.nextInt();
						
				room1.setROOM_FLOOR(floor1);
				System.out.println("Please Enter New Room Capacity");
				int capacity1= scanner.nextInt();
				room1.setROOM_CAPACITY(capacity1);
									
				System.out.println("Enter New Room Type");
				String type1  = scanner.next();
				room1.setROOM_TYPE(type1);
				System.out.println("Please Enter Room id to update");
				int updateid1 = scanner.nextInt();
				Room_Data.Update(updateid1, room1);
				System.out.println("Record Updated Successfully");
							
				
				break;
				
			case "6":
				System.out.println("Please Enter Room ID to Delete");
				int del = scanner.nextInt();
				
				if(Room_Data.DelOne(del) == null) {
					System.out.println("ID not Found");
				}else {
					Room_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Room");

				if(Room_Data.DelAll() == null) {
					System.out.println("ID not Found");
				}else {
					Room_Data.DelAll();
					
				}
				
				break;
			case "8":
				i=false;
				break;
			default:System.out.println("Please Enter correct Input");
			}
			
		}
	}	
}
