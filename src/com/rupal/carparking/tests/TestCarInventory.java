package com.rupal.carparking.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.inventory.CarInventory;
import com.rupal.carparking.slot.CarSlot;

public class TestCarInventory {
		
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
	public void testCarInventoryGetSlotNumber() throws ParkingException{
		CarInventory ci = dataProvider.getTestCarInventory();
			assertEquals("Get Slot for car1",1,ci.getSlotNumber(dataProvider.getRegistrationNumer1()));
			assertEquals("GEt slot for car which does not exists", -1,ci.getSlotNumber(dataProvider.getRegistrationNumber2()));
	}
	
	@Test
	public void testCarInventoryAddNewEntry() throws ParkingException{
		CarInventory ci = dataProvider.getTestCarInventory();
		ci.updateCarInventory(dataProvider.getRegistrationNumber3(), dataProvider.getThirdFilledCarSlotToAdd());
		assertNotNull(ci.getSlotNumber(dataProvider.getRegistrationNumber3()));
		ci.removeFromCarInventory(dataProvider.getRegistrationNumber3());
	}
	
	@Test(expected=ParkingException.class)
	public void testCarInventoryAddNewEntryException()throws ParkingException{
		CarInventory ci = dataProvider.getTestCarInventory();
		ci.updateCarInventory(dataProvider.getRegistrationNumer1(), dataProvider.getThirdFilledCarSlotToAdd());
	}
	
	
}
