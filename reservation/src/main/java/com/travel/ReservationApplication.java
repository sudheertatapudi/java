package com.travel;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.travel.dto.UserDTO;
import com.travel.entity.Station;
import com.travel.entity.Train;
import com.travel.repo.StationRepo;
import com.travel.repo.TrainRepo;
import com.travel.service.JwtUserDetailsService;
import com.travel.util.StationUtil;
import com.travel.util.TrainUtil;

@SpringBootApplication
public class ReservationApplication {

	
	static ConfigurableApplicationContext context;
	
	public static void main(String[] args) {
		context = SpringApplication.run(ReservationApplication.class, args);
		

		  StationRepo stationrepo = context.getBean(StationRepo.class); TrainRepo
		  trainrepo = context.getBean(TrainRepo.class);
		  
		  StationUtil stationUtil = new StationUtil(); 
		  stationUtil.create(stationrepo);
		  
		  TrainUtil trainUtil = new TrainUtil();
		  trainUtil.create(trainrepo,stationrepo);
		  
		
		/*
		 * JwtUserDetailsService userDetailsService =
		 * context.getBean(JwtUserDetailsService.class); UserDTO userDTO = new
		 * UserDTO(); userDTO.setUsername("sudheer"); userDTO.setPassword("password");
		 * userDetailsService.save(userDTO);
		 * 
		 */
	}

	/*
	 * @Override public void run(ApplicationArguments args) throws Exception {
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

}
