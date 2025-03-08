package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.model.Airport;


public interface AirportDaoImpl extends JpaRepository<Airport, String> {

}