package io.codelex.flightplanner;

import java.util.List;

public interface FlightService {
    Flight getFlightById(int id);
    Flight addFlight(Flight flight) ;
    void clearFlights();
    void deleteFlight(int id);
    List<Flight> searchFlights(SearchFlightsRequest request);
}
