package com.flightbooking.dao;

import java.util.List;

import com.flightbooking.exception.InvalidAdminException;
import com.flightbooking.model.Admin;
import com.flightbooking.model.Flight;
import com.flightbooking.model.Airport;

public interface AdminDao {
	
	public Admin registerAdmin(Admin admin);
	public String loginAdmin(Admin admin) throws InvalidAdminException;

	
}