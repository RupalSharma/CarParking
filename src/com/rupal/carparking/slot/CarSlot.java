package com.rupal.carparking.slot;

import com.rupal.carparking.car.Car;
import com.rupal.carparking.interfaces.Slot;
import com.rupal.carparking.interfaces.Vehicle;

public class CarSlot implements Slot, Comparable {
	private int serialNumber;
	private Car car;
	
	public CarSlot(int index){
		this.serialNumber=index;
		this.car=null;
	}
	
	public CarSlot(){
		this.serialNumber = -1;
		this.car=null;
	}
	@Override
	public void fillSlot(Vehicle vehical) {
		this.car= (Car)vehical;

	}

	@Override
	public boolean isEmpty() {
		if(this.car == null)
			return true;
		return false;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	@Override
	public int compareTo(Object s1) {
		if(this.serialNumber < ((CarSlot)s1).getSerialNumber()){
			return -1;
		}else if(this.serialNumber > ((CarSlot)s1).getSerialNumber()){
			return 1;
		}else{
			return 0;
		}
	}
	
	public String toString(){
		return serialNumber+"\t"+car.toString();
	}
}
