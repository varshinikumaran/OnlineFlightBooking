package com.flightbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.flightbooking.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long> {
	
	@Query("SELECT f FROM Flight f WHERE f.arrivalAirport.id = :arrivalAirportId AND f.departureAirport.id = :departureAirportId")
	public List<Flight> findByArrivalAirportIdAndDepartureAirportId(long arrivalAirportId, long departureAirportId);
	
}
