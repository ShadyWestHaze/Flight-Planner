package io.codelex.flightplanner;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class FlightController {

    private final FlightService flightService;


    public FlightController(FlightService flightService) {
        this.flightService = flightService;


    }


    @GetMapping("/flights/{flightId}")
    public ResponseEntity<?> getFlightDetails(@PathVariable("flightId") int flightId) {
        Flight flight = flightService.getFlightById(flightId);
        if (flight != null) {
            return ResponseEntity.ok(flight);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/admin-api/flights")
    public Flight addFlight(@Valid @RequestBody Flight flight) {
        flightService.addFlight(flight);
        return flight;
    }



    @DeleteMapping("/flights/{flightId}")
    public ResponseEntity<Void> deleteFlight(@PathVariable("flightId") int flightId) {
        flightService.deleteFlight(flightId);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/testing-api/clear")
    public ResponseEntity<Void> clearFlights() {
        flightService.clearFlights();
        return ResponseEntity.ok().build();
    }
}
