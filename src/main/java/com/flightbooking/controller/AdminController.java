package com.flightbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightbooking.dao.AdminDao;
import com.flightbooking.dao.AirportDao;
import com.flightbooking.dao.BookingDao;
import com.flightbooking.dao.FlightDao;
import com.flightbooking.dao.TicketDao;
import com.flightbooking.dao.UserDao;
import com.flightbooking.exception.FlightNotFoundException;
import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.model.Airport;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Ticket;
import com.flightbooking.model.User;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminDao adminDao;
	
	@Autowired
	private AirportDao airportDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private TicketDao dao;
	
	@Autowired
	private UserDao userDao;
	
	//admin part
	
	@PostMapping("/adminRegistration")
	public ResponseEntity registerAdmin(@RequestBody Admin admin) {
		Admin f=this.adminDao.registerAdmin(admin);
		return new ResponseEntity(f, HttpStatus.CREATED);
	}
	
	@PostMapping("/loginAdmin")
	public String loginAdmin(@RequestBody Admin admin) throws InvalidAdminException{
		return this.adminDao.loginAdmin(admin);
	}

	
	// booking part
	
	@GetMapping("/getAllBookings")
	public List<Booking> getAllBookings(){
		return this.bookingDao.getAllBookings();
	}
	
	//Flight part
	
	@PostMapping("/addFlight")
	public ResponseEntity addFlight(@RequestBody Flight flight) {
		Flight ft=this.flightDao.addFlight(flight);
		return new ResponseEntity(ft, HttpStatus.CREATED);
	}
	
	@PutMapping("/updateFlight")
	public Flight updateFlight(@RequestBody Flight flight) {
		return this.flightDao.updateFlight(flight);
	}
	
	@GetMapping("/getAllFlights")
	public List<Flight> getAllFlights() {
		return this.flightDao.getAllFlights();
	}
	
	@GetMapping("/{flightId}")
	public ResponseEntity getFlight(@PathVariable long flightId) throws FlightNotFoundException {
		return new ResponseEntity(this.flightDao.getFlightById(flightId),HttpStatus.OK);
	}
	
	//Ticket part
	
	@PostMapping("/addTicket")
	public Ticket addTicket(@RequestBody Ticket ticket) {
		return this.dao.addTicket(ticket);
	}
	
	@GetMapping("/FindAllTickets")
	public List<Ticket> findAllTickets() {
		return this.dao.findAllTickets();
	}
	
	@DeleteMapping("/cancelTicket")
	public void cancelTicket(@PathVariable int ticketId) {
		Ticket ticket = this.dao.getTicketById(ticketId);
		this.dao.cancelTicket(ticketId);
	}
	
	//Airport
	
	@GetMapping("/getAllAirports")
	public List<Airport> getAllAirports() {
		return airportDao.getAllAirport();
	}

	@PostMapping("/addAirports")
	public Airport addAirport(@RequestBody Airport airport) {
		return airportDao.addAirport(airport);
	}

	@PutMapping("/updateAirport")
	public Airport updateAirport(@RequestBody Airport airport) {
		return airportDao.updateAirport(airport);
	}
	
	//user 
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers() {
		return this.userDao.getAllUsers();
	}
}
