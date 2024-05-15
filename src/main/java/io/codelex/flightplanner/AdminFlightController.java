package io.codelex.flightplanner;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin-api/flights")
public class AdminFlightController {

    @GetMapping("/{flightId}")
    public ResponseEntity<String> getAdminFlight(@PathVariable("flightId") int flightId) {
        return ResponseEntity.ok("Details for admin");
    }
}
