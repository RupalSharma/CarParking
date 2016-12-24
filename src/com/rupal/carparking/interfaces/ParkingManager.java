package com.rupal.carparking.interfaces;

import com.rupal.carparking.exceptions.ParkingException;

public interface ParkingManager {
	
	/**
	 * this function is called when a vehicle is entered in parking area
	 * @param vehical
	 * @throws ParkingException 
	 */
	public String vehicalEntry(Vehicle vehical) throws ParkingException;
	/**
	 * this function is called when a car parked in slotNumber exits
	 * @param slotNumber
	 * @throws ParkingException 
	 */
	public String vehicalExit(int slotNumber) throws ParkingException;
	
	/**
	 * returns slot number of the car with registration number as provided
	 * @param registrationNumber
	 * @return
	 * @throws ParkingException 
	 */
	public int getParkedSlotNumber(String registrationNumber) throws ParkingException;
	
	/**
	 * prints status of current parking slot
	 * @return 
	 */
	public String status();
	
	
}
