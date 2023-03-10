package com.flightbooking.dao;

import java.time.LocalDateTime;
import java.util.List;

import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Airport;

public interface FlightDao {
	public Flight addFlight(Flight flight);
	public Flight updateFlight(Flight flight);
	public List<Flight> getAllFlights();
	public Flight getFlightById(long flightId) throws FlightNotFoundException;
	public List<Flight> findByArrivalAirportIdAndDepartureAirportId(long arrivalAirportId, long departureAirportId);
	
}
