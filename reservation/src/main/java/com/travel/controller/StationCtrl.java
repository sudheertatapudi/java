package com.travel.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Station;
import com.travel.repo.StationRepo;

@RestController
@RequestMapping("/stations")
public class StationCtrl {
	
	@Autowired
	StationRepo stationRepo;
	
	@RequestMapping("/all")
	public List<String> getAll()
	{
		return stationRepo.findnames();
	}
	
	@RequestMapping(path="/trainno/{train_no}",method=RequestMethod.GET)
	public List<Station> getByTrainNo(@PathVariable(name="train_no") String train_no)
	{
		return stationRepo.findByTrainnumber(train_no);
	}
	
	

}
