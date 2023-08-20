package com.example.flightsearchapi.repository;

import com.example.flightsearchapi.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {
    Airport findByCity(String city);
}
