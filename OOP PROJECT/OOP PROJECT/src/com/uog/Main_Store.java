package com.uog;
import java.util.Scanner;
import com.uog.bill.BillMenu;
import com.uog.customer.CustomerMenu;
import com.uog.login.AdminMenu;
import com.uog.person.PersonMenu;
import com.uog.product.ProductCategoryMenu;
import com.uog.product.ProductMenu;
import com.uog.stock.StockMenu;
import com.uog.store.StoreMenu;

public class Main_Store 
{
	@SuppressWarnings("resource")
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		int choice=-1;
		choice=-1;
		while (choice!=10) 
		{
			MainMenu();
			choice = scan.nextInt();
			switch (choice) 
			{
			case 1:
				BillMenu.BillMenu();
				choice=-1;
				break;
			case 2:
				CustomerMenu.CustomerMenu();
				choice=-1;
				break;
			case 3:
				AdminMenu.AdminMenu();
				choice=-1;
				break;
			case 4:
				PersonMenu.PersonMenu();
				choice=-1;
				break;
			case 5:
				ProductMenu.ProductMenu();
				choice=-1;
				break;
			case 6:
				ProductCategoryMenu.ProductCategoryMenu();
				choice=-1;
				break;
			case 7:
				StockMenu.StockMenu();
				choice=-1;
				
				break;
			case 8:
				StoreMenu.StoreMenu();
				choice=-1;
				break;
		       }
			}
	}
	
	static void MainMenu() 
	{
		System.out.println("=====================================================");
		System.out.println("                   Main Menu");
		System.out.println("=====================================================");
		System.out.println("1.   Bills Data");
		System.out.println("2.   Customers Data");
		System.out.println("3.   Logins Data");
		System.out.println("4.   Persons Data");
		System.out.println("5.   Products Data");
		System.out.println("6.   ProductCategorys Data");
		System.out.println("7.   Stocks Data");
		System.out.println("8.   Stores Data");
		System.out.print("Enter Your Choice[1-8]: ");
	}
}