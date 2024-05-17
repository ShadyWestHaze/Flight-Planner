package io.codelex.flightplanner;

public class FlightAlreadyExistsException extends Exception {

    public FlightAlreadyExistsException(String message) {
        super(message);
    }
}
