package io.codelex.flightplanner;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FlightRepository {

    private final Map<Integer, Flight> flights = new HashMap<>();
    private int nextId = 1;

    public Flight findById(int id) {
        return flights.getOrDefault(id, null);
    }

    public synchronized Flight save(Flight flight){
        int id = getNextId();
        flight.setId(id);
        flights.put(id, flight);
        System.out.println(flight);
        return flight;
    }
    public List<Flight> findAll() {
        return new ArrayList<>(flights.values());
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
