package com.travel.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.Train;

public interface TrainRepo extends VehicleBaseRepo<Train> {
	
	
	Train findByTrainnumber(String number);
	Train findByTrainnumberAndTraveldate(String number,Date travelDate);
	List<Train> findByStartstation_name(String name);
	List<Train> findByEndstation_name(String name);
	List<Train> findByStartstation_nameAndEndstation_nameAndTraveldate(String start_station,String end_station,Date travelDate);
	List<Train> findByStartstation_codeAndEndstation_code(String start_station_code,String end_station_code);
 
}
