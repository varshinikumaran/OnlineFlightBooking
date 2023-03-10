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

import com.flightbooking.dao.BookingDao;
import com.flightbooking.dao.FlightDao;
import com.flightbooking.dao.TicketDao;
import com.flightbooking.dao.UserDao;
import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.UserNotFoundException;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Ticket;
import com.flightbooking.model.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BookingDao bookingDao;
	
	@Autowired
	private FlightDao flightDao;
	
	@Autowired
	private TicketDao dao;
	
	//user part
	
	@PostMapping("/registerUser")
	public ResponseEntity registerUser(@RequestBody User user) {
		User usr= this.userDao.registerUser(user);
		return new ResponseEntity(usr, HttpStatus.CREATED);
	}
	
	@PostMapping("/loginUser")
	public String loginUser(@RequestBody User user) throws UserNotFoundException{
		return this.userDao.loginUser(user);
	}
	
	@PutMapping("/updateUser")
	public User updateUser(@RequestBody User user) {
		return this.userDao.updateUser(user);
	}
	
	
	@DeleteMapping("/deleteUser")
	public ResponseEntity<HttpStatus> deleteUser(@PathVariable long userId) {
		try {
		this.userDao.deleteUser(userId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getUserById")
	public User getUserById(@PathVariable long userId) throws UserNotFoundException {
		return this.userDao.getUserById(userId);
	}
	
	
	
	//booking
	
	@PostMapping("/newBooking")
	public ResponseEntity newBooking(@RequestBody Booking booking) throws BookingAlreadyExistsException {
		Booking book= this.bookingDao.newBooking(booking);
		return new ResponseEntity(book,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/cancelBooking")
	public ResponseEntity<HttpStatus> cancelBooking(@PathVariable long bookingId) {
		try {
		this.bookingDao.cancelBooking(bookingId);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/getByBookingNumber")
	public Booking getBookingByNumber(@PathVariable int number ){
		return this.bookingDao.findByBookingNumber(number);
	
}
	//flight
	
	@GetMapping("/flights/{arrivalAirportId}/{departureAirportId}")
    public List<Flight> findByArrivalAirportIdAndDepartureAirportId(@PathVariable long arrivalAirportId, @PathVariable long departureAirportId) {
        return flightDao.findByArrivalAirportIdAndDepartureAirportId(arrivalAirportId, departureAirportId);
    }
	
	//Ticket
	@GetMapping("/getTicketById")
	public Ticket getTicketById(@PathVariable int ticketId) {
		return this.dao.getTicketById(ticketId);
	}
	
	
}