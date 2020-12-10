package com.uog.product;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductCategoryData {


	public static List<ProductCategory> FindAll()
	{
		List<ProductCategory> productscategory = new ArrayList<ProductCategory>();
		String line;
		try 
		{
			@SuppressWarnings("resource")
			BufferedReader buffereader = new BufferedReader(new FileReader(ProductCategory.csvFile));
			while ((line = buffereader.readLine()) != null)
			{	
				ProductCategory productcategory=new ProductCategory();
				String[] productcategoryrow = line.split(",");
				productcategory.setProductCategory_ID(Integer.parseInt(productcategoryrow[0]));
				productcategory.setProductCategory_NAME(productcategoryrow[1]);
				productcategory.setProductCategory_TYPE(productcategoryrow[2]);
				productcategory.setProductCategory_DESC(productcategoryrow[3]);
				productscategory.add(productcategory);
			}
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return productscategory;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ProductCategory FindOne(int productcategory_id)
	{
		String line;
		try 
		{
			@SuppressWarnings("resource")
			BufferedReader buffereader = new BufferedReader(new FileReader(ProductCategory.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				ProductCategory productcategory=new ProductCategory();
				String[] productcategoryrow = line.split(",");
				if(Integer.parseInt(productcategoryrow[0])== productcategory_id)
				{
					productcategory.setProductCategory_ID(Integer.parseInt(productcategoryrow[0]));
					productcategory.setProductCategory_NAME(productcategoryrow[1]);
					productcategory.setProductCategory_TYPE(productcategoryrow[2]);
					productcategory.setProductCategory_DESC(productcategoryrow[3]);
				    return productcategory;
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
	
	public static List<ProductCategory> Search(String product_name)
	{
		List<ProductCategory> products = new ArrayList<ProductCategory>();
		String line;
		try 
		{
			@SuppressWarnings("resource")
			BufferedReader buffereader = new BufferedReader(new FileReader(ProductCategory.csvFile));
			while ((line = buffereader.readLine()) !=null)
			{	
				ProductCategory productcategory=new ProductCategory();
				String[] productcategoryrow = line.split(",");
				if(productcategoryrow[1].contains(product_name)== true)
				{
					productcategory.setProductCategory_ID(Integer.parseInt(productcategoryrow[0]));
					productcategory.setProductCategory_NAME(productcategoryrow[1]);
					productcategory.setProductCategory_TYPE(productcategoryrow[2]);
					productcategory.setProductCategory_DESC(productcategoryrow[3]);
			    	products.add(productcategory);
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
	
	public static  ProductCategory Save(ProductCategory productcategory)
	{
		FileWriter filewriter;
        List<ProductCategory> productscategory = FindAll();
		try 
		{
			filewriter = new FileWriter(ProductCategory.csvFile);
			for(int i=0; i<productscategory.size(); i++)
			{
				filewriter.append(productscategory.get(i).toString());
				filewriter.append("\n");
			}
			if(productscategory.size()>0)
			   { productcategory.setProductCategory_ID(productscategory.get(productscategory.size()-1).getProductCategory_ID()+1);
				  }
			else
			   {  productcategory.setProductCategory_ID(1);;  }
			filewriter.append(productcategory.toString());
			filewriter.append("\n");
			filewriter.flush();
			filewriter.close();
		} 
		catch (IOException e) 
		{   
			System.out.println("CSV File cannot be Read!" +e); 
			e.printStackTrace();    
		}
		return productcategory;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////
    public static String DelAll() 
    {
		FileWriter filewriter;
		List<ProductCategory> productscategory = FindAll();
		try 
		{
			filewriter = new FileWriter(ProductCategory.csvFile);
			
			for(int i=0;i<productscategory.size();i++) 
			{
				productscategory.remove(i);
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
    public static ProductCategory DelOne(int productcategory_ID) 
    {
  		FileWriter filewriter;
  		List<ProductCategory> productscategory = FindAll();
  		ProductCategory productcategory = ProductCategoryData.FindOne(productcategory_ID);
  		try 
  		{
  			filewriter = new FileWriter(ProductCategory.csvFile);
  			for(int i=0;i<productscategory.size();i++) 
  			{
  				if(productscategory.get(i).getProductCategory_ID()!=productcategory_ID)
  				{
  					filewriter.append(productscategory.get(i).toString());
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
  		return productcategory;
  	}
}