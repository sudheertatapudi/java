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
@DiscriminatorColumn(name = "travel_type")
public class Stop implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4530421122414962754L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="system-uuid")
	@GenericGenerator(name="system-uuid",strategy = "uuid2")
	private String id;
	
	private String name;
	
	private String code;
	
	private String halt;
	
	@Temporal(TemporalType.TIME)
	private Date arrival_time;
	
	@Column(name="travel_type",insertable = false,updatable = false)
	private String travel_type;
	
	public Stop(String name,String code,String halt,Date arrival_time)
	{
		this.name = name;
		this.code = code;
		this.halt = halt;
		this.arrival_time = arrival_time;
	}

	public Stop()
	{
		
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHalt() {
		return halt;
	}

	public void setHalt(String halt) {
		this.halt = halt;
	}

}
