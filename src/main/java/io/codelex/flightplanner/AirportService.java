package io.codelex.flightplanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AirportService {

    private final FlightRepository flightRepository;

    @Autowired
    public AirportService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<Airport> searchAirports(String search) {
        List<Flight> flights = flightRepository.findAll();
        List<Airport> matchingAirports = new ArrayList<>();
        String normalizedSearch = search.toLowerCase().trim();

        for (Flight flight : flights) {
            Airport fromAirport = flight.getFromAirport();
            Airport toAirport = flight.getToAirport();

            if (matches(fromAirport, normalizedSearch) && !matchingAirports.contains(fromAirport)) {
                matchingAirports.add(fromAirport);
            }
            if (matches(toAirport, normalizedSearch) && !matchingAirports.contains(toAirport)) {
                matchingAirports.add(toAirport);
            }
        }

        return matchingAirports;
    }


    private boolean matches(Airport airport, String search) {
        return airport.getAirport().toLowerCase().contains(search) ||
                airport.getCity().toLowerCase().contains(search) ||
                airport.getCountry().toLowerCase().contains(search);
    }
}



