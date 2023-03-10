package com.flightbooking.model;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="flight")
public class Flight {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	@Column(name="flight_id")
	private long flightId;
	
	private String flightName="King flyer";
	
	@Column(name="arrival_date_time")
	private LocalDateTime arrivalDateTime;
	
	@Column(name="departure_date_time")
	private LocalDateTime departureDateTime;
	
	@Column(name="seat_capacity")
	private int seatCapacity;
	
   @Column(name="price")
   private long price;
   
   @Column (name="available_seats")
   private int availableSeats;
	
   @ManyToOne
   @JoinColumn(name="departure_airport_id")
   private Airport departureAirport;

   @ManyToOne
   @JoinColumn(name="arrival_airport_id")
   private Airport arrivalAirport;
   
   @OneToMany(mappedBy="flight", cascade= CascadeType.ALL)
   private List<Booking> bookings;
}