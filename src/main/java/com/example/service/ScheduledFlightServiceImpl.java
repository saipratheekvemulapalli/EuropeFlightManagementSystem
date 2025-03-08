package com.example.service;
import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ScheduleDaoImpl;
import com.example.dao.ScheduledFlightDaoImpl;
import com.example.exception.RecordNotFoundException;
import com.example.exception.ScheduledFlightNotFoundException;
import com.example.model.Schedule;
import com.example.model.ScheduledFlight;



@Service
public class ScheduledFlightServiceImpl implements IScheduledFlightService {
	@Autowired
 ScheduledFlightDaoImpl dao;
	@Autowired
   ScheduleDaoImpl scheduleDao;
	@Autowired
	IBookingService bookingService;
	@Override
	public ScheduledFlight scheduleFlight(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		return dao.save(scheduledFlight);
	}

	@Override
	public ScheduledFlight modifyScheduledFlight(ScheduledFlight scheduledFlight) {
		// TODO Auto-generated method stub
		ScheduledFlight updateScheduleFlight = dao.findById(scheduledFlight.getScheduleFlightId()).get();
		Schedule updateSchedule = scheduleDao.findById(scheduledFlight.getSchedule().getScheduleId()).get();
		updateScheduleFlight.setAvailableSeats(scheduledFlight.getAvailableSeats());
		updateSchedule.setSrcAirport(scheduledFlight.getSchedule().getSrcAirport());
		updateSchedule.setDstnAirport(scheduledFlight.getSchedule().getDstnAirport());
		updateSchedule.setArrDateTime(scheduledFlight.getSchedule().getArrDateTime());
		updateSchedule.setDeptDateTime(scheduledFlight.getSchedule().getDeptDateTime());
		dao.save(updateScheduleFlight);
		return scheduledFlight;
	}

	@Override
	public String deleteScheduledFlight(BigInteger flightId) throws RecordNotFoundException {
		// TODO Auto-generated method stub
		if (flightId == null)
			throw new RecordNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new RecordNotFoundException("Enter a valid Flight Id");
		else {
			// try {
			// cancelBookings(flightId);
			// } catch (RecordNotFoundException e) {
			// System.out.println("No Bookings Found");
			// }
			dao.deleteById(flightId);
		}
		return "Scheduled flight with ID " + flightId + " is not found";
	}

	@Override
	public Iterable<ScheduledFlight> viewScheduledFlight() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public ScheduledFlight viewScheduledFlights(BigInteger flightId) throws ScheduledFlightNotFoundException {
		// TODO Auto-generated method stub
		if (flightId == null)
			throw new ScheduledFlightNotFoundException("Enter flight Id");
		Optional<ScheduledFlight> scheduleFlight = dao.findById(flightId);
		if (!scheduleFlight.isPresent())
			throw new ScheduledFlightNotFoundException("Enter a valid Flight Id");
		else
			return scheduleFlight.get();
	}
}
