package com.dataart.tickets.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class FlightTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String originCity;
    private String destinationCity;
    private String passengerName;
    private Integer passengerAge;
    private boolean luggage;

    private LocalDate departureDate;
    private LocalDate arrivalDate;
    private LocalTime departureTime;
    private LocalTime arrivalTime;

    private BigDecimal price;

}