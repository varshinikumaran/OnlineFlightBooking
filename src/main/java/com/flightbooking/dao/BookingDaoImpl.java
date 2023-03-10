package com.flightbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.SeatsNotAvailableException;
import com.flightbooking.model.Booking;
import com.flightbooking.model.Flight;
import com.flightbooking.repository.BookingRepository;
import com.flightbooking.repository.FlightRepository;

@Service
public class BookingDaoImpl implements BookingDao {
	
	@Autowired
	private BookingRepository repository;
	
	@Autowired
	private FlightRepository repo;

	
	public List<Booking> getAllBookings() {
		return repository.findAll();
	}

	
	public Booking newBooking(Booking booking) throws BookingAlreadyExistsException {
		if(repository.existsById(booking.getBookingNumber())) {
			throw new BookingAlreadyExistsException();
		}
		return repository.save(booking);
	}

	
	public void cancelBooking(long bookingId) {
		Booking book=repository.getOne( bookingId);
		repository.delete(book);
		
	}

	public Booking findByBookingNumber(int bookingNumber) {
		return this.repository.displayByBookingNumber(bookingNumber);
	}
}
