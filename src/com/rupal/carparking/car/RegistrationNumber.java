package com.rupal.carparking.car;

import com.rupal.carparking.interfaces.RegistrationNumberINF;

public class RegistrationNumber implements RegistrationNumberINF {
	private String stateCode;
	private int cityCode;
	private String prefix;
	private int lastfourDigit;
	
	public RegistrationNumber(){
		
	}
	
	public RegistrationNumber(String stateCode, int cityCode, String prefix, int lastfourDigit){
		this.stateCode=stateCode.toUpperCase();
		this.cityCode = cityCode;
		this.prefix = prefix.toUpperCase();
		this.lastfourDigit = lastfourDigit;
	}
	
	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public int getCityCode() {
		return cityCode;
	}

	public void setCityCode(int cityCode) {
		this.cityCode = cityCode;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getLastfourDigit() {
		return lastfourDigit;
	}

	public void setLastfourDigit(int lastfourDigit) {
		this.lastfourDigit = lastfourDigit;
	}
	
	@Override
	public boolean equals(RegistrationNumberINF obj) {
		RegistrationNumber reg =(RegistrationNumber)obj;
		return (this.stateCode.equalsIgnoreCase(reg.getStateCode()) && this.prefix.equals(reg.getPrefix())
				&& this.cityCode == reg.getCityCode() && this.lastfourDigit == reg.getLastfourDigit());
	}
	
	public int hashcode() {
		return stateCode.hashCode()+Integer.valueOf(cityCode).hashCode()+prefix.hashCode()+Integer.valueOf(lastfourDigit).hashCode();
	}
	
	public String toString(){
		String citycode =cityCode<10?("0"+cityCode):Integer.toString(cityCode);
		return stateCode.toUpperCase()+"-"+citycode+"-"+prefix.toUpperCase()+lastfourDigit;
	}
	
}
