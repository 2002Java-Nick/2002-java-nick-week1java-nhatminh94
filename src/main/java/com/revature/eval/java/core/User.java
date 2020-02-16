package com.revature.eval.java.core;

import java.awt.Choice;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User {
	
	Map<String,String> accounts = new HashMap<String, String>();

	
	private String username;
	private String password;
	private String newName;
	private String newPassword;
	private Formatter x;

	
	Scanner scan = new Scanner(System.in);
	

	public void CreateAccount() {
		System.out.println("Choose an username: ");
		newName = scan.nextLine();
		System.out.println("Choose a password: ");
		newPassword = scan.nextLine();
		
		accounts.put(newName, newPassword);
		System.out.println("\nNew account has been created!\n");
		
	}
		
	
	public void Login() {
	
		
		System.out.println("Enter your user name: ");
		username = scan.nextLine();
		
		if(username.equals("employee")) {
			System.out.println("\nYou are attempting to login as an employee. What is the password?");
			password = scan.nextLine();
			if(password.contentEquals("password")) {
				Employee();
			} else {
				System.out.println("\nWrong password! Return to main menu.\n");
			}
		}
		
		if (accounts.containsKey(username)) {
			System.out.println("Enter your password: ");
			password = scan.nextLine();
			if(accounts.get(username).equals(password)) {
				Customer();
			} else {
				System.out.println("\nWrong password! Return to main menu.\n");
			}
		} 
	}

	public void Customer() {
		System.out.println("\nYou are logged in as a customer!\n");
		
	}
	
	
	public void Employee(){
		System.out.println("\nYou are logged in as an employee!");
		System.out.println("What would you like to do?\n" + 
		"\n1. Add car to the lot\n2. Remove a car from the lot\n3. View offers for cars\n4. View all payments\n");
		int choice = scan.nextInt();
		if (choice == 1) {
			AddCar();
		}
					
		
		
	}
	
	public void AddCar() {

		try {
			x = new Formatter("Car_Lot.txt");
		}catch(Exception e) {
			System.out.println("You have an error!");
		}
		
		while(1 != 0) {
			String carInfo;
			System.out.println("Please enter the car to be added to the lot or press 0 to quit");
			carInfo = scan.nextLine();
			
			if (carInfo.equals("0")) {
				System.out.println("Goodbye!");
				x.close();;
				System.exit(0);

			} else {
				x.format("%s", carInfo);
			}
		}
}
}

			






























