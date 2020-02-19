package com.revature.eval.java.core;

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

public class Profiles implements Serializable {
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
		return "Profiles [username=" + username + ", password=" + password + ", carName=" + carName + ", payment="
				+ payment + "]";
	}

	Profiles(String username, String password, String carName, int payment){
		this.username = username;
		this.password = password;
		this.carName = carName;
		this.payment = payment;
		
	}
	
	
	ArrayList<Profiles> profs = new ArrayList<Profiles>(); //List of profiles
	
	Profiles[] myprof = new Profiles[4]; //Fields of a profile

	public void CreateAccount() {
		Scanner scan = new Scanner(System.in);

		System.out.println("Create an username");
		setUsername(scan.nextLine());
		System.out.println("Create a password");
		setPassword(scan.nextLine());
		System.out.println("Account succesfully created!");
		
		profs.add(new Profiles(username, password, carName, payment));
		SerializeAccount();
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
	        	System.out.println("Accounts info has been saved!");
	        }
	
	        }
	 

		
	
	public boolean Login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What is your username?");
		String loginUser = scan.nextLine();
		System.out.println("What is your password?");
		String loginPass = scan.nextLine();
		
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
			return true;
		} else if(loginUser.equals("employee") && loginPass.equals("password")) {
			a.employeeOptions();
		} else {
			return false;
		}
		return false;
	}
}




