package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.FlightData;
import com.example.flightsearchapi.model.request.BookingRequest;

import java.util.List;

public interface FlightSearchService {
    List<FlightData> booking(BookingRequest bookingRequest);
}
