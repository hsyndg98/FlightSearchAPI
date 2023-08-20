package com.example.flightsearchapi.service.impl;

import com.example.flightsearchapi.model.FlightData;
import com.example.flightsearchapi.model.request.FlightTicketRequest;
import com.example.flightsearchapi.model.response.FlightDataResponse;
import com.example.flightsearchapi.repository.FlightRepository;
import com.example.flightsearchapi.service.FlightService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<FlightDataResponse> findAll() {
        List<FlightData> all = flightRepository.findAll();
        return FlightDataResponse.of(all);
    }

    @Override
    public FlightData findById(Long id) {
        Optional<FlightData> flightData = flightRepository.findById(id);
        if (flightData.isPresent()) return flightData.get();
        else throw new IllegalArgumentException("bulunamadı"); //todo: spesifik hata
    }

    @Override
    public FlightData save(FlightData flightData) {
        return flightRepository.save(flightData);
    }

    @Override
    public FlightData deleteById(Long id) {
        Optional<FlightData> flightData = flightRepository.findById(id);
        if (flightData.isPresent()) flightRepository.deleteById(id);
        else throw new IllegalArgumentException("bulunamadı"); //todo: spesifik hata

        return flightData.get();
    }

    @Override
    public List<FlightData> findFlightTicket(FlightTicketRequest flightTicketRequest) {
        return flightRepository
                .findFlightsByDepartureAirportAndArrivalAirportAndDepartureTime(
                        flightTicketRequest.getDeparturePort(), flightTicketRequest.getArrivalPort(), flightTicketRequest.getDepartureDate()
                );
    }

}
