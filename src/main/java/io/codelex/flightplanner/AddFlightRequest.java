package io.codelex.flightplanner;

public class AddFlightRequest {
    private String destination;
    private String departureTime;


    public AddFlightRequest(String destination, String departureTime) {
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
}
