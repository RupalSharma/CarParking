package com.rupal.carparking.exceptions;

@SuppressWarnings("serial")
public class ParkingException extends Exception {
	private int errorCode;
	private String message;
	
	public ParkingException(int errorCode, String msg){
		super(msg);
		this.errorCode=errorCode;
		this.message=msg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	
}
