package com.uog.doctor;

import java.util.List;
import java.util.Scanner;


import com.uog.admin.Admin_Data;

import com.uog.room.Room_Data;
import com.uog.staff.Staff_Data;

public class Doctor_Menu {

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
				List<Doctor> doctors = Doctor_Data.FindAll();
				
				if(doctors.isEmpty() == false) {
					for(int j=0;j<doctors.size();j++) {
						if(doctors.get(j).getStaff_ID()!= null) {
						System.out.println(doctors.get(j).Display());
						}
					else {
						System.out.println("Staff is not Found so it can't be Doctor anymore\nWith Doctor ID "+doctors.get(j).getDoctor_ID());
					}
					}
					}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter doctor ID(Integer)");
				int showone=scanner.nextInt();
				if(Doctor_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
				
				}
				else if(Doctor_Data.FindOne(showone).getStaff_ID()!= null) {
					System.out.println(Doctor_Data.FindOne(showone).Display());
				}
				else {
					System.out.println("Staff is not Found so it can't be Doctor anymore");
				}
				break;
			case "3":
				System.out.println("Please Enter Doctor Speciality");
				String searchone = scanner.next();
				if(Doctor_Data.Search(searchone).size() == 0) {
					System.out.println("Match did'nt found");
				
				}
				else {
					List<Doctor> doctors1 = Doctor_Data.Search(searchone);
					
					if(doctors1.isEmpty() == false) {
						for(int j=0;j<doctors1.size();j++) {
							if(doctors1.get(j).getStaff_ID()!= null) {
							System.out.println(doctors1.get(j).Display());
							}
						else {
							
							System.out.println("Staff is not Found so it can't be Doctor anymore\n");
						}
						}
						}
				}
				break;
			case "4":
				Doctor admin = new Doctor();
				
				System.out.println("Please Enter Staff_ID");
				
				int StaffID= scanner.nextInt();
				
				
				admin.setStaff_ID(Staff_Data.FindOne(StaffID));	
				if(Staff_Data.FindOne(StaffID) == null) {
					System.out.println("Staff ID didNot Found");
				}
				else {
					

						System.out.println("Please Enter Specialty");
						String spe = scanner.next();
						
							if(Admin_Data.validateStringforAlpha(spe) == true) {
								admin.setSpecialty(spe);}
							else {System.out.println("Specialty must be Alphabatic");}
							System.out.println("Please Enter Room ID of Doctor");
							int DocID = scanner.nextInt();
							if(Room_Data.FindOne(DocID) == null) {
								System.out.println("Room does not Exist");
							}else {admin.setRoom_ID(Room_Data.FindOne(DocID));}
							
						Doctor_Data.Save(admin);
						System.out.println("New Record Saved");
						
					
				
			}
			
				break;
			case "5":
				Doctor doctor2 = new Doctor();
				
				
				System.out.println("Please Enter Staff_ID");
				int Staff_ID_1= scanner.nextInt();
				doctor2.setStaff_ID(Staff_Data.FindOne(Staff_ID_1));
				System.out.println("Please Enter New Specialty");
				String specialty  = scanner.next();
				doctor2.setSpecialty(specialty);
				System.out.println("Enter Room ID");
				int ROOM_ID = scanner.nextInt();
				doctor2.setRoom_ID(Room_Data.FindOne(ROOM_ID));
			
				
				System.out.println("Enter Doctor ID to Update");
				int updateid = scanner.nextInt();
				
				if(Doctor_Data.FindOne(updateid) == null) {
					System.out.println("ID not Found");
				}
				else {
					Doctor_Data.Update(updateid, doctor2);
					System.out.println("Record Updated Successfully");
				}
				
				break;
			case "6":
				System.out.println("Please Enter Doctor ID to Delete");
				int del = scanner.nextInt();
				
				
				if(Doctor_Data.DelOne(del)==null) {
					System.out.println("ID not found");
				}else {
					Doctor_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Admin");
				if(Doctor_Data.DelAll()==null) {
					System.out.println("ID not found");
				}else {
					Doctor_Data.DelAll();
					
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
