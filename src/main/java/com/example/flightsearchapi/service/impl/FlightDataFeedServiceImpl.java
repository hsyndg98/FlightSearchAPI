package com.example.flightsearchapi.service.impl;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.model.FlightData;
import com.example.flightsearchapi.model.request.FlightDataMockApiResult;
import com.example.flightsearchapi.model.response.FlightDataMockApiResponse;
import com.example.flightsearchapi.service.AirportService;
import com.example.flightsearchapi.service.FlightDataFeedService;
import com.example.flightsearchapi.service.FlightService;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Service
public class FlightDataFeedServiceImpl implements FlightDataFeedService {

    private final FlightService flightService;
    private final AirportService airportService;

    public FlightDataFeedServiceImpl(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }


    public void upsertFlightData() throws ParseException {

        FlightDataMockApiResponse response = mockApiCall();

        for (FlightDataMockApiResult result : response.getResults()) {
            Airport departureAirport = upsertAirport(result.getDepartureAirport());
            Airport arrivalAirport = upsertAirport(result.getArrivalAirport());

            FlightData flight = new FlightData();
            flight.setDepartureAirport(departureAirport);
            flight.setArrivalAirport(arrivalAirport);
            flight.setDepartureTime(result.getDepartureTime());
            flight.setDepartureHour(result.getDepartureHour());
            flight.setArrivalTime(result.getArrivalTime());
            flight.setArrivalHour(result.getArrivalHour());
            flight.setPrice(result.getPrice());

            flightService.save(flight);
        }
    }

    private Airport upsertAirport(String cityName) {
        Airport airport = airportService.findByCity(cityName);
        if (airport == null) {
            airport = new Airport();
            airport.setCity(cityName);
            airportService.save(airport);
        }
        return airport;
    }

    private FlightDataMockApiResponse mockApiCall() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // Izmir -> Istanbul
        FlightDataMockApiResult mockResult = new FlightDataMockApiResult();
        mockResult.setDepartureAirport("Izmir");
        mockResult.setArrivalAirport("Istanbul");
        mockResult.setDepartureTime(LocalDate.of(2023,8,18));
        mockResult.setDepartureHour("14:30:00.000");
        mockResult.setArrivalTime(LocalDate.of(2023,8,18));
        mockResult.setArrivalHour("15:30:00.000");
        mockResult.setPrice(200.0);

        // Istabul -> Izmir
        FlightDataMockApiResult mockResult2 = new FlightDataMockApiResult();
        mockResult2.setDepartureAirport("Istanbul");
        mockResult2.setArrivalAirport("Izmir");
        mockResult2.setDepartureTime(LocalDate.of(2023,8,18));
        mockResult2.setDepartureHour("15:30:00.000");
        mockResult2.setArrivalTime(LocalDate.of(2023,8,18));
        mockResult2.setDepartureHour("16:30:00.000");
        mockResult2.setPrice(300.0);

        FlightDataMockApiResponse mockResponse = new FlightDataMockApiResponse();
        mockResponse.addResult(mockResult);
        mockResponse.addResult(mockResult2);

        return mockResponse;
    }

}
