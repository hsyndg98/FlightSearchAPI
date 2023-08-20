package com.example.flightsearchapi.service.impl;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.model.FlightData;
import com.example.flightsearchapi.model.request.BookingRequest;
import com.example.flightsearchapi.model.request.FlightTicketRequest;
import com.example.flightsearchapi.service.AirportService;
import com.example.flightsearchapi.service.FlightSearchService;
import com.example.flightsearchapi.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightSearchServiceImpl implements FlightSearchService {
    private final FlightService flightService;
    private final AirportService airportService;

    public FlightSearchServiceImpl(FlightService flightService, AirportService airportService) {
        this.flightService = flightService;
        this.airportService = airportService;
    }

    @Override
    public List<FlightData> booking(BookingRequest bookingRequest) {
        Airport departurePort = airportService.findByCity(bookingRequest.getDeparturePort());
        Airport arrivalPort = airportService.findByCity(bookingRequest.getArrivalPort());

        List<FlightData> flightData = new ArrayList<>();

        if (bookingRequest.getReturnDate() == null) {
            FlightTicketRequest flightTicketRequest = new FlightTicketRequest(departurePort, arrivalPort, bookingRequest.getDepartureDate());
            List<FlightData> oneWayFlightData = flightService.findFlightTicket(flightTicketRequest);
            flightData.addAll(oneWayFlightData);
        } else {
            FlightTicketRequest outboundTicket = new FlightTicketRequest(departurePort, arrivalPort, bookingRequest.getDepartureDate());
            FlightTicketRequest returnTicket = new FlightTicketRequest(arrivalPort, departurePort, bookingRequest.getReturnDate());

            List<FlightData> outboundFlightData = flightService.findFlightTicket(outboundTicket);
            List<FlightData> returnFlightData = flightService.findFlightTicket(returnTicket);

            flightData.addAll(outboundFlightData);
            flightData.addAll(returnFlightData);
        }

        return flightData;
    }

}
