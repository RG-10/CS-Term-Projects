package com.uog.stock;
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
public class StockData 
{
	@SuppressWarnings("resource")
	public static List<Stock> FindAll()
	{
		List<Stock> stocks = new ArrayList<Stock>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Stock.csvFile));
			while ((line = buffereader.readLine()) != null)
			{	
				Stock stock=new Stock();
				String[] stockRow = line.split(",");
				stock.setSTOCK_ID(Integer.parseInt(stockRow[0]));
				stock.setSTOCK_NAME(stockRow[1]);
				stock.setSTOCK_TYPE(stockRow[2]);
				stock.setSTOCK_NUMBER(stockRow[3]);
				stock.setSTOCK_DESC(stockRow[4]);
				stock.setISSUE_DATE(stockRow[5]);
				stocks.add(stock);
			}
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return stocks;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource", "unused" })
	public static Stock Search(int stock_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Stock.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Stock stock=new Stock();
				String[] stockRow = line.split(",");
				if(Integer.parseInt(stockRow[0])== stock_id)
				{
					stock.setSTOCK_ID(Integer.parseInt(stockRow[0]));
					stock.setSTOCK_NAME(stockRow[1]);
					stock.setSTOCK_TYPE(stockRow[2]);
					stock.setSTOCK_NUMBER(stockRow[3]);
					stock.setSTOCK_DESC(stockRow[4]);
					stock.setISSUE_DATE(stockRow[5]);
				    return stock;
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
	public static List<Stock> Search1(String stock_name)
	{
		List<Stock> stocks = new ArrayList<Stock>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Stock.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Stock stock=new Stock();
				String[] stockRow = line.split(",");
				if(stockRow[1].contains(stock_name)== true)
				{
					stock.setSTOCK_ID(Integer.parseInt(stockRow[0]));
					stock.setSTOCK_NAME(stockRow[1]);
					stock.setSTOCK_TYPE(stockRow[2]);
					stock.setSTOCK_NUMBER(stockRow[3]);
					stock.setSTOCK_DESC(stockRow[4]);
					stock.setISSUE_DATE(stockRow[5]);
			    	stocks.add(stock);
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return stocks;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource" })
	public static List<Stock> Search3(String stock_no)
	{
		List<Stock> stocks = new ArrayList<Stock>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Stock.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Stock stock=new Stock();
				String[] stockRow = line.split(",");
				if(stockRow[3].contains(stock_no)== true)
				{
					stock.setSTOCK_ID(Integer.parseInt(stockRow[0]));
					stock.setSTOCK_NAME(stockRow[1]);
					stock.setSTOCK_TYPE(stockRow[2]);
					stock.setSTOCK_NUMBER(stockRow[3]);
					stock.setSTOCK_DESC(stockRow[4]);
					stock.setISSUE_DATE(stockRow[5]);
			    	stocks.add(stock);
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return stocks;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	@SuppressWarnings({ "resource", "static-access" })
	public static  Stock Save(Stock stock)
	{
		FileWriter filewriter;
        List<Stock> stocks = FindAll();
		try 
		{
			filewriter = new FileWriter(Stock.csvFile);
			for(int i=0; i<stocks.size(); i++)
			{
				filewriter.append(stocks.get(i).toString());
				filewriter.append("\n");
			}
			if(stocks.size()>0)
			   {  stock.setSTOCK_ID(stocks.get(stocks.size()-1).getSTOCK_ID()+1);  }
			else
			   {  stock.setSTOCK_ID(1);  }
			filewriter.append(stock.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return stock;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
    public static String DelAll() 
    {
		FileWriter filewriter;
		List<Stock> stocks = FindAll();
		try 
		{
			filewriter = new FileWriter(Stock.csvFile);
			
			for(int i=0;i<stocks.size();i++) 
			{
				stocks.remove(i);
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
  public static Stock DelOne(int stock_id) 
  {
		FileWriter filewriter;
		List<Stock> stocks = FindAll();
		Stock stock = StockData.Search(stock_id);
		try 
		{
			filewriter = new FileWriter(Stock.csvFile);
			for(int i=0;i<stocks.size();i++) 
			{
				if(stocks.get(i).getSTOCK_ID()!=stock_id)
				{
					filewriter.append(stocks.get(i).toString());
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
		return stock;
	}
}