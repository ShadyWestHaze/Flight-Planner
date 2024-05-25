package io.codelex.flightplanner.controller;

import io.codelex.flightplanner.model.Airport;
import io.codelex.flightplanner.service.AirportServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AirportController {

    private final AirportServiceImpl airportServiceImpl;

    @Autowired
    public AirportController(AirportServiceImpl airportServiceImpl) {
        this.airportServiceImpl = airportServiceImpl;
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/api/airports")
    public List<Airport> searchAirports(@RequestParam String search) {
        return airportServiceImpl.searchAirports(search);
    }
}//comment for pull
