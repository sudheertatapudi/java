package com.travel.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.travel.entity.Station;
import com.travel.entity.Train;
import com.travel.repo.StationRepo;
import com.travel.repo.TrainRepo;

public class TrainUtil {
	
	StationRepo stationRepo;
	TrainRepo trainRepo;
	
	public void create(TrainRepo trainRepo,StationRepo stationRepo)
	{
		
		this.stationRepo = stationRepo;
		this.trainRepo = trainRepo;
		
		 Calendar cal = Calendar.getInstance();  
	        cal.setTime(new Date());  
	        cal.set(Calendar.HOUR_OF_DAY, 20);  
	        cal.set(Calendar.MINUTE, 30);  
	        cal.set(Calendar.SECOND, 0);  
	        cal.set(Calendar.MILLISECOND, 0);  
	        
	        
		Train train1 = new Train("GARIBHRADH", 
								 "12740", 
								 400,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 cal.getTime(),
								 stationRepo.findByNameAndTrainnumber("secunderabad", "12740"), 
								 stationRepo.findByNameAndTrainnumber("visakhapatnam", "12740"),"AVAIL");
		
		
		
		Train train2 = new Train("DURANTO", 
								 "22204", 
								 250,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("secunderabad", "22204"), 
								 stationRepo.findByNameAndTrainnumber("visakhapatnam", "22204"),"AVAIL");
		
		Train train3 = new Train("GARIBHRADH", 
								 "12739", 
								 400,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("visakhapatnam", "12739"), 
								 stationRepo.findByNameAndTrainnumber("secunderabad", "12739"),"AVAIL");
		
		Train train4 = new Train("DURANTO", 
								 "22203", 
								 250,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("visakhapatnam", "22203"), 
								 stationRepo.findByNameAndTrainnumber("secunderabad", "22203"),"AVAIL");
		

		Train train5 = new Train("DURANTO", 
								 "12213", 
								 250,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("banglore", "12213"), 
								 stationRepo.findByNameAndTrainnumber("secunderabad", "12213"),"AVAIL");
		
		Train train6 = new Train("DURANTO", 
								 "12214", 
								 250,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("secunderabad", "12214"), 
								 stationRepo.findByNameAndTrainnumber("banglore", "12214"),"AVAIL");
		

		Train train7 = new Train("GODAVARI", 
								 "12728", 
								 250,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("secunderabad", "12728"), 
								 stationRepo.findByNameAndTrainnumber("visakhapatnam", "12728"),"AVAIL");
		
		Train train8 = new Train("GODAVARI", 
								 "12727", 
								 250,
								 new Date(),
								 new Date(System.currentTimeMillis()),
								 new Date(System.currentTimeMillis()),
								 stationRepo.findByNameAndTrainnumber("visakhapatnam", "12727"), 
								 stationRepo.findByNameAndTrainnumber("secunderabad", "12727"),"AVAIL");
		
		
		
		ArrayList<Train> trains = new ArrayList<Train>();
		
		trains.add(train1);
		trains.add(train2);
		trains.add(train3);
		trains.add(train4);
		trains.add(train5);
		trains.add(train6);
		trains.add(train7);
		trains.add(train8);
		
		trainRepo.saveAll(trains);
		
	}

}
