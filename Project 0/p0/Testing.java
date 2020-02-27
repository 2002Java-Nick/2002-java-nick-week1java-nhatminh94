package com.revature.eval.java.core;


import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Testing {
	
	Profiles profile = new Profiles();
	CarLot carlot = new CarLot();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void AddCarTest() {
		String carName = "Honda";
		int askingPrice = 15000;
		carlot.AddCarTester(carName,askingPrice);
		assertTrue(carlot.cars.toString().contains("Honda") &&
				carlot.cars.toString().contains("15000"));
	}
	
	@Test
	public void SerialCarTest() {
		carlot.SerializeCar();
		assertFalse("CarLot.txt".isEmpty());
	}
	
	@Test
	public void SerialTest() {
		profile.SerializeAccount();
		assertFalse("UserProfiles.txt".isEmpty());
	}

	
	@Test 
	public void GarageTest() {
		carlot.FillGarage();
		assertTrue(carlot.cars.isEmpty());
	}
	
	@Test
	public void RemoveCarTest() {
		String carName = "Honda";
		int askingPrice = 15000;
		carlot.AddCarTester(carName,askingPrice);
		int first = carlot.cars.size();
		carlot.RemoveCarTester(0);
		int second = carlot.cars.size();
		assertTrue(first > second);
	}
	
	@Test
	public void SaveCarTest() {
		carlot.SaveYourCar();
		assertFalse("YourCar.txt".isEmpty());
	}
	

	
	
	
	
	

	}

