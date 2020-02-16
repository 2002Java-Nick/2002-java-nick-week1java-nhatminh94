package com.revature.eval.java.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarDealershipApp {
	public static void main(String[] args) {
		
		
		
		
		User newUser = new User();
		
		do {
			System.out.println("Pick an option:\n1. Create Account\n2. Login\n3. Quit the program");
			Scanner scan2 = new Scanner(System.in);
			int option = scan2.nextInt();
			
			if (option == 1) {
				newUser.CreateAccount();
			} else if (option == 2) {
				newUser.Login();
			} else { break; }
		} while (1 != 0);
		
		
		
	}
}

