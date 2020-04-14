package com.dataart.tickets.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class FlightTicketNotFoundException extends RuntimeException {

    public FlightTicketNotFoundException(Long id) {
        super("Flight Ticket with Id " + id + " was not found.");
    }
}