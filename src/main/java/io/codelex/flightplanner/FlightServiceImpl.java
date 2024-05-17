package io.codelex.flightplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight getFlightById(int id) {
        return flightRepository.findById(id);
    }

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(int id) {
        flightRepository.deleteById(id);
    }

    @Override
    public void clearFlights() {
        flightRepository.clearAll();
    }
}
