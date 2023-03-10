package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightbooking.model.Airport;
import com.flightbooking.model.User;

public interface AirportRepository extends JpaRepository<Airport, Long> {
	
	
}
