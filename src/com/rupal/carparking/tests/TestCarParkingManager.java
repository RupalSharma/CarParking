package com.rupal.carparking.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.services.CarParkingManager;

public class TestCarParkingManager {
	CarParkingDataProvider dataProvider;
	CarParkingManager parkingManager;
	
	@Before
	public void init(){
		dataProvider = new CarParkingDataProvider();
		parkingManager = dataProvider.getParkingManagerInstance();
	}
	
	@After
	public void exit(){
		parkingManager = null;
		dataProvider = null;
	}
	
	@Test(expected=ParkingException.class)
	public void testGetCarSlotNumber() throws ParkingException{
		assertEquals("Car Slot should be same",3,parkingManager.getParkedSlotNumber(dataProvider.getRegistrationNumber3()));
		 parkingManager.getParkedSlotNumber("KA01KR98765");
	}
	
	@Test(expected=ParkingException.class)
	public void testVehicleExitThenEntry() throws ParkingException{
		parkingManager.vehicalExit(2);
		 parkingManager.getParkedSlotNumber(dataProvider.getRegistrationNumber2());
		parkingManager.vehicalEntry(dataProvider.getWhiteCar2());
		assertEquals("Result should not be same", 2, parkingManager.getParkedSlotNumber(dataProvider.getRegistrationNumber2()));
		
	}
	
	@Test
	public void testVehicleEntryThenExit() throws ParkingException{
		parkingManager.vehicalEntry(dataProvider.getBlackCar4());
		assertEquals("Vehical should enter the last index", 4, parkingManager.getParkedSlotNumber(dataProvider.getRegistrationNumber4()));
		parkingManager.vehicalExit(4);
	}
	
	@Test(expected=ParkingException.class)
	public void testVehicleEntryException() throws ParkingException{
		parkingManager.vehicalEntry(dataProvider.getBlackCar4());
		assertEquals("Vehical should enter the last index", 4, parkingManager.getParkedSlotNumber(dataProvider.getRegistrationNumber4()));
		parkingManager.vehicalEntry(dataProvider.getWhiteCar1());
	}
	
	
	

}
