package com.example.flightsearchapi.model.response;

import com.example.flightsearchapi.model.request.FlightDataMockApiResult;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FlightDataMockApiResponse {
    private List<FlightDataMockApiResult> results = new ArrayList<>();

    public void addResult(FlightDataMockApiResult result) {
        results.add(result);
    }
}
