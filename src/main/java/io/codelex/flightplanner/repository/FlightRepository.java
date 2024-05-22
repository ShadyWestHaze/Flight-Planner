package io.codelex.flightplanner.repository;

import io.codelex.flightplanner.model.Flight;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FlightRepository {

    private final Map<Integer, Flight> flights = new HashMap<>();
    private int nextId = 1;

    public synchronized Flight findById(int id) {
        return flights.get(id);
    }

    public synchronized Flight save(Flight flight){
        int id = getNextId();
        flight.setId(id);
        flights.put(id, flight);
        return flight;
    }

    public List<Flight> findAll() {
        return new ArrayList<>(flights.values());
    }

    public synchronized void deleteById(int id) {
        flights.remove(id);
    }

    public synchronized int getNextId() {
        return nextId++;
    }

    public synchronized void clearAll() {
        flights.clear();
        nextId = 1;
    }
}
