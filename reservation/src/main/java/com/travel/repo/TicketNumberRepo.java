package com.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.Ticket;
import com.travel.entity.TicketNumber;

public interface TicketNumberRepo extends JpaRepository<TicketNumber, Long> {

}
