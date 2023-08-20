package com.example.flightsearchapi.repository;

import com.example.flightsearchapi.model.Airport;
import com.example.flightsearchapi.model.FlightData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface FlightRepository extends JpaRepository<FlightData, Long> {

    @Query("select fd from FlightData fd where fd.departureAirport=?1 and fd.arrivalAirport=?2 and fd.departureTime = ?3")
    List<FlightData> findFlightsByDepartureAirportAndArrivalAirportAndDepartureTime(Airport departureAirport, Airport arrivalAirport, LocalDate departureTime);

}
