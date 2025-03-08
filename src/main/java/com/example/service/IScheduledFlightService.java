package com.example.service;

import java.math.BigInteger;

import com.example.exception.RecordNotFoundException;
import com.example.exception.ScheduledFlightNotFoundException;
import com.example.model.ScheduledFlight;

public interface IScheduledFlightService {
	public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight);

	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight);

	public String deleteScheduledFlight(BigInteger id) throws RecordNotFoundException;

	public Iterable<ScheduledFlight> viewScheduledFlight();

	public ScheduledFlight viewScheduledFlights(BigInteger id) throws ScheduledFlightNotFoundException;
	// boolean cancelBookings(BigInteger flightId) throws RecordNotFoundException;

}