package com.uog.facility;

import java.util.List;
import java.util.Scanner;


import com.uog.patient.Patient_Data;

public class Facility_Menu {

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
				List<Facility> facilities = Facility_Data.FindAll();
				
				if(facilities.size() != 0) {
					for(int j=0;j<facilities.size();j++) {
						System.out.println(facilities.get(j).Display());
					}
					
			}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter Facility ID(Integer)");
				int showone=scanner.nextInt();
				if(Facility_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
				}
				else {
					System.out.println(Facility_Data.FindOne(showone).Display());
				}
				break;
			case "3":
				System.out.println("Please Enter Facility Name");
				String searchone = scanner.next();
				List<Facility> facilities2 = Facility_Data.Search(searchone);
				if(facilities2.isEmpty() == true) {
					System.out.println("Match did'nt found");
				
				}
				else {
						for(int j=0;j<facilities2.size();j++) {
							System.out.println(facilities2.get(j).Display());
						}
						
				}
				
				break;
			case "4":
				Facility facility = new Facility();
				
				System.out.println("Please Enter Facility name");
				String Username  = scanner.next();
				if(Patient_Data.validateStringforAlpha(Username) == true) {
					facility.setFacility_Name(Username);
					
					System.out.println("Please Enter Facility cost");
					int cost = scanner.nextInt();
					facility.setFacility_Cost(cost);
					Facility_Data.Save(facility);
					System.out.println("New Record Saved");
						
					}else {System.out.println("Facility name must be alphabatic");
					};
				
						
				
				
				
				
				
				
				
				break;
			case "5":
				
				
				Facility facility1 = new Facility();
				
				System.out.println("Please Enter New Facility name");
				String Username1  = scanner.next();
				if(Patient_Data.validateStringforAlpha(Username1) == true) {
					facility1.setFacility_Name(Username1);
					
					System.out.println("Please Enter New Facility cost");
					int cost1 = scanner.nextInt();
					facility1.setFacility_Cost(cost1);
					System.out.println("Enter Id to Update");
					int updateid = scanner.nextInt();
					Facility_Data.Update(updateid, facility1);
					System.out.println("New Record Saved");
						
					}else {System.out.println("Facility name must be alphabatic");
					};
				
				break;
				
			case "6":
				System.out.println("Please Enter Facility ID to Delete");
				int del = scanner.nextInt();
				
				if(Facility_Data.DelOne(del) == null) {
					System.out.println("ID not Found");
				}else {
					Facility_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Staff");
				if(Facility_Data.DelAll() == null) {
					System.out.println("ID not Found");
				}else {
					Facility_Data.DelAll();
					
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
