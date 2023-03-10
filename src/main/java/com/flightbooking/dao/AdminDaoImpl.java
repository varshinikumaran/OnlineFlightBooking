package com.flightbooking.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Airport;
import com.flightbooking.repository.AdminRepository;
import com.flightbooking.repository.FlightRepository;
import com.flightbooking.repository.AirportRepository;

@Service
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private AirportRepository repoLoc;
	@Autowired
	private FlightRepository repoFlight;
	@Autowired
	private AdminRepository repoAdmin;
	
	public Admin registerAdmin(Admin admin) {
		return repoAdmin.save(admin);
	}
	
	public String loginAdmin(Admin admin) throws InvalidAdminException {
		if(repoAdmin.validateAdmin(admin.getEmailId(),admin.getPassword())!=null) {
			throw new InvalidAdminException();
		}
		return "Login Successful";
	}

}
