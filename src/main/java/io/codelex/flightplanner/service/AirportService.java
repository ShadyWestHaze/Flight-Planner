package io.codelex.flightplanner.service;

import io.codelex.flightplanner.model.Airport;

import java.util.List;

public interface AirportService {
    List<Airport> searchAirports(String search);
}//comment for pull
