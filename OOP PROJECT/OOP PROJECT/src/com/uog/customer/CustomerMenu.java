package com.uog.customer;

import java.util.List;
import java.util.Scanner;

public class CustomerMenu {

	 
	@SuppressWarnings({ "static-access", "resource" })
	public static void CustomerMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                WELCOME to  Customers Menu            ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All CUSTOMERS DATA");
			System.out.println("2.  INSERT CUSTOMER ROW");
			System.out.println("3.  SEARCH CUSTOMER By C-ID");
			System.out.println("4.  SEARCH CUSTOMER By Name");
			System.out.println("5.  DELETE CUSTOMER By customer-ID");
			System.out.println("6.  DELETE All CUSTOMERS Data");
			System.out.println("7.  QUIT CUSTOMERS");
			System.out.print("Enter Your Choice [1-7]: ");
			
			choice = scan.nextInt();
			
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println("       Show All CUSTOMERS DATA    ");
				System.out.println("=================================");
				List<Customer> Customer1 = CustomerData.FindAll();
				
				for (int i=0; i<Customer1.size(); i++) {
				       System.out.println(Customer1.get(i).toString());   }
				
			    System.out.println("=================================");
			    
				break;
				
			 case 2:
				 
				System.out.println("=================================");
				System.out.println("        Insert CUSTOMER ROW       ");
				System.out.println("=================================");
				
				Customer Customer2 = new Customer();
				
				System.out.print("Enter Customer Name: ");
				String name = scan.nextLine();
				name += scan.nextLine();
				Customer2.setCUSTOMER_NAME(name);
				
				System.out.print("Enter Customer Mobile Number: ");
				String cellno = scan.nextLine();
				Customer2.setCUSTOMER_MOBILE(cellno);
				
				System.out.print("Enter Customer Email-ID: ");
				String emailID = scan.nextLine();
				Customer2.setCUSTOMER_EMAIL(emailID);
				
				
				System.out.print("Enter Customer ADDRESS: ");
				String address = scan.next();
				Customer2.setCUSTOMER_ADDRESS(address);
				
				Customer2 = CustomerData.Save(Customer2);
				System.out.println(Customer2.toString());
				
				
				System.out.println("=================================");
				
				break;
				
			case 3:
				
				System.out.println("=================================");
				System.out.println("       Search By CUSTOMER ID     ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				
				CustomerData Customerdata3 = new CustomerData();
				
				Scanner search1 = new Scanner(System.in);
				
				int s1 = search1.nextInt();
				
				 Customer Customer3 = Customerdata3.FindOne(s1);
				 System.out.println(Customer3.toString());
				 
				 System.out.println("=================================");
				 
				break;
				
			case 4:
				
				System.out.println("==========================================");
				System.out.println("       Search Person By CUSTOMER NAME     ");
				System.out.println("==========================================");
				System.out.print("Enter search: ");
				
				CustomerData Customerdata4 = new CustomerData();
				Scanner search2 = new Scanner(System.in);
				String s2 = search2.nextLine();
				
				List<Customer> Customer4 = Customerdata4.search(s2);
				System.out.println(Customer4.toString());
				
				System.out.println("==========================================");
				
				break;
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("      Delete Customer By ID          ");
				System.out.println("=================================");
				System.out.print("Enter Customer ID: ");
				
				int delete = scan.nextInt();
				
				Customer Customer5 = CustomerData.deleteOne(delete);
				System.out.println(Customer5.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 6:
				
				System.out.println("=================================");
				System.out.println("      Delete All CUSTOMERS       ");
				System.out.println("=================================");
				
				String Customer6 = CustomerData.deleteAll(); 
			      System.out.println(Customer6); 
			      
				break;
				
			case 7:
				
				System.out.println("=================================");
				System.out.println("          Quit-CUSTOMER          ");
				System.out.println("=================================");
				
				break;
			}
		}
	}
}