package io.codelex.flightplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
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
    public Flight addFlight(Flight flight) {
        LocalDateTime departureTime = flight.getDepartureTimeAsDateTime();
        LocalDateTime arrivalTime = flight.getArrivalTimeAsDateTime();

        if (arrivalTime.isBefore(departureTime) || arrivalTime.equals(departureTime)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Arrival time must be after departure time");
        }

        String fromAirportCode = flight.getFromAirport().getAirport().trim();
        String toAirportCode = flight.getToAirport().getAirport().trim();
        if (fromAirportCode.equalsIgnoreCase(toAirportCode)) {
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
}
