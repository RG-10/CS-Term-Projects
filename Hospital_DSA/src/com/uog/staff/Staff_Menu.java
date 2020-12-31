package com.uog.staff;

import java.util.List;
import java.util.Scanner;


import com.uog.admin.Admin_Data;


public class Staff_Menu {
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
				List<Staff> staffs = Staff_Data.FindAll();
				
				if(staffs.size()!=0) {
					for(int j=0;j<staffs.size();j++) {
						System.out.println(staffs.get(j).Display());
					}
					
			}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter Staff ID(Integer)");
				int showone=scanner.nextInt();
				if(Staff_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
					
					
				
				}
				else {
					System.out.println(Staff_Data.FindOne(showone).Display());
				}
				break;
			case "3":
				System.out.println("Please Enter Staff Name(String)");
				String searchone = scanner.next();
				if(Staff_Data.Search(searchone).isEmpty() == true) {
					System.out.println("Match did'nt found");
				
				}
				else {
					List<Staff> staffs1 = Staff_Data.Search(searchone);
					
					if(staffs1.size()!=0) {
						for(int j=0;j<staffs1.size();j++) {
							System.out.println(staffs1.get(j).Display());
						}
						
				}
				}
				break;
			case "4":
				Staff staff = new Staff();
				
				System.out.println("Please Enter Staff Username");
				String Username  = scanner.next();
				if(Admin_Data.validateStringforAlpha(Username) == true) {
					staff.setStaff_Name(Username);
					System.out.println("Please Enter Staff Qualification");
					String qual = scanner.next();
						if(Staff_Data.validateStringforAlpha(qual) == true) {
							staff.setQualification(qual);
							System.out.println("Please Enter Phone number");
							String Phone= scanner.next();
								if(Admin_Data.validateStringForNumeric(Phone) == true) {
									staff.setPhone_Number(Phone);
									System.out.println("Enter Staff Age");
									int age  = scanner.nextInt();
									staff.setAge(age);
									System.out.println("Enter Staff Salary");
									int sal = scanner.nextInt();
									staff.setSalary(sal);
									System.out.println("Please Enter Staff Duty");
									String duty = scanner.next();
									staff.setStaff_Duty(duty);
									Staff_Data.Save(staff);
									System.out.println("New Record Saved");
						}else {System.out.println("Staff Phone Number must be Numeric");
						
						};
					}else {System.out.println("Staff Qualification must be alphabatic");
					
					};
				}else {System.out.println("Staff Name must be alphabatic");
						
				
				
				
				
				
				}
				
				break;
			case "5":
				
				
				
				Staff staff1 = new Staff();
				
				System.out.println("Please Enter New Staff Username");
				String Username1  = scanner.next();
				if(Admin_Data.validateStringforAlpha(Username1) == true) {
					staff1.setStaff_Name(Username1);
					System.out.println("Please Enter Staff New Qualification");
					String qual1 = scanner.next();
						if(Staff_Data.validateStringforAlpha(qual1) == true) {
							staff1.setQualification(qual1);
							System.out.println("Please Enter New Phone number");
							String Phone1= scanner.next();
								if(Admin_Data.validateStringForNumeric(Phone1) == true) {
									staff1.setPhone_Number(Phone1);
									System.out.println("Enter New Staff Age");
									int age1  = scanner.nextInt();
									staff1.setAge(age1);
									System.out.println("Enter New Staff Salary");
									int sal1 = scanner.nextInt();
									staff1.setSalary(sal1);
									System.out.println("Please Enter New Staff Duty");
									String duty1 = scanner.next();
									staff1.setStaff_Duty(duty1);
									System.out.println("Please Enter staff id to update");
									int updateid1 = scanner.nextInt();
									Staff_Data.Update(updateid1, staff1);
									System.out.println("Record Updated Successfully");
						}else {System.out.println("Staff Phone Number must be Numeric");
						
						};
					}else {System.out.println("Staff Qualification must be alphabatic");
					
					};
				}else {System.out.println("Staff Name must be alphabatic");
					

				}
				break;
			case "6":
				System.out.println("Please Enter Staff ID to Delete");
				int del = scanner.nextInt();
				System.out.println("Deleted Successfully");
				if(Staff_Data.DelOne(del) == null) {
					System.out.println("ID Not Found");
				}else {
					Staff_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Staff");
				if(Staff_Data.DelAll() == null) {
					System.out.println("ID Not Found");
				}else {
					Staff_Data.DelAll();
					
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
