package io.codelex.flightplanner;

public class Flight {
    private int id;
    private String destination;
    private String departureTime;

    public Flight(int id, String destination, String departureTime) {
        this.id = id;
        this.destination = destination;
        this.departureTime = departureTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
