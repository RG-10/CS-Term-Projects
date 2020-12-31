package com.uog.medical;

import java.util.List;
import java.util.Scanner;


public class Medical_Menu {

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
				List<Medical> medicals = Medical_Data.FindAll();
				
				if(medicals.isEmpty() != true) {
					for(int j=0;j<medicals.size();j++) {
						System.out.println(medicals.get(j).Display());
					}
					
			}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter Medicine ID(Integer)");
				int showone=scanner.nextInt();
				if(Medical_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
					
					
				
				}
				else {
					System.out.println(Medical_Data.FindOne(showone).Display());
				}
				break;
			case "3":
				System.out.println("Please Enter Medicine Name(String)");
				String searchone = scanner.next();
				if(Medical_Data.Search(searchone).isEmpty() == true) {
					System.out.println("Match did'nt found");
				
				}
				else {
					List<Medical> medicals1 = Medical_Data.Search(searchone);
					
					if(medicals1.isEmpty() != true) {
						for(int j=0;j<medicals1.size();j++) {
							System.out.println(medicals1.get(j).Display());
						}
						
				}
				}
				break;
			case "4":
				Medical medical = new Medical();
				
				System.out.println("Please Enter Medicine Name");
				String mediname  = scanner.next();
				if(Medical_Data.validateStringforAlpha(mediname) == true) {
					medical.setMedicine_Name(mediname);
					System.out.println("Please Enter Medicine Menufacturer");
					String medimenu  = scanner.next();
					if(Medical_Data.validateStringforAlpha(medimenu) == true) {
						medical.setManufacturer(medimenu);
						
					
						System.out.println("Please Enter medicine cost");
						int medicost = scanner.nextInt();
						medical.setPrice(medicost);
						Medical_Data.Save(medical);
						System.out.println("New Record Saved");
						
					}else {System.out.println("Menufacturer name must be alphabatic");
					
					}
				}else {System.out.println("medicine name must be alphabatic");
					}
				
				
				
				
				
				
				
				
			
				break;
			case "5":
				
				Medical medical1 = new Medical();
				
				System.out.println("Please Enter New Medicine Name");
				String mediname1  = scanner.next();
				if(Medical_Data.validateStringforAlpha(mediname1) == true) {
					medical1.setMedicine_Name(mediname1);
					System.out.println("Please Enter New Medicine Menufacturer");
					String medimenu1  = scanner.next();
					if(Medical_Data.validateStringforAlpha(medimenu1) == true) {
						medical1.setManufacturer(medimenu1);
						
					
						System.out.println("Please Enter New medicine cost");
						int medicost1 = scanner.nextInt();
						medical1.setPrice(medicost1);
						System.out.println("Enter Id to Update");
						int updateid = scanner.nextInt();
						Medical_Data.Update(updateid, medical1);
					
						System.out.println("Record updated Successsfully");
					}
					}else {System.out.println("Menufacturer name must be alphabatic");
					
					}
				
						
				
				break;
	
			case "6":
				System.out.println("Please Enter Medicine ID to Delete");
				int del = scanner.nextInt();
				
				if(Medical_Data.DelOne(del) == null) {
					System.out.println("ID not Found");
				}else {
					Medical_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Staff");
				if(Medical_Data.DelAll() == null) {
					System.out.println("ID not Found");
				}else {
					Medical_Data.DelAll();
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
