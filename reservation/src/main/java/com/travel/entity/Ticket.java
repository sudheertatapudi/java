package com.travel.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(
	    strategy = InheritanceType.SINGLE_TABLE
		)
@DiscriminatorColumn(name="travel_type")
public class Ticket implements Serializable{
	
	private static final long serialVersionUID = 7031345270765258691L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid2")
	private String id;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ticket_number", nullable = false)
	private TicketNumber ticketnumber;
	
	@Column(name="travel_date")
	@Temporal(TemporalType.DATE)
	private Date traveldate;
	
	@Column(name="departure_time")
	@Temporal(TemporalType.TIME)
	private Date departuretime;
	
	/*
	 * @OneToMany( cascade = CascadeType.ALL, orphanRemoval = true )
	 */
	
	
	@ElementCollection
	@CollectionTable(name="PASSENGER",joinColumns = @JoinColumn(name="ticket_number"))
	@LazyCollection(LazyCollectionOption.EXTRA)
    private List<Passenger> passengers = new ArrayList<Passenger>();
	
	@Column(name="travel_type",insertable = false,updatable = false)
	private String travel_type;

	public Ticket()
	{
		
	}
	
	public Ticket(java.sql.Date traveldate,java.util.Date departuretime,List<Passenger> passengers)
	{
		this.traveldate = traveldate;
		this.departuretime = departuretime;
		this.passengers = passengers;
	}

	public TicketNumber getTicketnumber() {
		return ticketnumber;
	}

	public void setTicketnumber(TicketNumber ticketnumber) {
		this.ticketnumber = ticketnumber;
	}

	public Date getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(java.sql.Date traveldate) {
		this.traveldate = traveldate;
	}

	public Date getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(java.util.Date departuretime) {
		this.departuretime = departuretime;
	}

	public List<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

	public String getTravel_type() {
		return travel_type;
	}

	public void setTravel_type(String travel_type) {
		this.travel_type = travel_type;
	}

	

}
