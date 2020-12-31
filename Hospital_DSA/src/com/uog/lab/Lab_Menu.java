package com.uog.lab;

import java.util.List;
import java.util.Scanner;


import com.uog.staff.Staff_Data;

public class Lab_Menu {
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
				List<Lab> labs = Lab_Data.FindAll();
				
				if(labs.size()!=0) {
					for(int j=0;j<labs.size();j++) {
						System.out.println(labs.get(j).Display());
					}
					
			}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter Apparatus ID(Integer)");
				int showone=scanner.nextInt();
				if(Lab_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
				
				}
				else {
					System.out.println(Lab_Data.FindOne(showone).Display());
				}
				break;
			case "3":
				System.out.println("Please Enter Lab Name(String)");
				String searchone = scanner.next();
				if(Lab_Data.Search(searchone).isEmpty() != false) {
					System.out.println("Match did'nt found");
				
				}
				else {
					List<Lab> labs1 = Lab_Data.Search(searchone);
					
					if(labs1.size()!=0) {
						for(int j=0;j<labs1.size();j++) {
							System.out.println(labs1.get(j).Display());
						}
						
				}
				}
				break;
			case "4":
				Lab lab = new Lab();
				
				System.out.println("Please Enter Lab name");
				
				String labname= scanner.next();
				if(Lab_Data.validateStringforAlpha(labname) == true) {
				lab.setLab_Name(labname);
				
					System.out.println("Please Enter Apparatus");
					String appa = scanner.next();
					if(Lab_Data.validateStringforAlpha(appa) == true) {
						lab.setApparatus(appa);
					
					System.out.println("Please Enter Supervisor Staff ID");
					int supID = scanner.nextInt();
					if(Staff_Data.FindOne(supID).getStaff_ID() != 0) {
						lab.setSupervisor(Staff_Data.FindOne(supID));
						System.out.println("Please Enter Lab Detail");
						String Det  = scanner.next();
						lab.setLab_Detail(Det);
						
						
						Lab_Data.Save(lab);
						System.out.println("New Record Saved");
					}else {
						System.out.println("Staff ID not found");
					}
				}else {
						System.out.println("apparatus must contain alphabats");
				}	
			}else {System.out.println("Entered Lab name must contain alphabats");
		}
					
				
				
				
				
				break;
			case "5":
				Lab lab1 = new Lab();
				
				System.out.println("Please New Enter Lab name");
				
				String labname1= scanner.next();
				if(Lab_Data.validateStringforAlpha(labname1) == true) {
				lab1.setLab_Name(labname1);
				
					System.out.println("Please New Enter Apparatus");
					String appa1 = scanner.next();
					if(Lab_Data.validateStringforAlpha(appa1) == true) {
						lab1.setApparatus(appa1);
					
					System.out.println("Please New Enter Supervisor Staff ID");
					int supID1 = scanner.nextInt();
					if(Staff_Data.FindOne(supID1).getStaff_ID() != 0) {
						lab1.setSupervisor(Staff_Data.FindOne(supID1));
						System.out.println("Please Enter New Lab Detail");
						String Det1  = scanner.next();
						lab1.setLab_Detail(Det1);
						
						
						Lab_Data.Save(lab1);
						System.out.println("Record Updated Successfully");
					}else {
						System.out.println("Staff ID not found");
					}
				}else {
						System.out.println("apparatus must contain alphabats");
				}	
			}else {System.out.println("Entered Lab name must contain alphabats");
		}
				break;
			case "6":
				System.out.println("Please Enter Apparatus ID to Delete");
				int del = scanner.nextInt();
				
				if(Lab_Data.DelOne(del) == null) {
					System.out.println("ID not Found");
				}else {
					Lab_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Lab");
				if(Lab_Data.DelAll() == null) {
					System.out.println("ID not Found");
				}else {
					Lab_Data.DelAll();
					
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
