package com.example.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.ScheduledFlight;

public interface ScheduledFlightDaoImpl extends JpaRepository<ScheduledFlight, BigInteger>{

}