package com.uog.patient;

import java.util.List;
import java.util.Scanner;

import com.uog.doctor.Doctor;
import com.uog.doctor.Doctor_Data;



public class Patient_Menu {

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
				List<Patient> patients = Patient_Data.FindAll();
				
				if(patients.size() != 0 ) {
					for(int j=0;j<patients.size();j++) {
						if(patients.get(j).getDoc_App() == null || patients.get(j).getDoc_App().getStaff_ID() == null) {
							Patient patient4 = patients.get(j);
							System.out.println(patient4.DisplayWithOutDoctor());
							
						
					}
						else {System.out.println(patients.get(j).Display());
						}
					}
					
			}
				else {
					System.out.println("List is empty");
				}
				
						
				break;
				
			case "2":
				System.out.println("Please Enter Patient ID(Integer)");
				int showone=scanner.nextInt();
				if(Patient_Data.FindOne(showone) == null) {
					System.out.println("Match did'nt found");
					
					
				
				}
				else if(Patient_Data.FindOne(showone).getDoc_App() == null){
					System.out.println(Patient_Data.FindOne(showone).DisplayWithOutDoctor());
				}
				else {
					
					System.out.println(Patient_Data.FindOne(showone).Display());
				}
				break;
			case "3":
				System.out.println("Please Enter Patient Name(String)");
				String searchone = scanner.next();
				if(Patient_Data.Search(searchone).isEmpty() == true) {
					System.out.println("Match did'nt found");
				
				}
				else {
					List<Patient> patients1 = Patient_Data.Search(searchone);
					
					if(patients1.isEmpty() != true) {
						for(int j=0;j<patients1.size();j++) {
							if(patients1.get(j).getDoc_App() == null) {
								Patient patient3 = patients1.get(j);
								patient3.DisplayWithOutDoctor();
								
							
						}
							else {System.out.println(patients1.get(j).Display());
							}
						}
					}
				
				}
				break;
			case "4":
				Patient patient = new Patient();
				
				System.out.println("Please Enter Patient name");
				String Username  = scanner.next();
				if(Patient_Data.validateStringforAlpha(Username) == true) {
					patient.setPatient_Name(Username);
					System.out.println("Please Enter Patient Disease");
					String disease = scanner.next();
						if(Patient_Data.validateStringforAlpha(disease) == true) {
							patient.setDisease(disease);
							if(Doctor_Data.Search(disease).isEmpty() == false) {
								List<Doctor> d = Doctor_Data.Search(disease);
								int id =d.get(0).getDoctor_ID();
								patient.setDoc_App(Doctor_Data.FindOne(id));
								
								System.out.println("Enter Patient Gender");
								String gender = scanner.next();
								
								patient.setGender(gender);
								System.out.println("Enter Patient Weight");
								String weight = scanner.next();
								
								patient.setWeight(weight);
								
								System.out.println("Please Enter Patient Status");
								String status = scanner.next();
								patient.setStatus(status);
								
								System.out.println("Please Enter Patient Address");
								String Address = scanner.next();
								patient.setAddress(Address);
								Patient_Data.Save(patient);
								System.out.println("New Record Saved");
							}
								else {System.out.println("Sorry but Doctor of Your Disease not Available");};
					
				}else {System.out.println("Patient Disease must be alphabatic");
				
				};
			}else {System.out.println("Patient Name must be alphabatic");
							};
									
				break;
			case "5":
				
				
				Patient patient1 = new Patient();
				
				System.out.println("Please Enter Patient name");
				String Username1  = scanner.next();
				if(Patient_Data.validateStringforAlpha(Username1) == true) {
					patient1.setPatient_Name(Username1);
					System.out.println("Please Enter Patient Disease");
					String disease1 = scanner.next();
						if(Patient_Data.validateStringforAlpha(disease1) == true) {
							patient1.setDisease(disease1);
							if(Doctor_Data.Search(disease1).isEmpty() == false) {
								List<Doctor> d1 = Doctor_Data.Search(disease1);
								int id1 =d1.get(0).getDoctor_ID();
								patient1.setDoc_App(Doctor_Data.FindOne(id1));
								
								System.out.println("Enter Patient Gender");
								String gender1 = scanner.next();
								
								patient1.setGender(gender1);
								System.out.println("Enter Patient Weight");
								String weight1 = scanner.next();
								
								patient1.setWeight(weight1);
								
								System.out.println("Please Enter Patient Status");
								String status1 = scanner.next();
								patient1.setStatus(status1);
								
								System.out.println("Please Enter Patient Address");
								String Address1 = scanner.next();
								patient1.setAddress(Address1);
								
								System.out.println("Enter ID to Update");
								int updateid = scanner.nextInt();
								Patient_Data.Update(updateid, patient1);
								System.out.println("New Record Updated");
							}
								else {System.out.println("Sorry but Doctor of Your Disease not Available");};
					
				}else {System.out.println("Patient Disease must be alphabatic");
				
				};
			}else {System.out.println("Patient Name must be alphabatic");
							};
									
				break;
			case "6":
				System.out.println("Please Enter Patient ID to Delete");
				int del = scanner.nextInt();
				
				if(Patient_Data.DelOne(del) == null) {
					System.out.println("ID not Found");
				}else {
					Patient_Data.DelOne(del);
					System.out.println("Deleted Successfully");
				}
				
				
				break;
			case "7":
				System.out.println("You Selected to Delete All Data of Staff");
				if(Patient_Data.DelAll() == null) {
					System.out.println("ID not Found");
				}else {
					Patient_Data.DelAll();
					
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
