package com.example.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.example.model.Flight;

public interface IFlightService {
	public ResponseEntity<?> addFlight(Flight flight);

	public Iterable<Flight> viewAllFlight();

	public Flight viewFlight(BigInteger flightNumber);

	public Flight modifyFlight(Flight flight);

	public String removeFlight(BigInteger flightNumber);

}