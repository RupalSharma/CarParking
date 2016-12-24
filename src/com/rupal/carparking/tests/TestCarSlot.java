package com.rupal.carparking.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.rupal.carparking.slot.CarSlot;

public class TestCarSlot {

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
	public void testEmptyCarSlot(){
		CarSlot cs = dataProvider.getFirstEmptyCarSlot();
		assertTrue(cs.isEmpty());
		cs.fillSlot(dataProvider.getWhiteCar1());
		assertFalse(cs.isEmpty());
	}
	
	@Test
	public void testComapatorCarSlot(){
		CarSlot cs1 = dataProvider.getFirstEmptyCarSlot();
		CarSlot cs2 = dataProvider.getSecondEmptyCarSlot();
		assertEquals("1st slot comes first than second ", -1, cs1.compareTo(cs2));
		assertEquals("Both objects are equal ",0, cs1.compareTo(cs1));
	}
}
