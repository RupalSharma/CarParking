package com.rupal.carparking.car;

public class Car extends FourWheeler {

	private String registrationNumber;
	private String colour;

	public Car(){
	}
	
	public Car(String regNum, String color){
		this.registrationNumber = regNum;
		this.colour = color;
	}
	@Override
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	@Override
	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setRegistrationNumber(String regNo) {
		this.registrationNumber = regNo;
	}
	
	public boolean equals(Object car){
		return (this.registrationNumber== ((Car)car).getRegistrationNumber());
	}
	
	public String toString(){
		return registrationNumber+"\t"+colour;
	}

}