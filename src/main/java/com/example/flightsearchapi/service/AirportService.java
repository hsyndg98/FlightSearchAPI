package com.example.flightsearchapi.service;

import com.example.flightsearchapi.model.Airport;

import java.util.List;

public interface AirportService {

    Airport save(Airport airport);

    List<Airport> findAllAirport();

    Airport findById(Long id);

    Airport deleteById(Long id);

    Airport findByCity(String departurePort);
}
