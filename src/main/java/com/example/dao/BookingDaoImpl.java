package com.example.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Booking;

public interface BookingDaoImpl extends JpaRepository<Booking, BigInteger> {

}