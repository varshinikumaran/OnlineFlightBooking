package com.flightbooking.exception;

public class SeatsNotAvailableException  extends Exception {
	private String message4;
	public SeatsNotAvailableException() {}
	public SeatsNotAvailableException(String message4) {
		this.message4=message4;
	}
	public String getMessage4() {
		return this.message4;
	}
	

}
