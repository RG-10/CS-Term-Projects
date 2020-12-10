package com.atm.main;

import java.util.Scanner;

public class AtmApplicationClass {

	public static void main(String[] args) throws Exception {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Please enter -->1<-- for ADMIN or -->anyNumber<-- for USER");
		
		System.out.println("Please enter your choice!--> ");
		
		char u = scan.next().charAt(0);
		
		char s = '1';
		
		if(u == s) {
			
			System.out.println("[-------->WELLCOME--DEAR--ADMIN<--------] ");
			
			MenuATM.adminMenu();
			
		} else {
			
			System.out.println("[-------->WELCOME--DEAR--USER<--------] ");
			
			MenuATM.menu();
		}
		scan.close();

	}

}
