package com.uog.product;
import java.util.List;
import java.util.Scanner;

public class ProductCategoryMenu {

	@SuppressWarnings({ "static-access", "resource" })
	public static void ProductCategoryMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("        WELCOME to  ProductCategory Menu             ");
			System.out.println("=====================================================");
			System.out.println("1.  SHOW All ProductCategory DATA");
			System.out.println("2.  INSERT ProductCategory ROW");
			System.out.println("3.  SEARCH ProductCategory By ProductCategory-ID");
			System.out.println("5.  DELETE ProductCategory By ProductCategory-ID");
			System.out.println("6.  DELETE All ProductCategory Data");
			System.out.println("7.  QUIT ProductCategory");
			System.out.print("Enter Your Choice [1-7]: ");
			
			choice = scan.nextInt();
			
			switch (choice) 
			{
			  case 1:
				System.out.println("=================================");
				System.out.println(" Show All ProductCategory DATA    ");
				System.out.println("=================================");
				List<ProductCategory> product = ProductCategoryData.FindAll();
				
				for (int i=0; i<product.size(); i++) {
				       System.out.println(product.get(i).toString());   }
				
			    System.out.println("=================================");
			    
				break;
				
			 case 2:
				 
				System.out.println("=================================");
				System.out.println("     Insert ProductCategory ROW   ");
				System.out.println("=================================");
				
				ProductCategory Customer2 = new ProductCategory();
				
				System.out.print("Enter ProductCategory Name: ");
				String name = scan.nextLine();
				name += scan.nextLine();
				
				Customer2.setProductCategory_NAME(name);
				
				System.out.print("Enter ProductCategory TYPE: ");
				String M_date = scan.next();
				Customer2.setProductCategory_TYPE(M_date);
							
				System.out.print("Enter ProductCategory DESCRIPTION: ");
				String desc = scan.next();
				Customer2.setProductCategory_DESC(desc);
				
				Customer2 = ProductCategoryData.Save(Customer2);
				System.out.println(Customer2.toString());
				
				
				System.out.println("=================================");
				
				break;
				
			case 3:
				
				System.out.println("=================================");
				System.out.println("   Search By ProductCategory ID  ");
				System.out.println("=================================");
				System.out.print("Enter search: ");
				
				ProductCategoryData Customerdata3 = new ProductCategoryData ();
				
				Scanner search1 = new Scanner(System.in);
				
				int s1 = search1.nextInt();
				
				ProductCategory  Customer3 = Customerdata3.FindOne(s1);
				 System.out.println(Customer3.toString());
				 
				 System.out.println("=================================");
				 
				break;
				
			
				
				
			case 5:
				
				System.out.println("=================================");
				System.out.println("   Delete ProductCategory By ID  ");
				System.out.println("=================================");
				System.out.print("Enter ProductCategory ID: ");
				
				int delete = scan.nextInt();
				
				ProductCategory Customer5 = ProductCategoryData .DelOne(delete);
				System.out.println(Customer5.toString());
				
				System.out.println("=================================");
				
				break;
				
			case 6:
				
				System.out.println("=================================");
				System.out.println("  Delete All ProductCategory     ");
				System.out.println("=================================");
				
				String Customer6 = ProductCategoryData .DelAll(); 
			      System.out.println(Customer6); 
			      
				break;
				
			case 7:
				
				System.out.println("=================================");
				System.out.println("    Quit-ProductCategory         ");
				System.out.println("=================================");
				
				break;
			}
		}
	}
}