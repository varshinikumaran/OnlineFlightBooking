package com.flightbooking.model;

import java.time.LocalDate;
import java.util.Date;
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
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="booking")
public class Booking {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="booking_number")
	private long bookingNumber;
	
	
	@Column(name="booking_date")
	private LocalDate bookingDate;

	
	@Column(name="seats_number")
	private int seatsNumber;
	
	@Column(name="total_cost")
	private int totalCost;
	
	@Column(name="travel_date")
	private int travelDate;
	
	@ManyToOne 
	@JoinColumn(name="flight_id")
	private Flight flight;
	
	@OneToMany(mappedBy="booking", cascade= CascadeType.ALL)
	private List<Ticket> tickets;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	

}
