package com.travel.entity;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.GenericGenerator;


@Entity
@DiscriminatorValue("train")
public class Station extends Stop{
	
	
	@Column(name="train_no")
	private String trainnumber;
	
	
	public Station()
	{
		
	}
	
	public Station(String name,String code,String trainnumber,String halt,Date arrival_time)
	{
		super(name,code,halt,arrival_time);
		this.trainnumber = trainnumber;
	}


	public String getTrainnumber() {
		return trainnumber;
	}

	public void setTrainnumber(String train_no) {
		this.trainnumber = train_no;
	}

	@Override
	public String toString() {
		return "Station [trainnumber=" + trainnumber + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getCode()=" + getCode() + ", getHalt()=" + getHalt() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}


}
