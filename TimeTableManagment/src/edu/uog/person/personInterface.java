package edu.uog.person;

import java.util.List;

import java.util.Scanner;

public class personInterface {

	@SuppressWarnings({ "static-access", "resource" })
	public static void PersonMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                WELCOME to  Persons Menu             ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All PERSONS DATA");
			System.out.println("2.  INSERT PERSON ROW");
			System.out.println("3.  SEARCH PERSONS By Person-ID");
			System.out.println("4.  SEARCH Persons By Fore-Name");
			System.out.println("5.  DELETE Person By Person-ID");
			System.out.println("6.  DELETE All Persons Data");
			System.out.println("7.  QUIT PERSONS");
			System.out.print("Enter Your Choice [1-7]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("       Show All PERSONS DATA     ");
				System.out.println("=================================");
				List<Person> Person1 = personData.findAll();
				
				for (int i=0; i<Person1.size(); i++) {
				       System.out.println(Person1.get(i).toString());   }
				
			    System.out.println("=================================");
			    
				break;
				
			 case 2:
				 
				System.out.println("=================================");
				System.out.println("        Insert PERSON ROW         ");
				System.out.println("=================================");
				Person Person2 = new Person();
				System.out.print("Enter Person Title: ");
				String title = scan.nextLine();
				title += scan.nextLine();
				Person2.setTITLE(title);
				System.out.print("Enter Person Fore-Name: ");
				String forename = scan.nextLine();
				Person2.setFORE_NAME(forename);
				System.out.print("Enter Person Sur-Name: ");
				String surname = scan.nextLine();
				Person2.setSUR_NAME(surname);
				System.out.print("Enter Person Age: ");
				int age = scan.nextInt();
				Person2.setAGE(age);
				System.out.print("Enter Person Gender: ");
				String gender = scan.nextLine();
				Person2.setGENDER(gender);
				System.out.print("Enter Person Address: ");
				String address = scan.nextLine();
				Person2.setADDRESS(address);
				Person2 = personData.Save(Person2);
				System.out.println(Person2.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 3:
				
				System.out.println("=================================");
				System.out.println("       Search By PERSON ID       ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				personData Persondata3 = new personData();
				Scanner search1 = new Scanner(System.in);
				int s1 = search1.nextInt();
				 Person Person3 = Persondata3.findOne(s1);
				 System.out.println(Person3.toString());
				 
				 System.out.println("=================================");
				 
				break;
				
			case 4:
				
				System.out.println("==========================================");
				System.out.println("       Search Person By PERSON NAME       ");
				System.out.println("==========================================");
				System.out.print("Enter search: ");
				personData Persondata4 = new personData();
				Scanner search2 = new Scanner(System.in);
				String s2 = search2.nextLine();
				List<Person> Person4 = Persondata4.search(s2);
				System.out.println(Person4.toString());
				
				System.out.println("==========================================");
				
				break;
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("      Delete Person By ID          ");
				System.out.println("=================================");
				System.out.print("Enter Person ID: ");
				
				int delete = scan.nextInt();
				
				Person Person5 = personData.deleteOne(delete);
				System.out.println(Person5.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 6:
				
				System.out.println("=================================");
				System.out.println("      Delete All PERSONS         ");
				System.out.println("=================================");
				String Person6 = personData.deleteAll(); 
			      System.out.println(Person6); 
			      
				break;
				
			case 7:
				
				System.out.println("=================================");
				System.out.println("             Quit                ");
				System.out.println("=================================");
				
				break;
			}
		}
	}
}
