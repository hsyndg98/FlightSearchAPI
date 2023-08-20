package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.model.FlightData;
import com.example.flightsearchapi.model.request.BookingRequest;
import com.example.flightsearchapi.service.FlightSearchService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/*
 * Swagger API: http://localhost:8080/swagger-ui/index.html#
 * */
//Todo: unique indexler yap şehirler ve uçuşların tarihleri için
@Slf4j
@Tag(name = "FlightService", description = "Flight Booking management APIs")
@RestController
@RequestMapping("/v1/booking")
public class FlightSearchController {

    private final FlightSearchService flightSearchService;

    public FlightSearchController(FlightSearchService flightSearchService) {
        this.flightSearchService = flightSearchService;
    }

    @GetMapping()
    public ResponseEntity<List<FlightData>> bookingRequest(
            @RequestParam("arrivalPort") String arrivalPort,
            @RequestParam("departureDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate departureDate,
            @RequestParam("departurePort") String departurePort,
            @RequestParam(value = "returnDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate returnDate
    ) {
        BookingRequest bookingRequest = new BookingRequest(arrivalPort, departurePort, departureDate, returnDate);
        log.info("searching from {} to {} between date {} <-> {}", departurePort, arrivalPort, departureDate, returnDate);
        return ResponseEntity.ok(flightSearchService.booking(bookingRequest));
    }
}
