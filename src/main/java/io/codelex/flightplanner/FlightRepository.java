package io.codelex.flightplanner;

import org.springframework.stereotype.Repository;
import java.util.HashMap;
import java.util.Map;

@Repository
public class FlightRepository {

    private final Map<Integer, Flight> flights = new HashMap<>();
    private int nextId = 1;

    public Flight findById(int id) {
        return flights.getOrDefault(id, null);
    }

    public Flight save(Flight flight) {
        flight.setId(nextId++);
        flights.put(flight.getId(), flight);
        return flight;
    }

    public void deleteById(int id) {
        flights.remove(id);
    }
    public int getNextId() {
        return flights.size() + 1;
    }

    public void clearAll() {
        flights.clear();
    }
}
