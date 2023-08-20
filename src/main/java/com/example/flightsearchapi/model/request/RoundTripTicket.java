package com.example.flightsearchapi.model.request;

import com.example.flightsearchapi.model.Airport;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoundTripTicket {
    private Airport arrivalPort;
    private Airport departurePort;
    private LocalDate departureDate;
    private LocalDate returnDate;
}
