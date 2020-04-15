package com.dataart.tickets.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

import com.dataart.tickets.domain.FlightTicket;
import com.dataart.tickets.repository.FlightTicketRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class FlightTicketControllerTest {

    private final static String URI = "/tickets";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FlightTicketRepository flightTicketRepository;

    @Test
    public void getTicketByIdShouldReturnATicket() throws Exception {

        FlightTicket testTicket = FlightTicket.builder()
            .id(123L)
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

        given(flightTicketRepository.findById(123L)).willReturn(Optional.of(testTicket));

        this.mockMvc.perform(MockMvcRequestBuilders.get(URI + "/{id}", 123)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(123))
                .andReturn();
    }

    @Test
    public void getTicketByIdShouldThrowException() throws Exception {

        given(flightTicketRepository.findById(123L)).willReturn(Optional.ofNullable(null));

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get(URI + "/{id}", 123)
                                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andReturn();
    }
}