package com.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Passenger;
//import com.travel.repo.PassengerRepo;

@RestController
@RequestMapping("/passengers")
public class PassengerCtrl {
	/*
	 * @Autowired PassengerRepo passengerRepo;
	 * 
	 * @RequestMapping(value = "/add", method = RequestMethod.POST,consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public Passenger addPassenger(@RequestBody
	 * Passenger passenger) { return passengerRepo.save(passenger); }
	 */

}
