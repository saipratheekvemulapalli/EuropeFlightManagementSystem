package com.example.service;

import java.math.BigInteger;

import org.springframework.http.ResponseEntity;

import com.example.model.Booking;

public interface IBookingService {

	public ResponseEntity<?> addBooking(Booking newBooking);

	public Booking modifyBooking(Booking newBooking);

	public String deleteBooking(BigInteger bookingId);

	public Iterable<Booking> displayAllBooking();

	public ResponseEntity<?> findBookingById(BigInteger bookingId);
}