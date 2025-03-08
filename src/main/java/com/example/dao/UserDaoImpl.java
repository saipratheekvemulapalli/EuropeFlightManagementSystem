package com.example.dao;

import java.math.BigInteger;

import org.springframework.data.repository.CrudRepository;

import com.example.model.User;

public interface UserDaoImpl extends CrudRepository<User, BigInteger>{

}