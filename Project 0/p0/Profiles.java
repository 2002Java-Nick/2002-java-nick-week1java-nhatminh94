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


public class Profiles implements Serializable {
	
	private static String url = "jdbc:postgresql://localhost:5432/postgres";
	private static String username1 = "postgres";
	private static String password1 = "Vietnam94!";

	
	private static final Logger log = Logger.getLogger(Profiles.class);
	
	CarLot cn = new CarLot();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	private String carName;
	private int payment;
	

	
	private String loginUser;
	private String loginPass;
	
	CarLot a = new CarLot();
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getPayment() {
		return payment;
	}

	public void setPayment(int payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "\nProfiles [username = " + username + ", password = " + password
				+ ", car = " + carName + ", monthly payment  = $"
				+ payment + "]";
	}
	
	Profiles(){
		
	}

	Profiles(String username, String password, String carName, int payment){
		this.username = username;
		this.password = password;
		this.carName = carName;
		this.payment = payment;
		
	}
	
	
	public Profiles(String string, int int1, int int2, String string2) {
		// TODO Auto-generated constructor stub
	}


	ArrayList<Profiles> profs = new ArrayList<Profiles>(); //List of profiles
	
	Profiles[] myprof = new Profiles[4]; //Fields of a profile

	public void CreateAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Create an username");
		setUsername(scan.nextLine());
		System.out.println("Create a password");
		setPassword(scan.nextLine());
		System.out.println("\nAccount succesfully created!");
		
		profs.add(new Profiles(username, password, carName, payment));
		SerializeAccount();
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Could not load Postgresql Driver");
			e1.printStackTrace();
		}
		
		
		try(Connection conn = DriverManager.getConnection(url, username1, password1)){
			PreparedStatement ps = conn.prepareStatement("INSERT INTO profiles VALUES(?,?,?,?)");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setString(3, carName);
			ps.setInt(4, 0);
			
			
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		log.info("New account has been created");
	}
	
	
	
	
	
	
	public void SerializeAccount() {
		  try
	        {
	            FileOutputStream fos = new FileOutputStream("UserProfiles.txt");
	            ObjectOutputStream oos = new ObjectOutputStream(fos);
	            oos.writeObject(profs);
	            oos.close();
	            fos.close();
	            
	            
	        } catch (IOException ioe) 
	        {
	        	ioe.printStackTrace();
	        } finally {
	        	log.info("Serialization passed...information has been saved");
	        	System.out.println("Accounts info has been saved!");
	        }
	
	        }
	 

		
	
	public boolean Login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your username?");
		String loginUser = scan.nextLine();
		System.out.println("What is your password?");
		String loginPass = scan.nextLine();
		log.info("Username and password passed into the system");
		
		try
        {
            FileInputStream fis = new FileInputStream("UserProfiles.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            profs = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return false;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return false;
        }
		
		if(profs.toString().contains(loginUser) && profs.toString().contains(loginPass)){
			System.out.println("\nLogged in as " + loginUser + "!");
			log.info("Account credentials succesfully verified...Logging in");
			return true;
		} else if(loginUser.equals("employee") && loginPass.equals("password")) {
			log.info("Employee credentials succesfully verified..Logging in as an employee");
			a.employeeOptions();
		} else {
			return false;
		}
		return false;
	}
	
	
	public List<Profiles> selectAllProfiles() {
		
		log.info("Returning customer database");
		
		List<Profiles> profs = new ArrayList<Profiles>();		
		try(Connection conn = DriverManager.getConnection(url, username1, password1)){
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM profiles");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			profs.add(new Profiles(rs.getString(1), rs.getString(2), rs.getString(3)
					, rs.getInt(4)));
		}		}catch(SQLException e) {
		e.printStackTrace();
	}		return profs;	}
	
	
	
	public void makeOffer() {
		Scanner scanz = new Scanner(System.in);
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			System.out.println("Could not load Postgresql Driver");
			e1.printStackTrace();
		}
		
		
		
		System.out.println("\nVerify your username to start offer process");
		String verify = scanz.nextLine();
		System.out.println(cn.selectAllCars());
		System.out.println("\nWhich car do you want to make an offer for?");
		String whichcar = scanz.nextLine();
		System.out.println("\nHow much is your offer? ");
		int offer = scanz.nextInt();

		
		
		
		try(Connection conn = DriverManager.getConnection(url, username1, password1)){
			
			PreparedStatement ps = conn.prepareStatement("UPDATE car_lot SET offer_made = ?, customer = ? WHERE car = ?");
			ps.setInt(1, offer );
			ps.setString(2, verify);
			ps.setString(3, whichcar);
			
			ps.execute();
			System.out.println("\nOffer sent to dealership!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	

}


