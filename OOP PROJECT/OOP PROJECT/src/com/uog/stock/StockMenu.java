package com.uog.stock;
import java.util.List;
import java.util.Scanner;
public class StockMenu 
{
	@SuppressWarnings({ "static-access", "resource" })
	public static void StockMenu() 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice = -1;
		while (choice!=10) 
		{
			System.out.println("=====================================================");
			System.out.println("                  Stocks Menu                         ");
			System.out.println("=====================================================");
			System.out.println("1.   Show All Stocks Data");
			System.out.println("2.   Search Stocks By Stock-ID");
			System.out.println("3.   Search Stocks By Stock-Name");
			System.out.println("4.   Search Stocks By Stock-Number");
			System.out.println("5.   Delete Stock By Stock-ID");
			System.out.println("6.   Delete All Stocks Data");
			System.out.println("7.   Insert Stock Row");
			System.out.println("8.   Quit Stock");
			System.out.print("Enter Your Choice [1-8]: ");
			choice = scan.nextInt();
			switch (choice) 
			{
			case 1:
				System.out.println("---------------------------------");
				System.out.println("       Show All Stocks Data       ");
				System.out.println("---------------------------------");
				List<Stock> stock1 = StockData.FindAll();
				for (int i=0; i<stock1.size(); i++) 
				    {    System.out.println(stock1.get(i).toString());    }
			    System.out.println("---------------------------------");
				break;
			case 2:
				System.out.println("---------------------------------");
				System.out.println("       Search Stock By Stock-ID         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Stock-ID: ");
				StockData Stockdata2 = new StockData();
				Scanner search=new Scanner(System.in);
				int x=search.nextInt();
				 Stock Stock2 = Stockdata2.Search(x);
				 System.out.println(Stock2.toString());
				 System.out.println("-------------------------------");
				break;
			case 3:
				System.out.println("------------------------------------------");
				System.out.println("        Search Stocks By Stock-Name      ");
				System.out.println("------------------------------------------");
				System.out.print("Enter Stock-Name: ");
				Scanner search1=new Scanner(System.in);
				String x1=search1.nextLine();
				StockData stockdata3 = new StockData();
				List<Stock> stock3 = stockdata3.FindAll();
				stock3= stockdata3.Search1(x1);
				for (int i=0; i<stock3.size(); i++)	
				    {    System.out.println(stock3.get(i).toString());    }
				System.out.println("---------------------------------");
				break;
			case 4:
				System.out.println("---------------------------------");
				System.out.println("       Search Stock By Stock-Number         ");
				System.out.println("---------------------------------");
				System.out.print("Enter Stock-Number: ");
				Scanner search3=new Scanner(System.in);
				String x3=search3.nextLine();
				StockData stockdata5 = new StockData();
				List<Stock> stock5 = stockdata5.FindAll();
				stock5= stockdata5.Search3(x3);
				for (int i=0; i<stock5.size(); i++)	
				    {    System.out.println(stock5.get(i).toString());    }
				System.out.println("---------------------------------");
				break;
			case 5:
				System.out.println("---------------------------------");
				System.out.println("      Delete Stock By Stock-ID          ");
				System.out.println("---------------------------------");
				System.out.print("Enter Stock-ID: ");
				int delete = scan.nextInt();
				Stock Stock7 = StockData.DelOne(delete);
				System.out.println(Stock7.toString());
				System.out.println("---------------------------------");
				break;
			case 6:
				System.out.println("---------------------------------");
				System.out.println("      Delete All Stocks           ");
				System.out.println("---------------------------------");
				String Stock8 = StockData.DelAll(); 
			      System.out.println(Stock8); 
				break;
			case 7:
			    System.out.println("---------------------------------");
				System.out.println("        Insert Stock Row          ");
				System.out.println("---------------------------------");
				Stock stock10 = new Stock();
				System.out.print("Enter Stock Name: ");
				String stock_name = scan.nextLine();
				stock_name+=scan.nextLine();
				stock10.setSTOCK_NAME(stock_name);
				System.out.print("Enter Stock Type: ");
				String stock_type = scan.nextLine();
				stock10.setSTOCK_TYPE(stock_type);
				System.out.print("Enter Stock Number: ");
				String stock_no = scan.nextLine();
				stock10.setSTOCK_NUMBER(stock_no);
				System.out.print("Enter Stock Desc: ");
				String desc = scan.nextLine();
				desc+=scan.nextLine();
				stock10.setSTOCK_DESC(desc);
				System.out.print("Enter Stock Issue-Date: ");
				String date = scan.nextLine();
				stock10.setISSUE_DATE(date);
				stock10 = StockData.Save(stock10);
				System.out.println(stock10.toString());
				System.out.println("---------------------------------");
				break;
			case 8:
				System.out.println("---------------------------------");
				System.out.println("      Exit Stocks           ");
				System.out.println("---------------------------------");
				break;
			}
		}
	}	
}