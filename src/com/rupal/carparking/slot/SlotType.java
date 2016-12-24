package com.rupal.carparking.slot;

public enum SlotType {
	CAR_SLOT_TYPE("car_slot");
	
	private final String slotType;
	
	SlotType(String type){
		this.slotType=type;
	}
	
	public String getSlotType(){
		return this.slotType;
	}
}
