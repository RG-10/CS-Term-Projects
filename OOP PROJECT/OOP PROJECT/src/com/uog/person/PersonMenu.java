package com.uog.person;

import java.util.List;
import java.util.Scanner;


public interface PersonMenu {

	@SuppressWarnings({ "static-access", "resource", "unused" })
	public static void PersonMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                WELCOME to  Person Menu             ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All Person DATA");
			System.out.println("2.  INSERT Person ROW");
			System.out.println("3.  SEARCH Person By Person-ID");
			System.out.println("5.  DELETE Person By Person-ID");
			System.out.println("6.  DELETE All Person Data");
			System.out.println("7.  QUIT Person");
			System.out.print("Enter Your Choice [1-7]: ");
			
			choice = scan.nextInt();
			
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("       Show All Person DATA    ");
				System.out.println("=================================");
				List<Person> product = PersonData.FindAll();
				
				for (int i=0; i<product.size(); i++) {
				       System.out.println(product.get(i).toString());   }
				
			    System.out.println("=================================");
			    
				break;
				
			 case 2:
				 
				System.out.println("=================================");
				System.out.println("        Insert Person ROW       ");
				System.out.println("=================================");
				
				Person Customer2 = new Person();
		
				System.out.print("Enter Person Furname: ");
				String Fname= scan.nextLine();
				String name = scan.nextLine();
				Customer2.setFore_Name(Fname);
				
				System.out.print("Enter Person Surname: ");
				String Sname = scan.next();
				Customer2.setFore_Name(Sname);
				
				System.out.print("Enter Person Age: ");
				int age = scan.nextInt();
				Customer2.setAge(age);
				
				System.out.print("Enter Product Gender: ");
				String gender= scan.next();
				Customer2.setGender(gender);
				
				System.out.print("Enter Person Address: ");
				String address = scan.next();
				Customer2.setAddress(address);
				
				Customer2 = PersonData.Save(Customer2);
				System.out.println(Customer2.toString());
				
				
				System.out.println("=================================");
				
				break;
				
			case 3:
				
				System.out.println("=================================");
				System.out.println("       Search By Person ID     ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				
				PersonData Customerdata3 = new PersonData ();
				
				Scanner search1 = new Scanner(System.in);
				
				int s1 = search1.nextInt();
				
				Person  Customer3 = Customerdata3.FindOne(s1);
				 System.out.println(Customer3.toString());
				 
				 System.out.println("=================================");
				 
				break;
				
			
				
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("      Delete Person By ID          ");
				System.out.println("=================================");
				System.out.print("Enter Person ID: ");
				int delete = scan.nextInt();
				Person Customer5 = PersonData .DelOne(delete);
				System.out.println(Customer5.toString());
				System.out.println("=================================");
				break;
				
			case 6:
				System.out.println("=================================");
				System.out.println("      Delete All Person       ");
				System.out.println("=================================");
				String Customer6 = PersonData .DelAll(); 
			      System.out.println(Customer6); 
				break;
				
			case 7:
				System.out.println("=================================");
				System.out.println("          Quit-Person          ");
				System.out.println("=================================");
				break;
			}
		}
	}
}