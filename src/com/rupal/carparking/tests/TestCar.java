package com.rupal.carparking.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rupal.carparking.car.Car;

public class TestCar {
	
	CarParkingDataProvider dataProvider;
	
	@Before
	public void init(){
		dataProvider = new CarParkingDataProvider();
	}
	
	@After
	public void exit(){
		dataProvider = null;
	}
	
	@Test
	public void testColor(){
		Car redCar = dataProvider.getRedCar3();
		assertEquals("Car Must be red",dataProvider.getRed(),redCar.getColour());
		assertNotEquals(dataProvider.getBlack(), redCar.getColour());
	}
	
	@Test
	public void testRegistrationNumber(){
		Car redCar = dataProvider.getRedCar3();
		assertEquals("Registration number should be same", dataProvider.getRegistrationNumber3(), redCar.getRegistrationNumber());
		assertNotEquals("Registration number should be same", dataProvider.getRegistrationNumer1(), redCar.getRegistrationNumber());
	}
	
	@Test
	public void testCarObject(){
		Car whiteCar1 = dataProvider.getWhiteCar1();
		Car whiteCar2 = dataProvider.getWhiteCar2();
		assertNotEquals("CArs are not same though the color is same", whiteCar1 ,whiteCar2);
		assertEquals("Cars are same if their registration is same", whiteCar1, new Car(dataProvider.getRegistrationNumer1(),dataProvider.getWhite()));
	}
}
