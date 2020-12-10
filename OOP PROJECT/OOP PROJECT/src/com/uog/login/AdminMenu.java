package com.uog.login;

import java.util.List;
import java.util.Scanner;

import com.uog.person.Person;
import com.uog.person.PersonData;

public interface AdminMenu {


	@SuppressWarnings({ "static-access", "resource" })
	public static void AdminMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                WELCOME to  Admin Menu             ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All Admin DATA");
			System.out.println("2.  INSERT Admin ROW");
			System.out.println("3.  SEARCH Admin By Admin-ID");
			System.out.println("5.  DELETE Admin By Admin-ID");
			System.out.println("6.  DELETE All Admin Data");
			System.out.println("7.  QUIT Admin");
			System.out.print("Enter Your Choice [1-7]: ");
			
			choice = scan.nextInt();
			
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("       Show All Admin DATA    ");
				System.out.println("=================================");
				List<Admin> product = AdminData.FindAll();
				
				for (int i=0; i<product.size(); i++) {
				       System.out.println(product.get(i).toString());   }
				
			    System.out.println("=================================");
			    
				break;
				
			 case 2:
				 
				System.out.println("=================================");
				System.out.println("        Insert Admin ROW       ");
				System.out.println("=================================");
				
				Admin Customer2 = new Admin();
				
				System.out.print("Enter Person ID: ");
				int person_ID = scan.nextInt();
				Person person = PersonData.FindOne(person_ID);
				
				Customer2.setPerson_ID(person);
				
				
				System.out.print("Enter Person Username: ");
				String Uname= scan.next();
				Customer2.setADMIN_USERNAME(Uname);
				
				System.out.print("Enter Person Password: ");
				String Password = scan.next();
				Customer2.setADMIN_PASSWORD(Password);
				
				
				
				Customer2 = AdminData.Save(Customer2);
				System.out.println(Customer2.toString());
				
				
				System.out.println("=================================");
				
				break;
				
			case 3:
				
				System.out.println("=================================");
				System.out.println("       Search By Admin ID     ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				
				AdminData Customerdata3 = new AdminData ();
				
				Scanner search1 = new Scanner(System.in);
				
				int s1 = search1.nextInt();
				
				Admin  Customer3 = Customerdata3.FindOne(s1);
				 System.out.println(Customer3.toString());
				 
				 System.out.println("=================================");
				 
				break;
				
			
				
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("      Delete Admin By ID          ");
				System.out.println("=================================");
				System.out.print("Enter Person ID: ");
				
				int delete = scan.nextInt();
				
				Admin Customer5 = AdminData.DelOne(delete);
				System.out.println(Customer5.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 6:
				
				System.out.println("=================================");
				System.out.println("      Delete All Admin       ");
				System.out.println("=================================");
				
				String Customer6 = AdminData .DelAll(); 
			      System.out.println(Customer6); 
			      
				break;
				
			case 7:
				
				System.out.println("=================================");
				System.out.println("          Quit-Admin          ");
				System.out.println("=================================");
				
				break;
			}
		}
	}
}