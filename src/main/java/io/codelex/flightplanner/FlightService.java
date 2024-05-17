package io.codelex.flightplanner;

public interface FlightService {
    Flight getFlightById(int id);
    Flight addFlight(Flight flight) throws FlightAlreadyExistsException;
    void deleteFlight(int id);
    void clearFlights();
}
