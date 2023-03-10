package com.flightbooking.dao;

import java.util.List;

import com.flightbooking.exception.BookingAlreadyExistsException;
import com.flightbooking.exception.SeatsNotAvailableException;
import com.flightbooking.model.Booking;
public interface BookingDao {
	
	public List<Booking> getAllBookings();
	public Booking newBooking(Booking booking)throws BookingAlreadyExistsException;
	public void cancelBooking(long bookingId);
	public Booking findByBookingNumber(int bookingNumber);
	
}
