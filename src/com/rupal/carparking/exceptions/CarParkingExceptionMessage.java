package com.rupal.carparking.exceptions;

public enum CarParkingExceptionMessage {
	PARKING_SPACE_FULL("Sorry, Parking lot is full"),
	ALREADY_CAR_PARKED("Sorry this space is already taken..."),
	NO_CAR_FOUND("There is no such car in our parking space..."),
	NO_COLOUR_FOUND("There is no color with car exists..."),
	NOT_FOUND("Not Found"),
	FROUD_ALERT("Alert! There is already a car with same number"),
	INSUFFICIENT_DATA_PARKING_SIZE("Please provide the size of parking lot to create");
	
	
	
	private final String message;
	
	CarParkingExceptionMessage(String msg) {
		this.message = msg;
	}
	
	public String getExceptionMsg(){
		return message;
	}

}
