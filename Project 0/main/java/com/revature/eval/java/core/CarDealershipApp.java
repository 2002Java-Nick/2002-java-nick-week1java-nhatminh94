
package com.revature.eval.java.core;
import java.util.Scanner;

import javax.crypto.spec.DESedeKeySpec;

public class CarDealershipApp {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		Profiles a = new Profiles(null, null, null, 0);
		
		CarLot n = new CarLot(null, 0, 0);
		
		while ( 1 != 0) {
			System.out.println("\nChoose from the options below: \n1.Create Account\n2.Login"
					+ "\n3.Quit Program");
			int option = scan.nextInt();
			if(option == 1) {
				a.CreateAccount();
			} else if (option == 2) {
				if (a.Login()) {
					while(1 != 0) {
						System.out.println("\nPlease choose an option below:\n"
								+ "\n1.View cars availabe\n2.Make an offer\n3.View your garage\n4.Quit the program");
						int option2 = scan.nextInt();
						if(option2 == 1) {
							n.DeserializeCar();
							} else if (option2 == 2) {
								n.MakeOffer();
							} else if (option2 == 4) {
								System.exit(0);
							} else if (option2 == 3) {
					
					}
					
				}
				}else {
					System.out.println("\nLogin Failed! Try to log in again");
				}
			} else if (option == 3)
				System.exit(0);
			}
		

	}
}