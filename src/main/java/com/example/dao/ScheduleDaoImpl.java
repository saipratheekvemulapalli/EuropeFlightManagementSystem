package com.example.dao;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Schedule;

public interface ScheduleDaoImpl extends JpaRepository<Schedule, BigInteger> {

}