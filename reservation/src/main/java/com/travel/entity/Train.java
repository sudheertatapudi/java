package com.travel.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("train")
public class Train extends Vehicle{

	
	@Column(name="train_no")
	private String trainnumber;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "start_station",
        referencedColumnName = "id"
    )
	private Station startstation;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "end_station",
        referencedColumnName = "id"
    )
	private Station endstation;
	
	public Train()
	{
		
	}
	
	public Train(String name, String trainnumber, Integer available_seats, Date traveldate,
			Date arrivaltime, Date departuretime, Station startstation, Station endstation,String status) {
		
		super(name,available_seats,traveldate,arrivaltime, departuretime,status);
		this.trainnumber = trainnumber;
		this.startstation = startstation;
		this.endstation = endstation;
	}


	public String getTrainnumber() {
		return trainnumber;
	}

	public void setTrainnumber(String trainnumber) {
		this.trainnumber = trainnumber;
	}

	@JsonIgnore
	public Station getStartstation() {
		return startstation;
	}

	@JsonIgnore
	public void setStartstation(Station startstation) {
		this.startstation = startstation;
	}
	
	public Station getEndstation() {
		return endstation;
	}

	public void setEndstation(Station endstation) {
		this.endstation = endstation;
	}

	@Override
	public String toString() {
		return "Train [trainnumber=" + trainnumber + ", startstation=" + startstation + ", endstation=" + endstation
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getAvailable_seats()=" + getAvailable_seats()
				+ ", getStatus()=" + getStatus() + ", getTraveldate()=" + getTraveldate() + ", getArrivaltime()="
				+ getArrivaltime() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}
