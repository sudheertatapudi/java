package com.travel.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

//@Entity
@Embeddable
public class Passenger {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy=GenerationType.AUTO, generator="system-uuid")
	 * 
	 * @GenericGenerator(name="system-uuid",strategy = "uuid2") private String id;
	 */
	
	private String name;
	
	private Integer age;
	
	private String gender;
	
	@Column(name="seat_no")
	private Integer seatnumber;
	
	@Column(name="booking_status")
	private String bookingstatus;

	/*
	 * public String getId() { return id; }
	 * 
	 * public void setId(String id) { this.id = id; }
	 */

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getSeatnumber() {
		return seatnumber;
	}

	public void setSeatnumber(Integer seatnumber) {
		this.seatnumber = seatnumber;
	}

	public String getBookingstatus() {
		return bookingstatus;
	}

	public void setBookingstatus(String bookingstatus) {
		this.bookingstatus = bookingstatus;
	}

	@Override
	public String toString() {
		return "Passenger [name=" + name + ", age=" + age + ", gender=" + gender + ", seatnumber=" + seatnumber
				+ ", bookingstatus=" + bookingstatus + "]";
	}

	
	
	
}
