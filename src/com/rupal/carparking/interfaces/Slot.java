package com.rupal.carparking.interfaces;

public interface Slot extends Comparable<Slot>{
		
	public void fillSlot(Vehicle vehical);
	public boolean isEmpty();
		
}
