package com.revature.p0;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarLot implements Serializable{
	
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String username = "postgres";
	private static String password = "Vietnam94!";


	
	private static final Logger log = Logger.getLogger(CarLot.class);
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "\nCar = " + carName + ", Dealer_price = $" + offer 
				+ ", Offer_made = $" + payment + ", Customer = " + user;
	}
	
	private String carName;
	private int payment;
	private int offer;
	private String user;

	
	
	CarLot(){
		
	};
	
	CarLot(String carName, int offer, int payment, String user){
		this.carName = carName;
		this.payment = payment;
		this.offer = offer;
		this.user = user;
	}
	
	public void employeeOptions() {
		Scanner scan = new Scanner(System.in);
		while(1!= 0) {
			System.out.println("\nYou are logged in as an employee! These are your options:\n"
					+ "\n1.Add cars to the lot\n2.Remove cars from the lot\n3.View customers"
					+ " offers\n4.View the car lot\n5.Quit program");
			int option = scan.nextInt();
			if(option == 1) {
				AddCar();
			} else if ( option == 2){
				RemoveCar();
			} else if (option == 5) {
				log.info("Programing shutting down");
				System.exit(0);
			} else if (option == 3) {
				System.out.println(viewOffer());
				chooseOffer();
				
			} else if (option == 4) {
				System.out.println(selectAllCars());
			}
		}
	}
	ArrayList<CarLot> cars = new ArrayList<CarLot>();
	CarLot[] myCars = new CarLot[4];
	
	ArrayList<CarLot> cars2 = new ArrayList<CarLot>();
	CarLot[] myCars2 = new CarLot[4];
	
	
	public List<CarLot> viewOffer() {
		
		List<CarLot> cars = new ArrayList<CarLot>();		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM car_lot WHERE offer_made != 0");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			cars.add(new CarLot(rs.getString(1), rs.getInt(2), rs.getInt(3)
					, rs.getString(4)));
		}		}catch(SQLException e) {
		e.printStackTrace();
	}		return cars;	
			
	}
	
	
	public void chooseOffer() {
		log.info("Opening up customer's offers");
		Scanner scan = new Scanner(System.in);
		System.out.println("\nWhich customer's offer do you want to look at? ");
		String customer = scan.nextLine();
		
		List<CarLot> cars2 = new ArrayList<CarLot>();		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
		PreparedStatement ps = conn.prepareStatement("SELECT * "
				+ "FROM car_lot WHERE customer = ?");
		
		ps.setString(1, customer);
		ps.execute();
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			cars2.add(new CarLot(rs.getString(1), rs.getInt(2), rs.getInt(3)
					, rs.getString(4)));
		}		}catch(SQLException e) {
		e.printStackTrace();
		}
		
		System.out.println(cars2);
		
		System.out.println("\nDo you accept or deny " + customer + "'s offer?");
		String answer = scan.nextLine();
		
		if (answer .equals("accept")) {
			System.out.println("\nRe-verify car for offer");
			String carchoice = scan.nextLine();
			System.out.println("\nOffer price to calculate payment per month");
			int payment = scan.nextInt();
			int monthlypay = payment/60;
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				
				PreparedStatement ps = conn.prepareStatement
						("UPDATE profiles SET car = ?, payment_per_month = ?  WHERE name = ?");
				ps.setString(1, carchoice );
				ps.setInt(2, monthlypay);
				ps.setString(3, customer);
				
				ps.execute();
				
				PreparedStatement os = conn.prepareStatement
						("DELETE from car_lot where car = ?");
				os.setString(1, carchoice);
				os.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("\n Offer accepted. " + carchoice + " sold for a price"
					+ "of $" + payment + " with a monthly payment of $" + monthlypay +
					" per month for 5 years!");
			
		} else {
			System.out.println("\nOffer denied. Re-verify car to put back on lot");
			String denyCar = scan.nextLine();
			try(Connection conn = DriverManager.getConnection(url, username, password)){
				
				PreparedStatement zz = conn.prepareStatement
						("UPDATE car_lot SET offer_made = ?, customer = ? "
								+ "WHERE car = ?");
				zz.setInt(1, 0);
				zz.setString(2, null);
				zz.setString(3, denyCar);
				
				zz.execute();
				
				System.out.println("\nCustomer offer denied...Putting " + denyCar + " back on lot!");
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		
	}
	
	
	public void AddCar() {
		log.info("Added car to carlolt");
		Scanner scan = new Scanner(System.in);
		System.out.println("What kind of car?");
		String carName = scan.nextLine();
		System.out.println("What is the dealer's price?");
		int askingPrice = scan.nextInt();		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Could not load Postgresql Driver");
			e1.printStackTrace();
		}
		
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("call insert_car(?,?,?,?)");
			ps.setString(1, carName );
			ps.setInt(2, askingPrice);
			ps.setInt(3, 0);
			ps.setString(4, null);
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\nCar_lot info has been updated!");

}
	
	

	
	public void RemoveCar(){
		log.info("Removed car from lot");
		Scanner scan = new Scanner(System.in);
		System.out.println(selectAllCars());
		System.out.println("Which car to remove?");
		String choice = scan.nextLine();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Could not load Postgresql Driver");
			e1.printStackTrace();
		}
		
		try(Connection conn = DriverManager.getConnection(url, username, password)){
			
			PreparedStatement ps = conn.prepareStatement
					("call delete_car(?)");
			ps.setString(1, choice);
			ps.executeUpdate();
			System.out.println("\n" + choice + " has been removed from the car lot!");
			
			
		}catch(SQLException e) {
			e.printStackTrace();

	}


	}

	
	
	public List<CarLot> selectAllCars() {
		
			List<CarLot> cars = new ArrayList<CarLot>();		
			try(Connection conn = DriverManager.getConnection(url, username, password)){
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM car_lot WHERE offer_made = 0");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cars.add(new CarLot(rs.getString(1), rs.getInt(2), rs.getInt(3)
						, rs.getString(4)));
			}		}catch(SQLException e) {
			e.printStackTrace();
		}		return cars;	}
	
	
	


	
}
	
	
	
	