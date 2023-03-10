package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.flightbooking.model.Booking;



public interface BookingRepository extends JpaRepository<Booking, Long> {
	
	
	@Query("Select b from Booking b where b.bookingNumber=:bookingNumber")
	public Booking displayByBookingNumber(@Param(value="bookingNumber")int BookingNumber);

}
