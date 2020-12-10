package com.uog.product;
import java.util.List;
import java.util.Scanner;
public interface ProductMenu 
{
		@SuppressWarnings({ "static-access", "resource" })
		public static void ProductMenu() 
		{
			Scanner scan = new Scanner(System.in);
			int choice=-1;
			choice = -1;
			while (choice!=10) 
			{
				System.out.println("=====================================================");
				System.out.println("                WELCOME to  Product Menu             ");
				System.out.println("=====================================================");
				System.out.println("1.  SHOW All PRODUCTS DATA");
				System.out.println("2.  INSERT PRODUCTS ROW");
				System.out.println("3.  SEARCH PRODUCTS By PRODUCT-ID");
				System.out.println("5.  DELETE PRODUCTS By PRODUCTS-ID");
				System.out.println("6.  DELETE All PRODUCTS Data");
				System.out.println("7.  QUIT PRODUCTS");
				System.out.print("Enter Your Choice [1-7]: ");
				choice = scan.nextInt();
				switch (choice) 
				{
				  case 1:
					System.out.println("=================================");
					System.out.println("       Show All PRODUCTS DATA    ");
					System.out.println("=================================");
					List<Product> product = ProductData.FindAll();
					for (int i=0; i<product.size(); i++) {
					       System.out.println(product.get(i).toString());   }
				    System.out.println("=================================");
					break;
				 case 2:
					System.out.println("=================================");
					System.out.println("        Insert PRODUCTS ROW       ");
					System.out.println("=================================");
					Product Customer2 = new Product();
					System.out.print("Enter PRODUCT Name: ");
					String name = scan.nextLine();
					name += scan.nextLine();
					Customer2.setPRODUCT_NAME(name);
					System.out.print("Enter PRODUCT Price: ");
					int price= scan.nextInt();
					Customer2.setPRODUCT_PRICE(price);
					System.out.print("Enter PRODUCT CATEGORY ID: ");
					int pc_ID = scan.nextInt();
					Customer2.setPRODUCDCATEGORY_ID(ProductCategoryData.FindOne(pc_ID));
					System.out.print("Enter PRODUCT DESCRIPTION: ");
					String desc = scan.next();
					Customer2.setPRODUCT_DESC(desc);
					System.out.print("Enter PRODUCT Menufacture Date: ");
					String M_date = scan.next();
					Customer2.setMANUFACTURE_DATE(M_date);
					System.out.print("Enter PRODUCT Expiry Date: ");
					String E_date = scan.next();
					Customer2.setEXPIRY_DATE(E_date);
					Customer2 = ProductData.Save(Customer2);
					System.out.println(Customer2.toString());
					System.out.println("=================================");
					break;
				case 3:
					
					System.out.println("=================================");
					System.out.println("       Search By PRODUCT ID     ");
					System.out.println("=================================");
					System.out.print("Enter search: ");
					ProductData Customerdata3 = new ProductData ();
					Scanner search1 = new Scanner(System.in);
					int s1 = search1.nextInt();
					Product  Customer3 = Customerdata3.FindOne(s1);
					 System.out.println(Customer3.toString());
					 System.out.println("=================================");
					break;
				case 5:
					System.out.println("=================================");
					System.out.println("      Delete Product By ID          ");
					System.out.println("=================================");
					System.out.print("Enter Product ID: ");
					int delete = scan.nextInt();
					Product Customer5 = ProductData .DelOne(delete);
					System.out.println(Customer5.toString());
					System.out.println("=================================");
					break;
				case 6:
					
					System.out.println("=================================");
					System.out.println("      Delete All Product       ");
					System.out.println("=================================");
					String Customer6 = ProductData .DelAll(); 
				    System.out.println(Customer6); 
					break;
				case 7:
					
					System.out.println("=================================");
					System.out.println("          Quit-Product          ");
					System.out.println("=================================");
					break;
				}
			}
		}
}