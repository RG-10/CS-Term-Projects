package com.uog.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.uog.bill.BillData;

public class CustomerData {

	@SuppressWarnings("resource")
	
	public static List<Customer> FindAll() {
		
		List<Customer> customers = new ArrayList<Customer>();
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				Customer customer = new Customer();
				
				String[] customerRow = line.split(",");
				
				customer.setCUSTOMER_ID(Integer.parseInt(customerRow[0]));
				customer.setCUSTOMER_NAME(customerRow[1]);
				customer.setCUSTOMER_MOBILE(customerRow[2]);
				customer.setCUSTOMER_EMAIL(customerRow[3]);
				customer.setCUSTOMER_ADDRESS(customerRow[4]);
				customers.add(customer);
				
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return customers;
		
	}
@SuppressWarnings("resource")
public static Customer FindOne(int customer_ID) {
		
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				Customer customer = new Customer();
				
				String[] customerRow = line.split(",");
				
				if(Integer.parseInt(customerRow[0]) == customer_ID){
				
					customer.setCUSTOMER_ID(Integer.parseInt(customerRow[0]));
					customer.setCUSTOMER_NAME(customerRow[1]);
					customer.setCUSTOMER_MOBILE(customerRow[2]);
					customer.setCUSTOMER_EMAIL(customerRow[3]);
					customer.setCUSTOMER_ADDRESS(customerRow[4]);
					
					
				 return customer;
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

@SuppressWarnings("resource")
 public static Customer deleteOne(int customer_ID)  {
	      FileWriter filewriter;

	      List<Customer> customers = FindAll();
	      
	      Customer customer = FindOne(customer_ID);

	try {
		filewriter = new FileWriter(Customer.csvFile);

		for (int i=0; i<customers.size(); i++) {
			if (customers.get(i).getCUSTOMER_ID() != customer_ID) {
				filewriter.append(customers.get(i).toString());
				filewriter.append("\n");
			}
		}
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	return customer;
}

@SuppressWarnings("resource")
public static List<Customer> search(String search) {
		
	    List<Customer> customers = new ArrayList<Customer>();
	
		String line;
		
		try {
			BufferedReader bufferreader = new BufferedReader(new FileReader(Customer.csvFile));
			
			while((line = bufferreader.readLine()) != null) {
				
				Customer customer = new Customer();
				
				String[] customerRow = line.split(",");
				
				if(customerRow[1].contains(search) == true){
				
					customer.setCUSTOMER_ID(Integer.parseInt(customerRow[0]));
					customer.setCUSTOMER_NAME(customerRow[1]);
					customer.setCUSTOMER_MOBILE(customerRow[2]);
					customer.setCUSTOMER_EMAIL(customerRow[3]);
					customer.setCUSTOMER_ADDRESS(customerRow[4]);
				 
					customers.add(customer);
				}
		
			}
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return customers;
		
	}
     

public static Customer Save(Customer customer) {
	FileWriter filewriter;

	List<Customer> customers = FindAll();

	try {
		filewriter = new FileWriter(Customer.csvFile);

		for (int i=0; i<customers.size(); i++) {
			filewriter.append(customers.get(i).toString());
			filewriter.append("\n");
		}
		if (customers.size()>0)
			customer.setCUSTOMER_ID(customers.get(customers.size()-1).getCUSTOMER_ID()+1);
		else
			customer.setCUSTOMER_ID(1);
		filewriter.append(customer.toString());
		filewriter.append("\n");
		filewriter.flush();
		filewriter.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	return customer;
}
public static String deleteAll() 
    {
		FileWriter filewriter;
		List<Customer> customers = FindAll();
		try 
		{
			filewriter = new FileWriter(Customer.csvFile);
			
			for(int i=0;i<customers.size();i++) 
			{
				customers.remove(i);
			}
				filewriter.flush();
				filewriter.close();
	    } 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return "Removed Successfully";
	}}