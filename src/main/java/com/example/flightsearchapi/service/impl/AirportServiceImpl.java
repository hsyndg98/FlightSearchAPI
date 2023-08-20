package com.example.flightsearchapi.service.impl;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.repository.AirportRepository;
import com.example.flightsearchapi.service.AirportService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport save(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> findAllAirport() {
        return airportRepository.findAll();
    }

    @Override
    public Airport findById(Long id) {
        Optional<Airport> airportData = airportRepository.findById(id);

        if (airportData.isPresent()) return airportData.get();
        else throw new IllegalArgumentException("bulunamadı"); //todo: global exception
    }

    @Override
    public Airport deleteById(Long id) {
        Optional<Airport> airport = airportRepository.findById(id);

        if (airport.isPresent()) airportRepository.deleteById(id);
        else throw new IllegalArgumentException("bulunamadı");

        return airport.get();
    }

    @Override
    public Airport findByCity(String departurePort) {
        return airportRepository.findByCity(departurePort);
    }
}
