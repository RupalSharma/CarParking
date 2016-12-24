package com.rupal.carparking.car;

public enum Colours {
	RED("red"),
	GREEN("green"),
	BLUE("blue"),
	YELLOW("yellow"),
	WHITE("white"),
	BLACK("black");
	
	private final String colour;
	
	Colours(String colour){
		this.colour = colour; 
	}
	
	public String getColour(){
		return colour;
	}
	
	
	
}
