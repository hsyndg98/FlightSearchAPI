package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.FlightData;
import com.example.flightsearchapi.model.request.FlightTicketRequest;
import com.example.flightsearchapi.model.response.FlightDataResponse;

import java.util.List;

public interface FlightService {
    List<FlightDataResponse> findAll();

    FlightData findById(Long id);

    FlightData save(FlightData flightData);

    FlightData deleteById(Long id);

    List<FlightData> findFlightTicket(FlightTicketRequest flightTicketRequest);

}
