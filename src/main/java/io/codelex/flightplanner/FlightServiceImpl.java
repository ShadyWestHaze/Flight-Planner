package io.codelex.flightplanner;

import org.springframework.stereotype.*;
import java.util.*;

@Service
public class FlightServiceImpl implements FlightService {
    private final Map<Integer, Flight> flights = new HashMap<>();
    private int nextId = 1;

    @Override
    public Flight getFlightById(int id) {
        return flights.getOrDefault(id, null);
    }

    @Override
    public Flight addFlight(AddFlightRequest request) {
        Flight newFlight = new Flight(nextId++, request.getDestination(), request.getDepartureTime());
        flights.put(newFlight.getId(), newFlight);
        return newFlight;
    }


    @Override
    public void deleteFlight(int id) {
        flights.remove(id);
    }
}
