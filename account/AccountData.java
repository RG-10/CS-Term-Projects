package com.atm.main.account;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

import com.atm.main.MenuATM;
import com.atm.main.customer.Customer;
import com.atm.main.customer.CustomerData;
import com.atm.main.transactions.CustomerTransactions;

public class AccountData {

	static CustomerData customerData = new CustomerData();
	

	
	 /**
	  * Function to check balance inquiry 
	  * @throws Exception
	  */
	 public static void balanceInquiry() throws Exception{
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter customer-ID to check Balance--> " );
		
		int Id = scan.nextInt();
		
		Customer customer = CustomerData.findOneCustomer(Id);
		
		if(customer == null) {
		
			System.out.println("Sorry! Record with requested-ID doesn't exists--> :( ");
		
		}else {
		
			System.out.println("Your Balance is--> [" + customer.getCustomerBalance()+"]\n\n");
		}
		
		MenuATM.menu();
		
		scan.close();
	}
	
	
    /**
     * User ADMIN deposit cash Method
     * @throws Exception
     */
	public static void depositCash() throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter your ID--> " );
		
		int Id = scan.nextInt();
		
		Customer customer = CustomerData.findOneCustomer(Id);
		
		if(customer == null) {
			
			System.out.println("Sorry! Record with requested-ID doesn't exists--> :( ");
			
		}
		
		else {
			
			System.out.print("Please enter amount to Deposit--> ");
			
			long deposit = scan.nextLong();
			
			long newAmount = customer.getCustomerBalance() + deposit;
			
			customer.setCustomerBalance(newAmount);
			
			customer.setCustomerNoOfTransactions(customer.getCustomerNoOfTransactions()+1);
			
			System.out.println("Your amount-Detials after Transaction--> \n"+ customer.toString());
			
			saveAfterTransaction(customer);
			
			CustomerTransactions.addStatements(customer, customer.getCustomerBalance()-deposit , newAmount , "Deposit" , deposit);
		}
		
		MenuATM.menu();
		
		scan.close();		
	}

	/**
	 * ADMIN withdraw cash by giving ID
	 * @throws Exception
	 */
	public static void withdrawCash() throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Please enter your ID--> " );
		
		int Id = scan.nextInt();
		
		Customer customer = CustomerData.findOneCustomer(Id);
		
		if(customer == null) {
			
			System.out.println("Sorry! Record with requested-ID doesn't exists--> :( ");
			
		}else {
			
			System.out.print("Please enter amount to Widthraw--> ");
			
			long withdraw = scan.nextLong();
			
			while(withdraw<500 || withdraw>30000) {
				
				System.out.println("Caution! Insufficient-Amount--> :(");
				
				System.out.println("You can enter Amount from [500]-[30000]");
				
				System.out.print("Please enter again--> ");
				
				withdraw = scan.nextLong();
			}
			
			long newAmount = customer.getCustomerBalance() - withdraw;
			
			while(newAmount<0) {
				
				System.out.println("\nWarning!! Insufficient-Balance--> You're Restricted--> :(");
				
				System.out.println("Sorry--> System cannot process this transaction--> :(");
				
				System.out.println("Your Avalaible Balance--> ["+ customer.getCustomerBalance()+"]");
				
				System.out.print("Please enter Again-->");
				
				withdraw = scan.nextLong();
				
				newAmount = customer.getCustomerBalance() - withdraw;
			}
			customer.setCustomerBalance(newAmount);
			
			customer.setCustomerNoOfTransactions(customer.getCustomerNoOfTransactions()+1);
			
			System.out.println("Your Detials after-Transaction-->\n"+ customer.toString());
			
			saveAfterTransaction(customer);		
			CustomerTransactions.addStatements(customer,customer.getCustomerBalance()+withdraw , newAmount , "Withdraw" , withdraw);
		}
		MenuATM.menu();
		
		scan.close();		
	}

	/**
	 * When customer make Transaction, for Saving transaction data in List
	 * @param customer
	 * @throws Exception
	 */
	
	public static void saveAfterTransaction(Customer customer) throws Exception{

		List<Customer> customers = CustomerData.displayAllCustomers();
		try {
			FileWriter write = new FileWriter(Customer.CustomerFile);
			
			write.write("");
			
			write.close();

			BufferedWriter writer = new BufferedWriter(new FileWriter(Customer.CustomerFile, true));
			
			for(Customer customerData : customers) {
				
				if(customerData.getCustomerId() == customer.getCustomerId()) {
					
					writer.append(customer.toStringSave());
					
					writer.append("\n");
				}
				else {
					writer.append(customerData.toStringSave());
					
					writer.append("\n");
				}
			}
			
			writer.close();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
