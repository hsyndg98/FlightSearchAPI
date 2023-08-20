package com.example.flightsearchapi.model.request;

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
public class BookingRequest {
    private String arrivalPort;
    private String departurePort;
    private LocalDate departureDate;
    private LocalDate returnDate;

}
