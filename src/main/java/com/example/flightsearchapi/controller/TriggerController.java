package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.service.FlightDataFeedService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class TriggerController {

    private final FlightDataFeedService flightDataFeedService;

    public TriggerController(FlightDataFeedService flightDataFeedService) {
        this.flightDataFeedService = flightDataFeedService;
    }

    @GetMapping("/trigger-job")
    public String triggerJob() throws ParseException {
        flightDataFeedService.upsertFlightData();
        return "Job triggered!";
    }
}
