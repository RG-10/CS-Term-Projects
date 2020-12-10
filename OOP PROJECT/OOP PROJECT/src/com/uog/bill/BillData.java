package com.uog.bill;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.uog.product.ProductData;
import com.uog.stock.StockData;
import com.uog.store.StoreData;
import com.uog.customer.CustomerData;
import com.uog.person.PersonData;

@SuppressWarnings("unused")
public class BillData 
{
	@SuppressWarnings("resource")
	public static List<Bill> FindAll()
	{
		List<Bill> bills = new ArrayList<Bill>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Bill.csvFile));
			while ((line = buffereader.readLine()) != null)
			{	
				Bill bill=new Bill();
				String[] billRow = line.split(",");
				bill.setBILL_ID(Integer.parseInt(billRow[0]));
				bill.setBILL_NAME(billRow[1]);
				bill.setSTORE_ID(StoreData.FindOne(Integer.parseInt(billRow[2])));
				bill.setCUSTOMER_ID(CustomerData.FindOne(Integer.parseInt(billRow[3])));
				bill.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(billRow[4])));
                bill.setBILL_TYPE(billRow[5]);
                bill.setBILLRECEIPT(billRow[6]);
                bill.setBILL_DESC(billRow[7]);
				bills.add(bill);
			}
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return bills;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("resource")
	public static Bill FindOne(int bill_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Bill.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Bill bill=new Bill();
				String[] billRow = line.split(",");
				if(Integer.parseInt(billRow[0])== bill_id)
				{
					bill.setBILL_ID(Integer.parseInt(billRow[0]));
					bill.setBILL_NAME(billRow[1]);
					bill.setSTORE_ID(StoreData.FindOne(Integer.parseInt(billRow[2])));
					bill.setCUSTOMER_ID(CustomerData.FindOne(Integer.parseInt(billRow[3])));
					bill.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(billRow[4])));
	                bill.setBILL_TYPE(billRow[5]);
	                bill.setBILLRECEIPT(billRow[6]);
	                bill.setBILL_DESC(billRow[7]);
				    return bill;
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return null;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource", "unused" })
	public static Bill Search1(int store_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Bill.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Bill bill=new Bill();
				String[] billRow = line.split(",");
				if(Integer.parseInt(billRow[2])== store_id)
				{
					bill.setBILL_ID(Integer.parseInt(billRow[0]));
					bill.setBILL_NAME(billRow[1]);
					bill.setSTORE_ID(StoreData.FindOne(Integer.parseInt(billRow[2])));
					bill.setCUSTOMER_ID(CustomerData.FindOne(Integer.parseInt(billRow[3])));
					bill.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(billRow[4])));
	                bill.setBILL_TYPE(billRow[5]);
	                bill.setBILLRECEIPT(billRow[6]);
	                bill.setBILL_DESC(billRow[7]);
				    return bill;
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return null;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource", "unused" })
	public static Bill Search2(int product_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Bill.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Bill bill=new Bill();
				String[] billRow = line.split(",");
				if(Integer.parseInt(billRow[4])== product_id)
				{
					bill.setBILL_ID(Integer.parseInt(billRow[0]));
					bill.setBILL_NAME(billRow[1]);
					bill.setSTORE_ID(StoreData.FindOne(Integer.parseInt(billRow[2])));
					bill.setCUSTOMER_ID(CustomerData.FindOne(Integer.parseInt(billRow[3])));
					bill.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(billRow[4])));
	                bill.setBILL_TYPE(billRow[5]);
	                bill.setBILLRECEIPT(billRow[6]);
	                bill.setBILL_DESC(billRow[7]);
				    return bill;
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return null;
		}
///////////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource", "unused" })
	public static Bill Search4(int customer_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Bill.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Bill bill=new Bill();
				String[] billRow = line.split(",");
				if(Integer.parseInt(billRow[3])== customer_id)
				{
					bill.setBILL_ID(Integer.parseInt(billRow[0]));
					bill.setBILL_NAME(billRow[1]);
					bill.setSTORE_ID(StoreData.FindOne(Integer.parseInt(billRow[2])));
					bill.setCUSTOMER_ID(CustomerData.FindOne(Integer.parseInt(billRow[3])));
					bill.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(billRow[4])));
	                bill.setBILL_TYPE(billRow[5]);
	                bill.setBILLRECEIPT(billRow[6]);
	                bill.setBILL_DESC(billRow[7]);
				    return bill;
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return null;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource" })
	public static List<Bill> Search3(String bill_name)
	{
		List<Bill> bills = new ArrayList<Bill>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Bill.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Bill bill=new Bill();
				String[] billRow = line.split(",");
				if(billRow[1].contains(bill_name)== true)
				{
					bill.setBILL_ID(Integer.parseInt(billRow[0]));
					bill.setBILL_NAME(billRow[1]);
					bill.setSTORE_ID(StoreData.FindOne(Integer.parseInt(billRow[2])));
					bill.setCUSTOMER_ID(CustomerData.FindOne(Integer.parseInt(billRow[3])));
					bill.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(billRow[4])));
	                bill.setBILL_TYPE(billRow[5]);
	                bill.setBILLRECEIPT(billRow[6]);
	                bill.setBILL_DESC(billRow[7]);
			    	bills.add(bill);
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return bills;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource", "static-access" })
	public static  Bill Save(Bill bill)
	{
		FileWriter filewriter;
        List<Bill> bills = FindAll();
		try 
		{
			filewriter = new FileWriter(Bill.csvFile);
			for(int i=0; i<bills.size(); i++)
			{
				filewriter.append(bills.get(i).toString());
				filewriter.append("\n");
			}
			if(bills.size()>0)
			   {  bill.setBILL_ID(bills.get(bills.size()-1).getBILL_ID()+1);  }
			else
			   {  bill.setBILL_ID(1);  }
			filewriter.append(bill.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return bill;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
    public static String DelAll() 
    {
		FileWriter filewriter;
		List<Bill> bills = FindAll();
		try 
		{
			filewriter = new FileWriter(Bill.csvFile);
			
			for(int i=0;i<bills.size();i++) 
			{
				bills.remove(i);
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
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
  public static Bill DelOne(int bill_id) 
  {
		FileWriter filewriter;
		List<Bill> bills = FindAll();
		Bill bill = BillData.FindOne(bill_id);
		try 
		{
			filewriter = new FileWriter(Bill.csvFile);
			for(int i=0;i<bills.size();i++) 
			{
				if(bills.get(i).getBILL_ID()!=bill_id)
				{
					filewriter.append(bills.get(i).toString());
					filewriter.append("\n");
				}
			}
			    filewriter.flush();
				filewriter.close();
	    } 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return bill;
	}
}