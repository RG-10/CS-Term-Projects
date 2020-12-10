

package com.atm.main;

import java.util.List;
import java.util.Scanner;

import com.atm.main.account.AccountData;
import com.atm.main.customer.Customer;
import com.atm.main.customer.CustomerData;
import com.atm.main.funds.FundsData;
import com.atm.main.transactions.CustomerTransactions;

@SuppressWarnings("resource")
public class MenuATM {
	
	public static void adminMenu() throws Exception {
		
		Customer customer = new Customer();
		
		Scanner scan = new Scanner(System.in);
		
		char choice;
		
		System.out.println("\nPlease Enter choice!--> ");
		System.out.println("[------->1. -->Customers-List-------------------]");
		System.out.println("[------->2. -->Specific-Customer----------------]");
		System.out.println("[------->3. -->Add-new-Customer-----------------]");
		System.out.println("[------->4. -->Update-Customer-Record-----------]");
		System.out.println("[------->5. -->Delete-Customer------------------]");
		System.out.println("[------->6. -->Exit-----------------------------]");
		do {
			
			System.out.print("Your-Choice--> ");
			
			try{
				
				choice = scan.next().charAt(0);
				
			}catch (Exception e){
				
				choice = scan.next().charAt(0);
			}
			
			
			switch (choice) {
			
			case '1':
				
				System.out.println(choice);
				
				List<Customer> customers = CustomerData.displayAllCustomers();
				
				customers.stream().forEach(System.out::println);
				
				adminMenu();
				
				break;
				
			case '2':
				
				System.out.println(choice);
				
				customer=null;
				
				System.out.print("Please enter Customer-ID to find Details-->");
				
				int idFound = scan.nextInt();
				
				customer = CustomerData.findOneCustomer(idFound);
				
				System.out.println("Your Details are--> "+ customer.toString());
				
				adminMenu();
				
				break;
				
			case '3':
				
				System.out.println(choice);
				
				customer=null;
				
				customer = CustomerData.addCustomer();
				
				System.out.println("Your Details Are--> "+ customer.toString());
				
				adminMenu();
				
				break;
				
			case '4':
				System.out.println(choice);
				
				System.out.print("Please enter Customer-ID to updated-->");
				
				int idUpdate = scan.nextInt();
				
				customer = CustomerData.findOneCustomer(idUpdate);
				
				System.out.println("Customer-Details before Updating--> "+ customer.toString());
				
				customer = CustomerData.updateCustomer(customer);
				
				System.out.println("Customer-Details after Update-->: "+ customer.toString());
				
				adminMenu();
				
				break;
				
			case '5':
				System.out.println(choice);
				
				System.out.print("Please enter Customer-ID to Delete-->");
				
				int idDelete = scan.nextInt();
				
				customer = CustomerData.findOneCustomer(idDelete);
				
				if(customer==null) {
					
					System.out.println("Oopss! Record doesn't exists for this ID :(");
					
				}else {
					
					CustomerData.deleteCustomer(customer);
					
					System.out.println("Record is Succsessfully Deleted :)");
				}
				
				adminMenu();
				
				break;
			
			   
				
			case '6':
				
				System.out.println("Dear-Customer Thank-You for VISITING-US-->:)");
				
				System.exit(0);
				
				break;
				
			default:
				System.out.println("Hmmmm! Invalid Input--> Please Enter Again!");
				
				break;
			}
			
		} while(!(choice=='1'||choice=='2'||choice=='3'||choice=='4'||choice=='5'||choice=='6'));

	}
	

	public static void menu() throws Exception {
		Customer customer = new Customer();
		Scanner scan = new Scanner(System.in);
		char choice;
		System.out.println("\nPlease Enter choice!--> ");
		System.out.println("[------->0. For -->Details---------------------------]");
		System.out.println("[------->1. For -->Balance-Inqurey-------------------]");
		System.out.println("[------->2. For -->Cash-Deposite---------------------]");
		System.out.println("[------->3. For -->Cash-Widthraw---------------------]");
		System.out.println("[------->4. For -->Transactions-History--------------]");
		System.out.println("[------->5. For -->Last-TEN-Transactions-------------]");
		System.out.println("[------->6. For -->Funds-Transfer--------------------]");
		System.out.println("[------->7. For -->Funds-Transfer-History------------]");
		System.out.println("[------->8. For -->Exit------------------------------]");
		
		do {
			
			System.out.print("Your-Choice--> ");
			
			choice = scan.next().charAt(0);
			
			switch (choice) {
			
			case '0':
				
				System.out.println(choice);
				
				System.out.print("Please enter Customer-ID-->");
				
				int id= scan.nextInt();
				
				customer = CustomerData.findOneCustomer(id);
				
				if(customer==null) {
					
					System.out.println("Sorry! Record doesn't exists for this ID--> :(");
					
				}else {		
					
					System.out.println("Your Details are: "+ customer.toString());
				}
				
				menu();
				
				break;
				
			case '1':
				
				System.out.println(choice);
				
				AccountData.balanceInquiry();
				
				break;
				
			case '2':
				
				System.out.println(choice);
				
				AccountData.depositCash();
				
				break;
				
			case '3':
				
				System.out.println(choice);
				
				AccountData.withdrawCash();
				
				break;
				
			case '4':
				
				System.out.println(choice);
				
				List<String> statements = CustomerTransactions.displayAllStatements();
				
				statements.stream().forEach(System.out::println);
				
				menu();
				
				break;
				
			case '5':
				
				System.out.println(choice);
				
				List<String> statement = CustomerTransactions.displayLast10Statements();
				
				statement.stream().forEach(System.out::println);
				
				menu();
				
				break;
				
			case '6':
				
				System.out.println(choice);
				
				FundsData.fundsTransfer();
				
				break;
				
			case '7':
				
				System.out.println(choice);
				
				System.out.print("Please enter Customer-ID-->");
				
				id = scan.nextInt();
				
				List<String> fundsHistory = FundsData.fundTransferList(id);;
				
				if(fundsHistory == null) {
					
					System.out.println("Oopss! funds-history-->Not-Found!");
					
				}else {	
					
					fundsHistory.stream().forEach(System.out::println);
				}
				
				menu();
				
				break;
				
			case '8':
				
				System.out.println("Dear-Customer Thank-YOU for VISITING :)");
				
				System.exit(0);
				
				break;
				
			default:
				
				System.out.println("Oopss! Invalid-Input-->ReEnter Please");
				
				break;
			}
			
		}while(!(choice=='0'||choice=='1'||choice=='2'||choice=='3'||choice=='4'||choice=='5'||choice=='6'||choice=='7'||choice=='8'));


	}

}

