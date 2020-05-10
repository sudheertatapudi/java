package com.travel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Train;
import com.travel.repo.TrainRepo;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/trains")
public class TrainCtrl {
	
	@Autowired
	TrainRepo trainRepo;
	
	@RequestMapping(path="/from/{start_station}/to/{end_station}/date/{travel_date}",method=RequestMethod.GET)
	public List<Train> getTrains(@PathVariable(name="start_station") String start_station,
								 @PathVariable(name="end_station") String end_station,
								 @PathVariable(name="travel_date") String traveldate) throws ParseException
	{
		Date travel_date=new SimpleDateFormat("yyyy-MM-dd").parse(traveldate);
		return trainRepo.findByStartstation_nameAndEndstation_nameAndTraveldate(start_station, end_station, travel_date);
	}

}
