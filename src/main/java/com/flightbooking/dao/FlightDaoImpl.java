package com.flightbooking.dao;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Airport;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.AirportRepository;

@Service
public class FlightDaoImpl implements FlightDao {
	
	@Autowired
	private FlightRepository repository;
	
	@Autowired
	private AirportRepository repo;
	
	public Flight addFlight(Flight flight) {
		return repository.save(flight);
	}

	
	public Flight updateFlight(Flight flight) {
		return repository.save(flight);
	}

	public List<Flight> getAllFlights() {
		return repository.findAll();
	}

	@Override
	public Flight getFlightById(long flightId) throws FlightNotFoundException {
		Flight flt;
		if(repository.findById(flightId).isEmpty()) {
			throw new FlightNotFoundException();
		}
		else {
			flt=repository.findById(flightId).get();
		}
		return flt;
	}
	
	public List<Flight> findByArrivalAirportIdAndDepartureAirportId(long arrivalAirportId, long departureAirportId) {
               return this.repository.findByArrivalAirportIdAndDepartureAirportId(arrivalAirportId, departureAirportId);
    }

	
	
	
}