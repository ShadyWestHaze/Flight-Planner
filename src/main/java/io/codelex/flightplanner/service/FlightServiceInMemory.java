package io.codelex.flightplanner.service;

import io.codelex.flightplanner.model.Flight;
import io.codelex.flightplanner.model.SearchFlightsRequest;
import io.codelex.flightplanner.repository.FlightInMemoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class FlightServiceInMemory implements FlightService {

    private final FlightInMemoryRepository flightInMemoryRepository;

    public FlightServiceInMemory(FlightInMemoryRepository flightInMemoryRepository) {
        this.flightInMemoryRepository = flightInMemoryRepository;
    }

    @Override
    public Flight getFlightById(Long id) {
        Flight flight = flightInMemoryRepository.findById(id);
        if (flight == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
        return flight;
    }

    @Override
    public Flight addFlight(Flight flight) {
        LocalDateTime departureTime = flight.getDepartureTime();
        LocalDateTime arrivalTime = flight.getArrivalTime();

        if (arrivalTime.isBefore(departureTime) || arrivalTime.equals(departureTime)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Arrival time must be after departure time");
        }

        String fromAirportCode = flight.getFromAirport().getAirport().trim();
        String toAirportCode = flight.getToAirport().getAirport().trim();

        if (fromAirportCode.equalsIgnoreCase(toAirportCode)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot fly to the same airport");
        }

        List<Flight> existingFlights = flightInMemoryRepository.findAll();
        for (Flight existingFlight : existingFlights) {
            if (existingFlight.equals(flight)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Flight already exists");
            }
        }
        return flightInMemoryRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        flightInMemoryRepository.deleteById(id);
    }

    @Override
    public void clearFlights() {
        flightInMemoryRepository.clearAll();
    }

    @Override
    public List<Flight> searchFlights(SearchFlightsRequest request) {
        if (request.getFrom().equalsIgnoreCase(request.getTo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot fly to the same airport");
        }
        return flightInMemoryRepository.findAll().stream()
                .filter(flight -> flight.getFromAirport().getAirport().equalsIgnoreCase(request.getFrom()))
                .filter(flight -> flight.getToAirport().getAirport().equalsIgnoreCase(request.getTo()))
                .filter(flight -> flight.getDepartureTime().toLocalDate().toString().equals(request.getDepartureDate()))
                .collect(Collectors.toList());
    }
}
