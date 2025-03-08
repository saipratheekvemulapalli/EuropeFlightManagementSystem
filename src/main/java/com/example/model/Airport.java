package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Airport
/**
 * Class Airport
 */
{
	public Airport() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Airport(String airportCode, String airportLocation, String airportName) {
		super();
		this.airportCode = airportCode;
		this.airportLocation = airportLocation;
		this.airportName = airportName;
	}
	@Id
	private String airportCode;
	private String airportLocation;
	private String airportName;
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	public String getAirportLocation() {
		return airportLocation;
	}
	public void setAirportLocation(String airportLocation) {
		this.airportLocation = airportLocation;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
}