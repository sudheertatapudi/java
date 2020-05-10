package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(
	    strategy = InheritanceType.SINGLE_TABLE
		)
@DiscriminatorColumn(name="travel_type")
public class Vehicle implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1298323117199701849L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid2")
	private String id;
	
	private String name;
	
	private Integer available_seats;
	
	private String status;
	
	@Column(name="travel_date")
	@Temporal(TemporalType.DATE)
	private Date traveldate;
	
	@Column(name="arrival_time")
	@Temporal(TemporalType.TIME)
	private Date arrivaltime;
	
	@Column(name="departure_time")
	@Temporal(TemporalType.TIME)
	private Date departuretime;
	
	@Column(name="travel_type",insertable = false,updatable = false)
	private String travel_type;
	
	public Vehicle()
	{
		
	}
	
	public Vehicle(String name, Integer available_seats, Date traveldate,
			Date arrivaltime, Date departuretime,String status) {
		this.name = name;
		this.available_seats = available_seats;
		this.traveldate = traveldate;
		this.arrivaltime = arrivaltime;
		this.departuretime = departuretime;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAvailable_seats() {
		return available_seats;
	}

	public void setAvailable_seats(Integer available_seats) {
		this.available_seats = available_seats;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getTraveldate() {
		return traveldate;
	}

	public void setTraveldate(java.sql.Date traveldate) {
		this.traveldate = traveldate;
	}

	public Date getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(java.util.Date arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getTravel_type() {
		return travel_type;
	}

	public void setTravel_type(String travel_type) {
		this.travel_type = travel_type;
	}

	public Date getDeparturetime() {
		return departuretime;
	}

	public void setDeparturetime(Date departuretime) {
		this.departuretime = departuretime;
	}

}
