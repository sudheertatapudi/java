package com.travel.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.travel.entity.Vehicle;


public interface VehicleBaseRepo<T extends Vehicle> extends JpaRepository<T, String> {
	
	List<T> findByName(String name);
	
	List<T> findByTraveldate(java.sql.Date traveldate);

}
