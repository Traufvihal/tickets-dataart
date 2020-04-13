package com.dataart.tickets.util;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.dataart.tickets.domain.FlightTicket;
import com.dataart.tickets.repository.FlightTicketRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MockUpData implements CommandLineRunner {

    private final FlightTicketRepository flightTicketRepository;

    public MockUpData(FlightTicketRepository flightTicketRepository) {
        this.flightTicketRepository = flightTicketRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        FlightTicket ticketOne = FlightTicket.builder()
			.arrivalDate(LocalDate.of(2020, 5, 20))
			.departureDate(LocalDate.of(2020, 5, 19))
			.arrivalTime(LocalTime.of(12, 45, 00))
			.departureTime(LocalTime.of(6, 20, 00))
			.passengerName("Santiago Sansone")
			.passengerAge(32)
			.luggage(false)
			.originCity("Cordoba")
			.destinationCity("Montevideo")
			.price(new BigDecimal("345.40"))
            .build();
            
        FlightTicket ticketTwo = FlightTicket.builder()
			.arrivalDate(LocalDate.of(2020, 5, 20))
			.departureDate(LocalDate.of(2020, 5, 19))
			.arrivalTime(LocalTime.of(12, 45, 00))
			.departureTime(LocalTime.of(6, 20, 00))
			.passengerName("Tatiana Moraes")
			.passengerAge(40)
			.luggage(false)
			.originCity("Cordoba")
			.destinationCity("Montevideo")
			.price(new BigDecimal("345.40"))
            .build();
            
            flightTicketRepository.save(ticketOne);
            flightTicketRepository.save(ticketTwo);

        log.info("Saved {} tickets in DB", flightTicketRepository.count());

    }

}