package com.travel.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DiscriminatorValue("train")
public class TrainTicket extends Ticket{
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "train_no", nullable = false)
	private Train trainnumber;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "from_station",
        referencedColumnName = "id"
    )
	private Station fromstation;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "to_station",
        referencedColumnName = "id"
    )
	private Station tostation;
	
	@Enumerated(EnumType.STRING)
	@Column(name="ticket_type")
	private TrainTicketType tickettype;
	
	public TrainTicket()
	{
		
	}
	
	public TrainTicket(java.sql.Date traveldate,java.util.Date departuretime,List<Passenger> passengers)
	{
		super(traveldate,departuretime,passengers);
	}

	public Train getTrainnumber() {
		return trainnumber;
	}

	public void setTrainnumber(Train trainnumber) {
		this.trainnumber = trainnumber;
	}

	public Station getFromstation() {
		return fromstation;
	}

	public void setFromstation(Station fromstation) {
		this.fromstation = fromstation;
	}

	public Station getTostation() {
		return tostation;
	}

	public void setTostation(Station tostation) {
		this.tostation = tostation;
	}

	public TrainTicketType getTickettype() {
		return tickettype;
	}

	public void setTickettype(TrainTicketType tickettype) {
		this.tickettype = tickettype;
	}

	@Override
	public String toString() {
		return "TrainTicket [trainnumber=" + trainnumber + ", fromstation=" + fromstation + ", tostation=" + tostation
				+ ", getTicketnumber()=" + getTicketnumber() + ", getTraveldate()=" + getTraveldate()
				+ ", getDeparturetime()=" + getDeparturetime() + ", getPassengers()=" + getPassengers()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
