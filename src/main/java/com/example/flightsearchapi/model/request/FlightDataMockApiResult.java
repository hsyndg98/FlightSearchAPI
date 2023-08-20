package com.example.flightsearchapi.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDataMockApiResult {
    private String departureAirport;
    private String arrivalAirport;
    private LocalDate departureTime;
    private String departureHour;
    private LocalDate arrivalTime;
    private String arrivalHour;
    private Double price;
}
