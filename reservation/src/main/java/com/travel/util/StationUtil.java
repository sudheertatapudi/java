package com.travel.util;


import java.util.ArrayList;
import java.util.Date;

import com.travel.entity.Station;
import com.travel.repo.StationRepo;

public class StationUtil {

	StationRepo stationRepo;
	
	public void create(StationRepo stationRepo)
	{
		this.stationRepo = stationRepo;
		
		Station station1 = new Station("secunderabad","SC","12740",null,new Date(System.currentTimeMillis()));
		Station station2 = new Station("secunderabad","SC","22203",null,new Date(System.currentTimeMillis()));
		Station station3 = new Station("visakhapatnam","VSKP","12740",null,new Date(System.currentTimeMillis()));
		Station station4 = new Station("visakhapatnam","VSKP","22203",null,new Date(System.currentTimeMillis()));
		Station station5 = new Station("secunderabad","SC","12739",null,new Date(System.currentTimeMillis()));
		Station station6 = new Station("secunderabad","SC","22204",null,new Date(System.currentTimeMillis()));
		Station station7 = new Station("visakhapatnam","VSKP","12739",null,new Date(System.currentTimeMillis()));
		Station station8 = new Station("visakhapatnam","VSKP","22204",null,new Date(System.currentTimeMillis()));
		Station station9 = new Station("banglore","BNC","12213",null,new Date(System.currentTimeMillis()));
		Station station10 = new Station("secunderabad","SC","12213",null,new Date(System.currentTimeMillis()));
		Station station11 = new Station("banglore","BNC","12214",null,new Date(System.currentTimeMillis()));
		Station station12 = new Station("secunderabad","SC","12214",null,new Date(System.currentTimeMillis()));
		Station station13 = new Station("secunderabad","SC","12728",null,new Date(System.currentTimeMillis()));
		Station station14 = new Station("visakhapatnam","VSKP","12728",null,new Date(System.currentTimeMillis()));
		Station station15 = new Station("secunderabad","SC","12727",null,new Date(System.currentTimeMillis()));
		Station station16 = new Station("visakhapatnam","VSKP","12727",null,new Date(System.currentTimeMillis()));
		
		
		ArrayList<Station> stations = new ArrayList<Station>();
		
		stations.add(station1);
		stations.add(station2);
		stations.add(station3);
		stations.add(station4);
		stations.add(station5);
		stations.add(station6);
		stations.add(station7);
		stations.add(station8);
		stations.add(station9);
		stations.add(station10);
		stations.add(station11);
		stations.add(station12);
		stations.add(station13);
		stations.add(station14);
		stations.add(station15);
		stations.add(station16);
		
		
		stationRepo.saveAll(stations);
		
		
		
		
	}
	
}
