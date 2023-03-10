package com.flightbooking.model;

import java.util.List;

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
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="passenger")

public class Ticket {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int ticketId;
	
	@Column(name="passenger_first_name")
	private String passengerFirstName;
	
	@Column(name="passenger_last_name")
	private String passengerLastName;
	
	@Column(name="passport_number")
	private String passportNumber;
	
	@Column(name="passenger_mobile")
	private long passengerMobile;
	
	@ManyToOne
	@JoinColumn(name="booking_id")
	private Booking booking;

}
