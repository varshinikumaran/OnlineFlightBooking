package com.flightbooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.flightbooking.model.Admin;
import com.flightbooking.model.User;

public interface AdminRepository extends JpaRepository<Admin, Long>  {
	
	@Query("Select a from Admin a where a.emailId=:emailId")
	public Admin getEmailId(@Param(value="emailId")String emailId);
	
	@Query("Select a from Admin a where a.emailId=:email_id and a.password=:password")
	public Admin validateAdmin(@Param(value="email_id")String emailId, @Param(value="password") String password);
}
