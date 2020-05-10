package com.travel.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.travel.entity.Passenger;
import com.travel.entity.Station;
import com.travel.entity.Ticket;
import com.travel.entity.TicketNumber;
import com.travel.entity.Train;
import com.travel.entity.TrainTicket;
import com.travel.entity.TrainTicketType;
//import com.travel.repo.PassengerRepo;
import com.travel.repo.StationRepo;
import com.travel.repo.TicketNumberRepo;
import com.travel.repo.TicketRepo;
import com.travel.repo.TrainRepo;


@RestController
@RequestMapping("/tickets")
public class TicketCtrl {
	
	@Autowired
	TrainRepo trainRepo;
	
	@Autowired
	StationRepo stationRepo;
	
	@Autowired
	TicketRepo ticketRepo;
	
	/*
	 * @Autowired PassengerRepo passengerRepo;
	 */
	@Autowired
	TicketNumberRepo ticketNumberRepo;
	
	@RequestMapping(value = "/createticket/{train_no}/{from}/{to}/{travel_date}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	@Transactional(rollbackFor = Exception.class)
	public Ticket create(@RequestBody TrainTicket ticket,
							   @PathVariable(name="train_no") String train_no, 
							   @PathVariable(name="from") String fromstation,
							   @PathVariable(name="to") String tostation,
							   @PathVariable(name="travel_date") String traveldate) throws ParseException
	{
		
		Ticket created_ticket = null;
		
		Date travel_date=new SimpleDateFormat("yyyy-MM-dd").parse(traveldate);  
		Train train = trainRepo.findByTrainnumberAndTraveldate(train_no, travel_date);
		
		System.out.println("train name : "+train.getName()+" travel date : "+train.getTraveldate().toString());
		
		Station frm_station = stationRepo.findByNameAndTrainnumber(fromstation, train_no);
		System.out.println("from station  : "+frm_station.getName());
		
		Station to_station = stationRepo.findByNameAndTrainnumber(tostation, train_no);
		System.out.println("to station : "+to_station.getName());
		
		System.out.println("traveldate :"+traveldate);
		
		
		if(train.getAvailable_seats() > ticket.getPassengers().size())
		{
			List<Passenger> travellers = new ArrayList<Passenger>();
			Integer avail_seats =train.getAvailable_seats() ;
			for(Passenger passenger : ticket.getPassengers())
		 	{
				
					passenger.setSeatnumber(avail_seats);
					passenger.setBookingstatus("CNF");
					avail_seats--;
					travellers.add(passenger);
			}
			
			System.out.println("After avail seats : "+avail_seats);
			train.setAvailable_seats(avail_seats);
			trainRepo.save(train);
			
			TicketNumber tktnum = new TicketNumber();
			TicketNumber created_tktnum = ticketNumberRepo.save(tktnum);
			
			ticket.setTicketnumber(created_tktnum);
			ticket.setDeparturetime(train.getDeparturetime());
			ticket.setFromstation(frm_station);
			ticket.setTostation(to_station);
			ticket.setTrainnumber(train);
			ticket.setPassengers(travellers);
			ticket.setTickettype(TrainTicketType.GENERAL);
			
			created_ticket = ticketRepo.save(ticket);
		}
		else
		{
			
		}
		
		return created_ticket;
	}
	
	
	@RequestMapping(value = "/create/{train_no}/{from}/{to}", method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
	public Ticket createTicket(@RequestBody TrainTicket ticket,
							   @PathVariable(name="train_no") String train_no, 
							   @PathVariable(name="from") String fromstation,
							   @PathVariable(name="to") String tostation,
							   @RequestParam(value="passenger", required=false) List<String> passengers
							   )
	{
		
		Ticket created_ticket = null;
		
		/*
		 * Train train = trainRepo.findByTrainnumber(train_no);
		 * System.out.println("train name : "+train.getName());
		 * 
		 * Station frm_station = stationRepo.findByNameAndTrainnumber(fromstation,
		 * train_no); System.out.println("from statio  : "+frm_station.getName());
		 * 
		 * Station to_station = stationRepo.findByNameAndTrainnumber(tostation,
		 * train_no); System.out.println("to station : "+to_station.getName());
		 * 
		 * System.out.println("passengers : "+Arrays.asList(passengers));
		 * 
		 * List<Passenger> travellers = new ArrayList<Passenger>();
		 * 
		 * if(train.getAvailable_seats() > passengers.size()) { Integer avail_seats
		 * =train.getAvailable_seats() ; for(String passenger : passengers) {
		 * Optional<Passenger> traveller = passengerRepo.findById(passenger);
		 * 
		 * if(traveller.isPresent()) { Passenger travlr = traveller.get();
		 * travlr.setSeatnumber(avail_seats); travlr.setBookingstatus("CNF");
		 * passengerRepo.save(travlr); avail_seats--; travellers.add(travlr); } }
		 * 
		 * System.out.println("After avail seats : "+avail_seats);
		 * train.setAvailable_seats(avail_seats); trainRepo.save(train);
		 * 
		 * TicketNumber tktnum = new TicketNumber(); TicketNumber created_tktnum =
		 * ticketNumberRepo.save(tktnum);
		 * 
		 * ticket.setTicketnumber(created_tktnum); ticket.setFromstation(frm_station);
		 * ticket.setTostation(to_station); ticket.setTrainnumber(train);
		 * ticket.setPassengers(travellers);
		 * ticket.setTickettype(TrainTicketType.GENERAL);
		 * 
		 * created_ticket = ticketRepo.save(ticket); }
		 */
		
		return created_ticket;
	}

}
