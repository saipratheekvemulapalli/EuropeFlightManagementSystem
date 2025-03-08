package com.example.exception;
public class ScheduledFlightNotFoundException extends RuntimeException {
	

	public ScheduledFlightNotFoundException(String str) {
		super(str);
	}

}