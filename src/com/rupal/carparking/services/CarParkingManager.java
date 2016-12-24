package com.rupal.carparking.services;

import java.util.Collections;
import java.util.LinkedList;

import com.rupal.carparking.car.Car;
import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.exceptions.CarParkingExceptionMessage;
import com.rupal.carparking.interfaces.ParkingManager;
import com.rupal.carparking.interfaces.Slot;
import com.rupal.carparking.interfaces.Vehicle;
import com.rupal.carparking.inventory.CarInventory;
import com.rupal.carparking.inventory.ColorInventory;
import com.rupal.carparking.slot.CarSlot;

/**
 * This is the main class to handle all requests coming into the system. It
 * manganges all slots, updates inventory with proper infor when a car exits or
 * enters. Provide status and information regarding the cars present in the
 * parking lot
 * 
 * @author Rupal
 *
 */
public class CarParkingManager implements ParkingManager {

	private Slot[] carParkingArray;
	private LinkedList<Integer> emptyList;
	private CarInventory carInventory;
	private ColorInventory colorInventory;

	public CarParkingManager() throws ParkingException {
		throw new ParkingException(400, CarParkingExceptionMessage.INSUFFICIENT_DATA_PARKING_SIZE.getExceptionMsg());
	}

	/**
	 * creates a car parking area with lotSize number of parking lots
	 * 
	 * @param lotSize
	 */
	public CarParkingManager(int lotSize) {
		carParkingArray = new CarSlot[lotSize];
		emptyList = new LinkedList<Integer>();
		for (int i = 0; i < lotSize; i++) {
			emptyList.add(i);
			carParkingArray[i] = new CarSlot(i + 1);
		}
		carInventory = new CarInventory();
		colorInventory = new ColorInventory();
	}

	public Slot[] getCarParking() {
		return carParkingArray;
	}

	public void setCarParking(Slot[] carParking) {
		this.carParkingArray = carParking;
	}

	public LinkedList<Integer> getEmptyList() {
		return emptyList;
	}

	public void setEmptyList(LinkedList<Integer> emptyList) {
		this.emptyList = emptyList;
	}

	@Override
	public String vehicalEntry(Vehicle vehicle) throws ParkingException {
		String result=null;
		if(!emptyList.isEmpty()){
		int index = emptyList.get(0);
		if(carInventory.getSlotNumber(vehicle.getRegistrationNumber()) == -1){
		carParkingArray[index].fillSlot(vehicle);
		addToCarInventory(vehicle.getRegistrationNumber(), (CarSlot) carParkingArray[index]);
		addToColorInventory(vehicle.getColour(), (CarSlot) carParkingArray[index]);
		emptyList.remove();
		result=("Allocated Slot Number: " + ((CarSlot) carParkingArray[index]).getSerialNumber());
		}else{
			throw new ParkingException(403,CarParkingExceptionMessage.FROUD_ALERT.getExceptionMsg());
		}
		}else{
			throw new ParkingException(403, CarParkingExceptionMessage.PARKING_SPACE_FULL.getExceptionMsg());
		}
		return result;
	}

	@Override
	public String vehicalExit(int slotNum) throws ParkingException {
			String result=null;
			if (slotNum <= carParkingArray.length) {
				CarSlot slot = (CarSlot) carParkingArray[slotNum - 1];
				Car car = slot.getCar();
				if (car != null) {
					carInventory.removeFromCarInventory(car.getRegistrationNumber());
					colorInventory.removeSlotFromColorInventory(car.getColour(), slot);
					slot.setCar(null);
					emptyList.add(slotNum - 1);
					Collections.sort(emptyList);
					result=("Slot number " + slotNum + " is free");
				} else {
					throw new ParkingException(404, CarParkingExceptionMessage.NOT_FOUND.getExceptionMsg());
				}
			} else {
				throw new ParkingException(404, CarParkingExceptionMessage.NOT_FOUND.getExceptionMsg());
			}
			return result;

	}

	@Override
	public int getParkedSlotNumber(String registrationNumber) throws ParkingException {
			int slotNum =carInventory.getSlotNumber(registrationNumber);
			if(slotNum!=-1){
				return slotNum;
			}else{
				throw new ParkingException(404, CarParkingExceptionMessage.NOT_FOUND.getExceptionMsg());
			}
	}

	@Override
	public String status() {
		StringBuilder result = new StringBuilder("Slot\tNo. Registration\tColour");
		for (Slot slot : carParkingArray) {
			if (!slot.isEmpty()) {
				result.append("\n"+((CarSlot) slot).toString());
//				System.out.println();
			}
		}
		return result.toString();
	}

	/**
	 * prints all slots which have cars of colour color
	 * 
	 * @param color
	 */
	public String printCarSlotWithColour(String color) {
		String result=null;
		try {
			result = (colorInventory.getSlotList(color));
		} catch (ParkingException e) {
			result = e.getMessage();
		}
		return result;
	}

	/**
	 * prints registration number of all cars having colour color
	 * 
	 * @param color
	 */
	public String printRegistrationNumberWithColour(String color) {
		String result = null;
		try {
			result = (colorInventory.getRegitrationNumberList(color));
		} catch (ParkingException e) {
			result = e.getMessage();
		}
		return result;
	}

	private void addToCarInventory(String registrationNumber, CarSlot slot) {
		try {
			carInventory.updateCarInventory(registrationNumber, slot);
		} catch (ParkingException e) {
			System.out.println(e.getMessage());
		}
	}

	private void addToColorInventory(String colour, CarSlot carSlot) {
		colorInventory.addNewSlotToColorInventory(colour, carSlot);
	}

}
