package io.codelex.flightplanner.service;

import io.codelex.flightplanner.model.Flight;
import io.codelex.flightplanner.model.SearchFlightsRequest;

import java.util.List;

public interface FlightService {
    Flight getFlightById(int id);
    Flight addFlight(Flight flight) ;
    void clearFlights();
    void deleteFlight(int id);
    List<Flight> searchFlights(SearchFlightsRequest request);
}
