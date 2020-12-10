package com.uog.store;
import java.util.List;
import java.util.Scanner;
import com.uog.product.ProductData;
import com.uog.stock.StockData;
import com.uog.store.Store;
import com.uog.store.StoreData;
public class StoreMenu 
{
	@SuppressWarnings({ "static-access", "resource" })
	public static void StoreMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                  Stores Menu                         ");
			System.out.println("=====================================================");
			System.out.println("1.   Show All Stores Data");
			System.out.println("2.   Search Stores By Store-ID");
			System.out.println("3.   Search Stores By Stock-ID");
			System.out.println("4.   Search Stores By Product-ID");
			System.out.println("5.   Search Stores By Store-Name");
			System.out.println("6.   Delete Store By Store-ID");
			System.out.println("7.   Delete All Stores Data");
			System.out.println("8.  Insert Store Row");
			System.out.println("9.  Quit Store");
			System.out.print("Enter Your Choice [1-9]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("       Show All Stores Data       ");
				System.out.println("---------------------------------");
				List<Store> Store1 = StoreData.FindAll();
				for (int i=0; i<Store1.size(); i++) 
				    {    System.out.println(Store1.get(i).toString());    }
			    System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("       Search Store By Store-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Store-ID: ");
				StoreData Storedata2 = new StoreData();
				Scanner search=new Scanner(System.in);
				int x=search.nextInt();
				 Store Store2 = Storedata2.FindOne(x);
				 System.out.println(Store2.toString());
				 System.out.println("-------------------------------");
				break;
			case 3:
				System.out.println("---------------------------------");
				System.out.println("       Search Store By Stock-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Stock-ID: ");
				StoreData Storedata3 = new StoreData();
				Scanner search1=new Scanner(System.in);
				int x1=search1.nextInt();
				 Store Store3 = Storedata3.Search1(x1);
				 System.out.println(Store3.toString());
				 System.out.println("-------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("       Search Store By Product-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Product-ID: ");
				StoreData Storedata4 = new StoreData();
				Scanner search2=new Scanner(System.in);
				int x2=search2.nextInt();
				 Store Store4 = Storedata4.Search2(x2);
				 System.out.println(Store4.toString());
				 System.out.println("-------------------------------");
				break;
			case 5:
				System.out.println("------------------------------------------");
				System.out.println("        Search Stores By Store-Name      ");
				System.out.println("------------------------------------------");
				System.out.print("Enter Store-Name: ");
				Scanner search3=new Scanner(System.in);
				String x3=search3.nextLine();
				StoreData storedata5 = new StoreData();
				List<Store> store5 = storedata5.FindAll();
				store5= storedata5.Search3(x3);
				for (int i=0; i<store5.size(); i++)	
				    {    System.out.println(store5.get(i).toString());    }
				System.out.println("---------------------------------");
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("      Delete Store By Store-ID          ");
				System.out.println("---------------------------------");
				System.out.print("Enter Store-ID: ");
				int delete = scan.nextInt();
				Store Store7 = StoreData.DelOne(delete);
				System.out.println(Store7.toString());
				System.out.println("---------------------------------");
				break;
			case 7:
				System.out.println("---------------------------------");
				System.out.println("      Delete All Stores           ");
				System.out.println("---------------------------------");
				String Store8 = StoreData.DelAll(); 
			      System.out.println(Store8); 
				break;
			case 8:
			    System.out.println("---------------------------------");
				System.out.println("        Insert Store Row          ");
				System.out.println("---------------------------------");
				Store store10 = new Store();
				System.out.print("Enter Stock-ID: ");
				int stock_id = scan.nextInt();
				stock_id+=scan.nextInt();
				store10.setSTOCK_ID(StockData.Search(stock_id));
				System.out.print("Enter Product-ID: ");
				int product_id = scan.nextInt();
				store10.setPRODUCT_ID(ProductData.FindOne(product_id));
				System.out.print("Enter Store Name: ");
				String store_name = scan.nextLine();
				store10.setSTORE_NAME(store_name);
				System.out.print("Enter Store Type: ");
				String store_type = scan.nextLine();
				store10.setSTORE_TYPE(store_type);
				System.out.print("Enter Store Desc: ");
				String desc = scan.nextLine();
				store10.setSTORE_DESC(desc);
				System.out.print("Enter Store Address: ");
				String address = scan.nextLine();
				store10.setADDRESS(address);
				store10 = StoreData.Save(store10);
				System.out.println(store10.toString());
				System.out.println("---------------------------------");
				break;
			case 9:
				System.out.println("---------------------------------");
				System.out.println("      Exit Stores           ");
				System.out.println("---------------------------------");
				break;
			}
		}
	}	
}