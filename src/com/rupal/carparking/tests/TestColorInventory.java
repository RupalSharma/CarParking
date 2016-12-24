package com.rupal.carparking.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.inventory.ColorInventory;

public class TestColorInventory {

	CarParkingDataProvider dataProvider;
	ColorInventory ci;

	@Before
	public void init(){
		dataProvider = new CarParkingDataProvider();
		ci=dataProvider.getTestColorInventory();
	}
	
	@After
	public void exit(){
		ci=null;
		dataProvider = null;
	}
	
	@Test
	public void testGetDataFromColorInventory() throws ParkingException{
		assertNotNull(ci.getRegitrationNumberList(dataProvider.getWhite()));
		assertNotNull(ci.getSlotList(dataProvider.getWhite()));
		assertEquals("Registration Number should be equal", dataProvider.getRegistrationNumer1(), 
					ci.getRegitrationNumberList(dataProvider.getWhite()));
		assertEquals("Registration Number should be equal", "1", 
				ci.getSlotList(dataProvider.getWhite()));
		
		
	}
	
	@Test(expected=ParkingException.class)
	public void testGetDataFromColorInventoryException() throws ParkingException{
		ci.getRegitrationNumberList(dataProvider.getRed());
		ci.getSlotList(dataProvider.getRed());
	}
	
	@Test
	public void testAddNewDataIntoColorInventory() throws ParkingException{
		ci.addNewSlotToColorInventory(dataProvider.getWhite(), dataProvider.getThirdCarSlotWithColorWhite());
		assertTrue(ci.getSlotList(dataProvider.getWhite()).contains("1") && 
				ci.getSlotList(dataProvider.getWhite()).contains("3"));
		assertTrue(ci.getSlotList(dataProvider.getWhite()).contains("1") && 
				ci.getSlotList(dataProvider.getWhite()).contains("3"));
		assertTrue(ci.getRegitrationNumberList(dataProvider.getWhite()).contains(dataProvider.getRegistrationNumer1()) && 
				ci.getRegitrationNumberList(dataProvider.getWhite()).contains(dataProvider.getRegistrationNumber2()));
		
	}
	
	@Test(expected=ParkingException.class)
	public void testRemoveDataFromColorInventory() throws ParkingException{
		ci.removeSlotFromColorInventory(dataProvider.getRed(), dataProvider.getThirdFilledCarSlotToAdd());
		ci.removeSlotFromColorInventory(dataProvider.getWhite(), dataProvider.getSecondCarSlotFilledWithBlackCar4());
		ci.removeSlotFromColorInventory(dataProvider.getBlack(), dataProvider.getSecondCarSlotFilledWithBlackCar4());
		assertTrue(ci.getSlotList(dataProvider.getBlack()).isEmpty());
	}
}
