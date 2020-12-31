package com.uog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.List;
import java.util.Scanner;

import com.uog.admin.Admin;
import com.uog.admin.Admin_Data;
import com.uog.admin.Admin_Menu;
import com.uog.doctor.Doctor_Menu;
import com.uog.facility.Facility_Menu;
import com.uog.lab.Lab_Menu;
import com.uog.medical.Medical_Menu;
import com.uog.patient.Patient_Menu;
import com.uog.room.Room_Menu;
import com.uog.staff.Staff_Menu;

public class Main_Menu {

	public static void Ruuner() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("--Please Enter Username--");
		String username = scanner.next();
		System.out.println("--Please Enter Password--");
		String Password = scanner.next();
		
		List<Admin> AdminCheckUser = Admin_Data.Search(username);
		//List<Admin> AdminCheckPass = Admin_Data.PasswordCheck(Password);
		if(AdminCheckUser.isEmpty() == true) {
			System.out.println("User Do Not Exist");
		}
		
		else if(Admin_Data.Search(username).size()!=0 && Admin_Data.PasswordCheck(Password).size() == 0) {
			System.out.println("--Sorry! Password is Incorrect--");
		}
		else if(Admin_Data.Search(username).size()!=0 && Admin_Data.PasswordCheck(Password).size() != 0){
			Menu();
		}
		scanner.close();
		
}
	@SuppressWarnings("unused")
	public static void Menu()  {
		LocalDateTime now = LocalDateTime.now(); 
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String formatDateTime = now.format(format);  
			String choice;
			boolean  i = true;
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("\n\n\t==============================================================================\n"
						+ 		   "\t            WELCOME TO WALI-MUHAMMAD MEMORIAL HOSPITAL. GURAT  \n"
						+ 		   "\t==============================================================================\n\n"
						+ 		   "\t                              ---MAIN MENU---                                 \n\n"
						+ 		   "          Date "+now.toLocalDate()+"                                       "+   "Time "+now.toLocalTime()+"\n"
						);
			while(i) {
				System.out.println( "\n\nPlease Select Choice\n"
						+ "========================"
								 + "\n1 - Admin Module"
								 + "\n2 - Doctor Module"
								 + "\n3 - Facility Module"
								 + "\n4 - Lab Module"
								 + "\n5 - Medical Module"
								 + "\n6 - Patient Module"
								 + "\n7 - Room Module"
								 + "\n8 - Staff Module"
								 + "\n9 - Exit\n"
						+ "========================");
				choice = scanner.next();
		
			switch(choice) {
			case "1":
				Admin_Menu.Menu();
				break;
			case "2":
				Doctor_Menu.Menu();
				break;
			case "3":
				Facility_Menu.Menu();
				break;
			case "4":
				Lab_Menu.Menu();
				break;
			case "5":
				Medical_Menu.Menu();
				break;
			case "6":
				Patient_Menu.Menu();
				break;
			case "7":
				Room_Menu.Menu();
				break;
			case "8":
				Staff_Menu.Menu();
				break;
			case "9":
				System.out.println("\n=================================\n  --Thank you for Visiting Us--\n================================= ");
				i = false;
				break;
			default:System.out.println("--Please Enter correct Input--");
			}
			
		}
		}
}
