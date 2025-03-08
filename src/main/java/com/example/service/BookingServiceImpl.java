package com.example.service;

import java.math.BigInteger;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.dao.BookingDaoImpl;
import com.example.exception.RecordAlreadyPresentException;
import com.example.exception.RecordNotFoundException;
import com.example.model.Booking;

public class BookingServiceImpl implements IBookingService {

	@Autowired
	BookingDaoImpl bookingDao;
	
	@Override
	public ResponseEntity<?> addBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		try {
			if (!findBookingById.isPresent()) {
				bookingDao.save(newBooking);
				return new ResponseEntity<Booking>(newBooking, HttpStatus.OK);
			} else
				throw new RecordAlreadyPresentException(
						"Booking with Booking Id: " + newBooking.getBookingId() + " already exists!!");
		} catch (RecordAlreadyPresentException e) {

			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Booking modifyBooking(Booking newBooking) {
		// TODO Auto-generated method stub
		Optional<Booking> findBookingById = bookingDao.findById(newBooking.getBookingId());
		if (findBookingById.isPresent()) {
			bookingDao.save(newBooking);
		} else
			throw new RecordNotFoundException(
					"Booking with Booking Id: " + newBooking.getBookingId() + " not exists!!");
		return newBooking;
	}

	@Override
	public String deleteBooking(BigInteger bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> findBookingById = bookingDao.findById(bookingId);
		if (findBookingById.isPresent()) {
			bookingDao.deleteById(bookingId);
			return "Booking Deleted!!";
		} else
			throw new RecordNotFoundException("Booking not found for the entered BookingID");
	}

	@Override
	public Iterable<Booking> displayAllBooking() {
		// TODO Auto-generated method stub
		return bookingDao.findAll();
	}

	@Override
	public ResponseEntity<?> findBookingById(BigInteger bookingId) {
		// TODO Auto-generated method stub
		Optional<Booking> findById = bookingDao.findById(bookingId);
		try {
			if (findById.isPresent()) {
				Booking findBooking = findById.get();
				return new ResponseEntity<Booking>(findBooking, HttpStatus.OK);
			} else
				throw new RecordNotFoundException("No record found with ID " + bookingId);
		} catch (RecordNotFoundException e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
