package com.uog.store;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.uog.product.ProductData;
import com.uog.stock.StockData;
import com.uog.person.PersonData;

@SuppressWarnings("unused")
public class StoreData 
{
	@SuppressWarnings("resource")
	public static List<Store> FindAll()
	{
		List<Store> stores = new ArrayList<Store>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Store.csvFile));
			while ((line = buffereader.readLine()) != null)
			{	
				Store store=new Store();
				String[] storeRow = line.split(",");
				store.setSTORE_ID(Integer.parseInt(storeRow[0]));
				store.setSTOCK_ID(StockData.Search(Integer.parseInt(storeRow[1])));
				store.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(storeRow[2])));
				store.setSTORE_NAME(storeRow[3]);
				store.setSTORE_TYPE(storeRow[4]);
				store.setSTORE_DESC(storeRow[5]);
				store.setADDRESS(storeRow[6]);
				stores.add(store);
			}
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return stores;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("resource")
	public static Store FindOne(int store_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Store.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Store store=new Store();
				String[] storeRow = line.split(",");
				if(Integer.parseInt(storeRow[0])== store_id)
				{
					store.setSTORE_ID(Integer.parseInt(storeRow[0]));
					store.setSTOCK_ID(StockData.Search(Integer.parseInt(storeRow[1])));
					store.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(storeRow[2])));
					store.setSTORE_NAME(storeRow[3]);
					store.setSTORE_TYPE(storeRow[4]);
					store.setSTORE_DESC(storeRow[5]);
					store.setADDRESS(storeRow[6]);
				    return store;
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
	public static Store Search1(int stock_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Store.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Store store=new Store();
				String[] storeRow = line.split(",");
				if(Integer.parseInt(storeRow[1])== stock_id)
				{
					store.setSTORE_ID(Integer.parseInt(storeRow[0]));
					store.setSTOCK_ID(StockData.Search(Integer.parseInt(storeRow[1])));
					store.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(storeRow[2])));
					store.setSTORE_NAME(storeRow[3]);
					store.setSTORE_TYPE(storeRow[4]);
					store.setSTORE_DESC(storeRow[5]);
					store.setADDRESS(storeRow[6]);
				    return store;
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
	public static Store Search2(int product_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Store.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Store store=new Store();
				String[] storeRow = line.split(",");
				if(Integer.parseInt(storeRow[2])== product_id)
				{
					store.setSTORE_ID(Integer.parseInt(storeRow[0]));
					store.setSTOCK_ID(StockData.Search(Integer.parseInt(storeRow[1])));
					store.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(storeRow[2])));
					store.setSTORE_NAME(storeRow[3]);
					store.setSTORE_TYPE(storeRow[4]);
					store.setSTORE_DESC(storeRow[5]);
					store.setADDRESS(storeRow[6]);
				    return store;
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
	public static List<Store> Search3(String store_name)
	{
		List<Store> stores = new ArrayList<Store>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Store.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Store store=new Store();
				String[] storeRow = line.split(",");
				if(storeRow[3].contains(store_name)== true)
				{
					store.setSTORE_ID(Integer.parseInt(storeRow[0]));
					store.setSTOCK_ID(StockData.Search(Integer.parseInt(storeRow[1])));
					store.setPRODUCT_ID(ProductData.FindOne(Integer.parseInt(storeRow[2])));
					store.setSTORE_NAME(storeRow[3]);
					store.setSTORE_TYPE(storeRow[4]);
					store.setSTORE_DESC(storeRow[5]);
					store.setADDRESS(storeRow[6]);
			    	stores.add(store);
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return stores;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////

	@SuppressWarnings({ "resource", "static-access" })
	public static  Store Save(Store store)
	{
		FileWriter filewriter;
        List<Store> stores = FindAll();
		try 
		{
			filewriter = new FileWriter(Store.csvFile);
			for(int i=0; i<stores.size(); i++)
			{
				filewriter.append(stores.get(i).toString());
				filewriter.append("\n");
			}
			if(stores.size()>0)
			   {  store.setSTORE_ID(stores.get(stores.size()-1).getSTORE_ID()+1);  }
			else
			   {  store.setSTORE_ID(1);  }
			filewriter.append(store.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return store;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
    public static String DelAll() 
    {
		FileWriter filewriter;
		List<Store> stores = FindAll();
		try 
		{
			filewriter = new FileWriter(Store.csvFile);
			
			for(int i=0;i<stores.size();i++) 
			{
				stores.remove(i);
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
  public static Store DelOne(int store_id) 
  {
		FileWriter filewriter;
		List<Store> stores = FindAll();
		Store store = StoreData.FindOne(store_id);
		try 
		{
			filewriter = new FileWriter(Store.csvFile);
			for(int i=0;i<stores.size();i++) 
			{
				if(stores.get(i).getSTORE_ID()!=store_id)
				{
					filewriter.append(stores.get(i).toString());
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
		return store;
	}
}