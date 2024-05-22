package io.codelex.flightplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Autowired
    public FlightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight getFlightById(int id) {
        Flight flight = flightRepository.findById(id);
        if (flight == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight not found");
        }
        return flight;
    }

    @Override
    public Flight addFlight(Flight flight) {
        if (flight.getArrivalTimeAsDateTime().isBefore(flight.getDepartureTimeAsDateTime())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Arrival time must be after departure time");
        }

        if (flight.getFromAirport().getAirport().equalsIgnoreCase(flight.getToAirport().getAirport())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot fly to the same airport");
        }

        List<Flight> existingFlights = flightRepository.findAll();
        for (Flight existingFlight : existingFlights) {
            if (existingFlight.equals(flight)) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "Flight already exists");
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
    @Override
    public List<Flight> searchFlights(SearchFlightsRequest request) {
        if (request.getFrom().equalsIgnoreCase(request.getTo())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot fly to the same airport");
        }

        return flightRepository.findAll().stream()
                .filter(flight -> flight.getFromAirport().getAirport().equalsIgnoreCase(request.getFrom()))
                .filter(flight -> flight.getToAirport().getAirport().equalsIgnoreCase(request.getTo()))
                .filter(flight -> flight.getDepartureTime().substring(0, 10).equals(request.getDepartureDate()))
                .collect(Collectors.toList());
    }
}
