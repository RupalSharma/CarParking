package com.rupal.carparking.tests;

import com.rupal.carparking.car.Car;
import com.rupal.carparking.car.Colours;
import com.rupal.carparking.exceptions.ParkingException;
import com.rupal.carparking.inventory.CarInventory;
import com.rupal.carparking.inventory.ColorInventory;
import com.rupal.carparking.services.CarParkingManager;
import com.rupal.carparking.slot.CarSlot;

public class CarParkingDataProvider {

	int lotSize = 4;
	String registrationNumber1="KA­01­HH­1234";
	String registrationNumber2="KA­01­HH­9999";
	String registrationNumber3="KA­01­BB­0001";
	String registrationNumber4="KA­01­HH­3141";
	String red = Colours.RED.getColour();
	String black = Colours.BLACK.getColour();
	String white = Colours.WHITE.getColour();
	
	public Car getWhiteCar1(){
		return new Car(registrationNumber1,white);
	}
	
	public Car getWhiteCar2(){
		return new Car(registrationNumber2,white);
	}
	
	public Car getRedCar3(){
		return new Car(registrationNumber3,red);
	}
	
	public Car getBlackCar4(){
		return new Car(registrationNumber4, black);
	}
	
	public String getRegistrationNumer1(){
		return registrationNumber1;
	}
	
	public String getRed(){
		return red;
	}

	public String getBlack() {
		return black;
	}
	
	public String getRegistrationNumber3(){
		return registrationNumber3;
	}
	
	public String getRegistrationNumber4(){
		return registrationNumber4;
	}

	public String getWhite() {
		// TODO Auto-generated method stub
		return this.white;
	}
	
	public CarSlot getFirCarSlotFilledWithWhiteCar1(){
		Car c1 = getWhiteCar1();
		CarSlot  cs1= new CarSlot(1);
		cs1.fillSlot(c1);
		return cs1;
	}
	public CarSlot getSecondCarSlotFilledWithBlackCar4(){
		CarSlot cs2= new CarSlot(2);
		Car c2 = getBlackCar4();
		cs2.fillSlot(c2);
		return cs2;
	}
	
	public CarSlot getThirdFilledCarSlotToAdd(){
		CarSlot cs = new CarSlot(3);
		cs.setCar(getRedCar3());
		return cs;
	}
	
	public CarSlot getThirdCarSlotWithColorWhite(){
		CarSlot cs = new CarSlot(3);
		cs.setCar(getWhiteCar2());
		return cs;
	}
	
	public CarInventory getTestCarInventory(){
		CarInventory carInventory = new CarInventory();
		CarSlot  cs1 = getFirCarSlotFilledWithWhiteCar1();
		CarSlot  cs2 = getSecondCarSlotFilledWithBlackCar4();
		try {
			carInventory.updateCarInventory(getRegistrationNumer1(), cs1);
			carInventory.updateCarInventory(getRegistrationNumber4(), cs2);
		} catch (ParkingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return carInventory;
	}

	public String getRegistrationNumber2() {
		return registrationNumber2;
	}
	
	public ColorInventory getTestColorInventory(){
		ColorInventory ci = new ColorInventory();
		Car c1 = getWhiteCar1();
		Car c2 = getBlackCar4();
		CarSlot  cs1 = getFirCarSlotFilledWithWhiteCar1();
		CarSlot  cs2 = getSecondCarSlotFilledWithBlackCar4();
		cs1.fillSlot(c1);
		cs2.fillSlot(c2);
		ci.addNewSlotToColorInventory(getWhite(),cs1);
		ci.addNewSlotToColorInventory(getBlack(), cs2);
		return ci;
	}

	public CarSlot getFirstEmptyCarSlot() {
		
		return new CarSlot(1);
	}

	public CarSlot getSecondEmptyCarSlot() {
		return new CarSlot(2);
	}
	
	public CarParkingManager getParkingManagerInstance(){
		CarParkingManager parkingManager = new CarParkingManager(lotSize);
		try {
			parkingManager.vehicalEntry(getWhiteCar1());
			parkingManager.vehicalEntry(getWhiteCar2());
			parkingManager.vehicalEntry(getRedCar3());
		} catch (ParkingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return parkingManager;
	}
}
