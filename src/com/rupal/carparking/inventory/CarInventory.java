package com.rupal.carparking.inventory;

import java.util.HashMap;
import java.util.Map;

import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.exceptions.CarParkingExceptionMessage;
import com.rupal.carparking.interfaces.Inventory;
import com.rupal.carparking.interfaces.Slot;
import com.rupal.carparking.slot.CarSlot;
/**
 * This class maintains a map of vehical registration number and slot allocated to that vehicle
 * @author Rupal
 *
 */
public class CarInventory implements Inventory {
	private HashMap<String,Slot> carMap;
	
	public CarInventory(){
		carMap= new HashMap<>();
	}
	
	/**
	 * based on registration number provides slot allocated to that vehical
	 * @param registrationNumber
	 * @return
	 * @throws ParkingException 
	 */
	public int getSlotNumber(String registrationNumber){
		Slot slot=carMap.get(registrationNumber);
		if(slot== null){
			return -1;
		}
		return ((CarSlot)slot).getSerialNumber();
	}
	
	public void updateCarInventory(String registrationNumber, CarSlot carSlot) throws ParkingException{
		Slot slot=carMap.get(registrationNumber.toUpperCase());
		if(slot == null){
			carMap.put(registrationNumber.toUpperCase(), carSlot);
		}else{
			throw new ParkingException(403, CarParkingExceptionMessage.FROUD_ALERT.getExceptionMsg());
		}
	}
	
	public void removeFromCarInventory(String regNum){
		carMap.remove(regNum);
	}
}
