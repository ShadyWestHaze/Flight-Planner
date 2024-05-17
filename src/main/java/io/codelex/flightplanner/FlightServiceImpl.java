package io.codelex.flightplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Flight addFlight(Flight flight) throws FlightAlreadyExistsException {
        List<Flight> existingFlights = flightRepository.findAll();
        for (Flight existingFlight : existingFlights) {
            if (existingFlight.equals(flight)) {
                throw new FlightAlreadyExistsException("Flight already exists.");
            }
        }
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
