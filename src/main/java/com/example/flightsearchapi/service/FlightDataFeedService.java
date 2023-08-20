package com.example.flightsearchapi.service;

import java.text.ParseException;

public interface FlightDataFeedService {

    void upsertFlightData() throws ParseException;
}
