package com.uog.bill;
import java.util.List;
import java.util.Scanner;
import com.uog.product.ProductData;
import com.uog.stock.StockData;
import com.uog.store.StoreData;
import com.uog.bill.Bill;
import com.uog.bill.BillData;
import com.uog.customer.CustomerData;
public class BillMenu 
{
	@SuppressWarnings({ "static-access", "resource" })
	public static void BillMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                  Bills Menu                         ");
			System.out.println("=====================================================");
			System.out.println("1.   Show All Bills Data");
			System.out.println("2.   Search Bills By Bill-ID");
			System.out.println("3.   Search Bills By Bill-Name");
			System.out.println("4.   Search Bills By Store-ID");
			System.out.println("5.   Search Bills By Customer-ID");
			System.out.println("6.   Search Bills By Product-ID");
			System.out.println("7.   Delete Bill By Bill-ID");
			System.out.println("8.   Delete All Bills Data");
			System.out.println("9.   Insert Bill Row");
			System.out.println("10.  Quit Bill");
			System.out.print("Enter Your Choice [1-10]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("       Show All Bills Data       ");
				System.out.println("---------------------------------");
				List<Bill> Bill1 = BillData.FindAll();
				for (int i=0; i<Bill1.size(); i++) 
				    {    System.out.println(Bill1.get(i).toString());    }
			    System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("       Search Bill By Bill-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Bill-ID: ");
				BillData Billdata2 = new BillData();
				Scanner search=new Scanner(System.in);
				int x=search.nextInt();
				 Bill Bill2 = Billdata2.FindOne(x);
				 System.out.println(Bill2.toString());
				 System.out.println("-------------------------------");
				break;
			case 3:
				System.out.println("------------------------------------------");
				System.out.println("        Search Bills By Bill-Name      ");
				System.out.println("------------------------------------------");
				System.out.print("Enter Bill-Name: ");
				Scanner search3=new Scanner(System.in);
				String x3=search3.nextLine();
				BillData billdata5 = new BillData();
				List<Bill> bill5 = billdata5.FindAll();
				bill5= billdata5.Search3(x3);
				for (int i=0; i<bill5.size(); i++)	
				    {    System.out.println(bill5.get(i).toString());    }
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("       Search Bill By Store-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Store-ID: ");
				BillData Billdata3 = new BillData();
				Scanner search1=new Scanner(System.in);
				int x1=search1.nextInt();
				 Bill Bill3 = Billdata3.Search1(x1);
				 System.out.println(Bill3.toString());
				 System.out.println("-------------------------------");
				break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("       Search Bill By Customer-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Customer-ID: ");
				BillData Billdata4 = new BillData();
				Scanner search2=new Scanner(System.in);
				int x2=search2.nextInt();
				 Bill Bill4 = Billdata4.Search2(x2);
				 System.out.println(Bill4.toString());
				 System.out.println("-------------------------------");
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("       Search Bill By Product-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Product-ID: ");
				BillData Billdata12 = new BillData();
				Scanner search4=new Scanner(System.in);
				int x4=search4.nextInt();
				 Bill Bill12 = Billdata12.Search4(x4);
				 System.out.println(Bill12.toString());
				 System.out.println("-------------------------------");
				break;
			case 7:
				System.out.println("---------------------------------");
				System.out.println("      Delete Bill By Bill-ID          ");
				System.out.println("---------------------------------");
				System.out.print("Enter Bill-ID: ");
				int delete = scan.nextInt();
				Bill Bill7 = BillData.DelOne(delete);
				System.out.println(Bill7.toString());
				System.out.println("---------------------------------");
				break;
			case 8:
				System.out.println("---------------------------------");
				System.out.println("      Delete All Bills           ");
				System.out.println("---------------------------------");
				String Bill8 = BillData.DelAll(); 
			      System.out.println(Bill8); 
				break;
			case 9:
				System.out.println("+++++++++++++++++++++++++++++++++");
				System.out.println("Add New Bill");
				System.out.println("+++++++++++++++++++++++++++++++++");
				Bill bill = new Bill();		
				System.out.println("Enter Bill Name: ");
				String billname = scan.nextLine();
				billname+=scan.nextLine();
				bill.setBILL_NAME(billname);
				System.out.println("Enter Store ID: ");
				int StoreID = scan.nextInt();
				bill.setSTORE_ID(StoreData.FindOne(StoreID));
				System.out.println("Enter Customer ID: ");
				int customerID = scan.nextInt();
				bill.setCUSTOMER_ID(CustomerData.FindOne(customerID));
				System.out.println("Enter Product ID: ");
				int productID = scan.nextInt();
				bill.setPRODUCT_ID(ProductData.FindOne(productID));
				bill= BillData.Save(bill);
				System.out.println(bill.toString());
				System.out.println("---------------------------------\n");
				break;
			case 10:
				System.out.println("---------------------------------");
				System.out.println("      Exit Bills           ");
				System.out.println("---------------------------------");
				break;
			}
		}
	}	
}