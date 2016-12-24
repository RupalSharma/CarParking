package com.rupal.carparking.inventory;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.exceptions.CarParkingExceptionMessage;
import com.rupal.carparking.interfaces.Inventory;
import com.rupal.carparking.slot.CarSlot;
/**
 * This class  provides information from parking lot on base of color provided
 * It is an inventory for color based information of parking lot
 * @author Rupal
 *
 */
public class ColorInventory implements Inventory {

	private HashMap<String, LinkedList<CarSlot>> colorMap;

	public ColorInventory() {
		colorMap = new HashMap<>();
	}
	
/**
 * Provides list of slot numbers where specific coloured cars are parked
 * @param colour
 * @return
 * @throws ParkingException 
 */
	public String getSlotList(String colour) throws ParkingException {
		StringBuilder result = new StringBuilder();

		LinkedList<CarSlot> slots = colorMap.get(colour.toLowerCase());
		if (slots != null) {
			for (CarSlot slot : slots) {
				result.append(slot.getSerialNumber() + ", ");
			}
			result.setLength(result.length() - 2);
		}else{
			throw new ParkingException(404, CarParkingExceptionMessage.NO_COLOUR_FOUND.getExceptionMsg());
		}
		return result.toString();
	}

	/**
	 * Provides list of registration Number of specific colored cars parked in the parking lot
	 * @param colour
	 * @return
	 * @throws ParkingException 
	 */
	public String getRegitrationNumberList(String colour) throws ParkingException {
		StringBuilder result = new StringBuilder();
		LinkedList<CarSlot> slots = colorMap.get(colour.toLowerCase());
		if (slots != null) {
			for (CarSlot slot : slots) {
				result.append(slot.getCar().getRegistrationNumber() + ", ");
			}
			result.setLength(result.length() - 2);
		}else{
			throw new ParkingException(404, CarParkingExceptionMessage.NO_COLOUR_FOUND.getExceptionMsg());
		}
		return result.toString();
	}
	
	/**
	 * Adds new slot to the list for specific colored cars
	 * @param colour
	 * @param carslot
	 */
	@SuppressWarnings("unchecked")
	public void addNewSlotToColorInventory(String colour, CarSlot carslot) {
		LinkedList<CarSlot> slots = colorMap.get(colour.toLowerCase());
		if (slots != null) {
			slots.add(carslot);
			Collections.sort(slots);
		} else {
			slots = new LinkedList<CarSlot>();
			slots.add(carslot);
		}
		colorMap.put(colour.toLowerCase(), slots);
	}
	
	/**
	 * Whenver a car exits parking lot this function updates the color inventory and removes the that slot from the list of
	 * specific color, throws exception if user not able to find the slot/car
	 * @param colour
	 * @param carslot
	 * @throws ParkingException
	 */
	public void removeSlotFromColorInventory(String colour, CarSlot carslot) throws ParkingException {
		LinkedList<CarSlot> slots = colorMap.get(colour.toLowerCase());
		if (slots != null) {
			if(slots.contains(carslot))
				slots.remove(carslot);
			else
				throw new ParkingException(404,CarParkingExceptionMessage.NOT_FOUND.getExceptionMsg());
		} else {
			throw new ParkingException(404,CarParkingExceptionMessage.NOT_FOUND.getExceptionMsg());
		}
		colorMap.put(colour.toLowerCase(), slots);
	}
}
