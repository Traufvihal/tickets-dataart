package com.dataart.tickets.repository;

import com.dataart.tickets.domain.FlightTicket;

import org.springframework.data.repository.CrudRepository;

public interface FlightTicketRepository extends CrudRepository<FlightTicket, Long> {
}