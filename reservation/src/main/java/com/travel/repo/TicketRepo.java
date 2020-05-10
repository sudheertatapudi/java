package com.travel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.travel.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, String> {

}
