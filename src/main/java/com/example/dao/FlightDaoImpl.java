package com.example.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Flight;

public interface FlightDaoImpl extends JpaRepository<Flight,BigInteger>{

}