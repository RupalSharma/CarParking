package com.rupal.carparking.services;

public enum Commands {
	
	CREATE_PARKING_LOT("create_parking_lot"),
	STATUS("status"),
	PARK("park"),
	LEAVE("leave"),
	SLOT_NUMBERS_FOR_CARS_WITH_COLOURS("slot_numbers_for_cars_with_colour"),
	REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR("registration_numbers_for_cars_with_colour"),
	EXIT("exit"),
	SLOT_NUMBER_FOR_REGITRATION_NUMBER("slot_number_for_registration_number");
	
	private final String command;
	
	private Commands(String command) {
		this.command=command;
	}
	
	public String getCommand(){
		return this.command;
	}

}
