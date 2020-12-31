package com.uog.admin;

import java.util.List;
import java.util.Scanner;


import com.uog.staff.Staff_Data;

public class Admin_Menu {

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
			List<Admin> admins = Admin_Data.FindAll();
			
			if(admins.size()!=0) {
				for(int j=0;j<admins.size();j++) {
					if(admins.get(j).getStaff_ID() != null) {
					System.out.println(admins.get(j).Display());
				}else {
					System.out.println("Staff is not found");
				}
				}
				
		}
			else {
				System.out.println("List is empty");
			}
			
					
			break;
			
		case "2":
			System.out.println("Please Enter Admin ID(Integer)");
			int showone=scanner.nextInt();
			if(Admin_Data.FindOne(showone) == null) {
				System.out.println("Match did'nt found");
			
			}
			else if(Admin_Data.FindOne(showone).getStaff_ID() == null) {
				System.out.println("Staff not found");
				
			}
			else {
				System.out.println(Admin_Data.FindOne(showone).Display());
			}
			break;
		case "3":
			System.out.println("Please Enter Admin Name(String)");
			String searchone = scanner.next();
			if(Admin_Data.Search(searchone).isEmpty() == true) {
				System.out.println("Match did'nt found");
			
			}
			else {
				List<Admin> admins1 = Admin_Data.Search(searchone);
				if(admins1.size()!=0) {
					for(int j=0;j<admins1.size();j++) {
						System.out.println(admins1.get(j).Display());
					}
					
			}
				
			}
			break;
		case "4":
			Admin admin = new Admin();
			
			System.out.println("Please Enter Staff_ID");
			
			int StaffID= scanner.nextInt();
			
			
			admin.setStaff_ID(Staff_Data.FindOne(StaffID));	
			if(Staff_Data.FindOne(StaffID).getStaff_ID() == 0) {
				System.out.println("Staff ID didNot Found");
			}
			else {
			System.out.println("Please Enter Admin Username");
			String Username  = scanner.next();
			if(Admin_Data.validateStringforAlpha(Username) == true) {
			admin.setAdmin_Username(Username);
			System.out.println("Please Enter Admin Password");
			String Password = scanner.next();
			
			admin.setAdmin_Password(Password);
			
				
			Admin_Data.Save(admin);
			System.out.println("New Record Saved");
			}else {System.out.println("Entered Username must contain alphabats");}
			
			}
			
			
			break;
		case "5":
			Admin admin1 = new Admin();
			
			
			System.out.println("Please Enter Staff_ID");
			int Staff_ID_1= scanner.nextInt();
			admin1.setStaff_ID(Staff_Data.FindOne(Staff_ID_1));
			if(Staff_Data.FindOne(Staff_ID_1).getStaff_ID() == 0) {
				System.out.println("Staff ID didNot Found");
			}
			else {
			System.out.println("Please Enter New Admin Username");
			String Username_1  = scanner.next();
			admin1.setAdmin_Username(Username_1);
			System.out.println("Please Enter New Admin Password");
			String Password_1 = scanner.next();
			admin1.setAdmin_Password(Password_1);
			System.out.println("Enter Admin ID to Update");
			int updateid = scanner.nextInt();
			Admin_Data.Update(updateid, admin1);
			System.out.println("Record Updated Successfully");
			}
			break;
		case "6":
			System.out.println("Please Enter Admin ID to Delete");
			int del = scanner.nextInt();
			
			if(Admin_Data.DelOne(del) == null) {
				System.out.println("ID not found");
			}
			else {
				Admin_Data.DelOne(del);
				System.out.println("Deleted Successfully");
			}
			
			
			break;
		case "7":
			System.out.println("You Selected to Delete All Data of Admin");
			if(Admin_Data.DelAll() == null) {
				System.out.println("ID not found");
			}
			else {
				Admin_Data.DelAll();
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
