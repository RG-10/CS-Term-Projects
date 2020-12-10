package com.uog.product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductData 
{
	public static List<Product> FindAll()
	{
		List<Product> products = new ArrayList<Product>();
		String line;
		try 
		{
			@SuppressWarnings("resource")
			BufferedReader buffereader = new BufferedReader(new FileReader(Product.csvFile));
			while ((line = buffereader.readLine()) != null)
			{	
				Product product=new Product();
				String[] productrow = line.split(",");
				product.setPRODUCT_ID(Integer.parseInt(productrow[0]));
				product.setPRODUCT_NAME(productrow[1]);
				product.setPRODUCT_PRICE(Integer.parseInt(productrow[2]));
				product.setPRODUCDCATEGORY_ID(ProductCategoryData.FindOne(Integer.parseInt(productrow[3])));
				product.setPRODUCT_DESC(productrow[4]);
				product.setMANUFACTURE_DATE(productrow[5]);
				product.setEXPIRY_DATE(productrow[6]);
				products.add(product);
			}
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return products;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("resource")
	public static Product FindOne(int product_id)
	{
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Product.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Product product=new Product();
				String[] productrow = line.split(",");
				if(Integer.parseInt(productrow[0])== product_id)
				{
					product.setPRODUCT_ID(Integer.parseInt(productrow[0]));
					product.setPRODUCT_NAME(productrow[1]);
					product.setPRODUCT_PRICE(Integer.parseInt(productrow[2]));
					product.setPRODUCDCATEGORY_ID(ProductCategoryData.FindOne(Integer.parseInt(productrow[3])));
					product.setPRODUCT_DESC(productrow[4]);
					product.setMANUFACTURE_DATE(productrow[5]);
					product.setEXPIRY_DATE(productrow[6]);
				    return product;
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
	
	@SuppressWarnings("resource")
	public static List<Product> Search(String product_name)
	{
		List<Product> products = new ArrayList<Product>();
		String line;
		try 
		{
			BufferedReader buffereader = new BufferedReader(new FileReader(Product.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				Product product=new Product();
				String[] productrow = line.split(",");
				if(productrow[1].contains(product_name)== true)
				{
					product.setPRODUCT_ID(Integer.parseInt(productrow[0]));
					product.setPRODUCT_NAME(productrow[1]);
					product.setPRODUCT_PRICE(Integer.parseInt(productrow[2]));
					product.setPRODUCDCATEGORY_ID(ProductCategoryData.FindOne(Integer.parseInt(productrow[3])));
					product.setPRODUCT_DESC(productrow[4]);
					product.setMANUFACTURE_DATE(productrow[5]);
					product.setEXPIRY_DATE(productrow[6]);
			    	products.add(product);
				}
			}
		}
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e);  
			e.printStackTrace();    
		}
		return products;
		}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static  Product Save(Product product)
	{
		FileWriter filewriter;
        List<Product> products = FindAll();
		try 
		{
			filewriter = new FileWriter(Product.csvFile);
			for(int i=0; i<products.size(); i++)
			{
				filewriter.append(products.get(i).toString());
				filewriter.append("\n");
			}
			if(products.size()>0)
			   { product.setPRODUCT_ID(products.get(products.size()-1).getPRODUCT_ID()+1);
				  }
			else
			   {  product.setPRODUCT_ID(1);  }
			filewriter.append(product.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return product;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
    public static String DelAll() 
    {
		FileWriter filewriter;
		List<Product> products = FindAll();
		try 
		{
			filewriter = new FileWriter(Product.csvFile);
			
			for(int i=0;i<products.size();i++) 
			{
				products.remove(i);
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
  public static Product DelOne(int product_id) 
  {
		FileWriter filewriter;
		List<Product> stocks = FindAll();
		Product stock = ProductData.FindOne(product_id);
		try 
		{
			filewriter = new FileWriter(Product.csvFile);
			for(int i=0;i<stocks.size();i++) 
			{
				if(stocks.get(i).getPRODUCT_ID()!=product_id)
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