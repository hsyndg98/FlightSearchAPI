package com.example.flightsearchapi.model.response;

import com.example.flightsearchapi.model.FlightData;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDataResponse {

    private String departureAirport;
    private String arrivalAirport;
    private LocalDate departureTime;
    private String departureHour;
    private LocalDate arrivalTime;
    private String arrivalHour;
    private Double price;

    public static List<FlightDataResponse> of(List<FlightData> flightData) {
        List<FlightDataResponse> flightDataResponses = new ArrayList<>();
        for (FlightData f : flightData) {
            FlightDataResponse flightDataResponse = new FlightDataResponse();
            flightDataResponse.setArrivalAirport(f.getArrivalAirport()
                    .getCity());
            flightDataResponse.setDepartureAirport(f.getDepartureAirport()
                    .getCity());
            flightDataResponse.setDepartureTime(f.getDepartureTime());
            flightDataResponse.setArrivalTime(f.getArrivalTime());
            flightDataResponse.setDepartureHour(f.getDepartureHour());
            flightDataResponse.setArrivalHour(f.getArrivalHour());
            flightDataResponse.setPrice(f.getPrice());
            flightDataResponses.add(flightDataResponse);
        }
        return flightDataResponses;
    }
}
