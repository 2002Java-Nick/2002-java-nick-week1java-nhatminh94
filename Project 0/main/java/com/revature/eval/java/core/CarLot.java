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

public class CarLot implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String toString() {
		return "\ncarName=" + carName + ", payment per month until paid off= "
				+ "$" + payment + ", offer= $" + offer;
	}
	
	public String toString2() {
		return "\ncarName=" + carName;
	}

	private String carName;
	private int payment;
	private int offer;

	
	
	CarLot(){
		
	};
	
	CarLot(String carName, int offer, int payment){
		this.carName = carName;
		this.payment = payment;
		this.offer = offer;
		
	}
	
	public void employeeOptions() {
		Scanner scan = new Scanner(System.in);
		while(1!= 0) {
			System.out.println("\nYou are logged in as an employee! There are your options:\n"
					+ "\n1.Add cars to the lot\n2.Remove cars from the lot\n3.View customers offers\n4.View the car lot\n5.Quit program");
			int option = scan.nextInt();
			if(option == 1) {
				AddCar();
			} else if ( option == 2){
				RemoveCar();
			} else if (option == 5) {
				System.exit(0);
			} else if (option == 3) {
				ViewOffers();
				
			} else if (option == 4) {
				DeserializeCar();
			}
		}
	}
	ArrayList<CarLot> cars = new ArrayList<CarLot>();
	CarLot[] myCars = new CarLot[3];
	
	ArrayList<CarLot> cars2 = new ArrayList<CarLot>();
	CarLot[] myCars2 = new CarLot[3];
	
	
	public void AddCar() {
		Scanner scan = new Scanner(System.in);
		System.out.println("What kind of car?");
		String carName = scan.nextLine();
		cars.add(new CarLot(carName, 0, 0));
		SerializeCar();
}
	
	public void RemoveCar(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Which car to remove? Choose car based on position in lot (Starting with 0)");
		DeserializeCar();
		int choices = scan.nextInt();
		cars.remove(choices);
		System.out.println("Removed from the lot!");
		SerializeCar();
	}
	
	
	public void SerializeCar() {
		try
        {
            FileOutputStream fos = new FileOutputStream("CarLot.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cars);
            oos.close();
            fos.close();
            
            
        } catch (IOException ioe) 
        {
        	ioe.printStackTrace();
        } finally {
        	System.out.println("Cars in lot info has been updated!");
        }
	  
	  
         
        //Verify list data
        System.out.println(cars.toString());
        }
	
	public void SaveYourCar() {
		try
        {
            FileOutputStream fos = new FileOutputStream("YourCar.txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(cars2);
            oos.close();
            fos.close();
            
            
        } catch (IOException ioe) 
        {
        	ioe.printStackTrace();
        } finally {
        	System.out.println("Offer saved and sent to dealership! Good luck!\n");
        }
	}
	 

	
	public void DeserializeCar() {
		
		try
        {
            FileInputStream fis = new FileInputStream("CarLot.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            cars = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        } finally {
        	System.out.println(cars.toString());
        }
	}
	

	
	
	public void MakeOffer() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Which car?");
		String carName = scan.nextLine();
		System.out.println("What is your offer price?");
		int offer = scan.nextInt();
		System.out.println("How many years do you want your payment plan to last?");
		int interest = ((scan.nextInt())*12);
		int payment = offer / (interest);
		System.out.println("\nOffer made for " + carName + " with $" + offer);
		System.out.println("The payment plan is $" + payment + " per month for " + interest + " months. ");
		
		cars2.add(new CarLot(carName,offer,payment));
		SaveYourCar();
		
	}

	

	
	public boolean ViewOffers() {
		Scanner scan = new Scanner(System.in);
		try
        {
            FileInputStream fis = new FileInputStream("YourCar.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            cars = (ArrayList) ois.readObject();
 
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
        } finally {
        	System.out.println(cars.toString());
        }
		
		System.out.println("Do you accept or deny the offers?");
		String aord = scan.nextLine();
		if (aord.equals("accept")) {
			System.out.println("\nOffers accepted....sending answer to customer!");
			return true;
		} else {
			System.out.println("\nOffers denied....sending answer to customer!");
			return false;
		}
		
	}
	
	
	public void FillGarage() {
		Scanner scan = new Scanner(System.in);
		try
        {
            FileInputStream fis = new FileInputStream("YourCar.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
 
            cars = (ArrayList) ois.readObject();
 
            ois.close();
            fis.close();
        } 
        catch (IOException ioe) 
        {
            ioe.printStackTrace();
            return;
        } 
        catch (ClassNotFoundException c) 
        {
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        } finally {
        	System.out.println(cars.toString());
        }
	}
	
}
	
	
	
	
