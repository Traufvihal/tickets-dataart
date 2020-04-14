package com.dataart.tickets.controller;

import com.dataart.tickets.domain.FlightTicket;
import com.dataart.tickets.exception.FlightTicketNotFoundException;
import com.dataart.tickets.repository.FlightTicketRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class FlightTicketController {

    private final FlightTicketRepository flightTicketRepository;

    public FlightTicketController(FlightTicketRepository flightTicketRepository) {
        this.flightTicketRepository = flightTicketRepository;
    }

    @GetMapping("{id}")
    public FlightTicket getById(@PathVariable Long id) {
        return flightTicketRepository.findById(id).orElseThrow(() -> new FlightTicketNotFoundException(id));
    }

    @PostMapping
    public FlightTicket create(@RequestBody FlightTicket ticket) {
        return flightTicketRepository.save(ticket);
    }

}