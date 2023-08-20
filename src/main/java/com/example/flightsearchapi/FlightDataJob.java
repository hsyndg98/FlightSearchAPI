package com.example.flightsearchapi;

import com.example.flightsearchapi.service.impl.FlightDataFeedServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Slf4j
@Service("flightDataJob")
public class FlightDataJob {

    private final FlightDataFeedServiceImpl flightDataFeedServiceImpl;

    public FlightDataJob(FlightDataFeedServiceImpl flightDataFeedServiceImpl) {
        this.flightDataFeedServiceImpl = flightDataFeedServiceImpl;
    }

    @Scheduled(cron = "0 0 * * * *")
    public void fetchAndSaveFlightData() throws ParseException {
        log.info("Process feed starting.");
        flightDataFeedServiceImpl.upsertFlightData();
    }
}
