package io.codelex.flightplanner;

public interface FlightService {
    Flight getFlightById(int id);
    Flight addFlight(AddFlightRequest request);
    void deleteFlight(int id);
}
