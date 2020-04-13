package com.dataart.tickets;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import com.dataart.tickets.domain.FlightTicket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TicketsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketsApplication.class, args);

	}

}
