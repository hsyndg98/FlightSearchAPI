package com.example.flightsearchapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class FlightData extends BaseEntity {
    @ManyToOne(fetch = FetchType.EAGER)
    private Airport departureAirport;
    @ManyToOne(fetch = FetchType.EAGER)
    private Airport arrivalAirport;
    private LocalDate departureTime;
    private String departureHour;
    private LocalDate arrivalTime;
    private String arrivalHour;
    private Double price;

}
