package com.revature.p0;

import java.util.Scanner;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDealershipApp {
	
	private static final Logger log = Logger.getLogger(CarDealershipApp.class);
	
	public static void main(String[] args){
		
		log.info("The program has started running!");
	

		Scanner scan = new Scanner(System.in);
		
		
		Profiles a = new Profiles(null, null, null, 0);
		
		CarLot n = new CarLot(null, 0, 0, null);
		
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
								+ "\n1.View cars availabe\n2.Make "
								+ "an offer\n3.View payments\n4.Quit the program");
						int option2 = scan.nextInt();
						if(option2 == 1) {
							System.out.println(n.selectAllCars());
							} else if (option2 == 2) {
								a.makeOffer();
							} else if (option2 == 3) {
								System.out.println(a.selectAllProfiles());
							}
							
							else if (option2 == 4) {
								System.exit(0);
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