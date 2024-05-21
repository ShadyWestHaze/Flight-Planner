package io.codelex.flightplanner;

public interface FlightService {
    Flight getFlightById(int id);
    Flight addFlight(Flight flight) ;
    void deleteFlight(int id);
    void clearFlights();
}
