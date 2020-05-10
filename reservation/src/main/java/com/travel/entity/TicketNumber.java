package com.travel.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class TicketNumber {

	@TableGenerator(name = "TicketNum_Gen", table = "ID_GEN", pkColumnName = "GEN_NAME", valueColumnName = "GEN_VAL", pkColumnValue = "Tktnum_Gen", initialValue = 10000, allocationSize = 1000)
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "TicketNum_Gen")
	@Column(name = "ticket_number")
	private Long number;
	
	public TicketNumber()
	{
		
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

}
