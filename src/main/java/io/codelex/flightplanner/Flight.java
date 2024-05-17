package io.codelex.flightplanner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Flight {
    @JsonProperty("id")
    private int id;
    @JsonProperty("from")
    private Airport fromAirport;
    @JsonProperty("to")
    private Airport toAirport;
    @JsonProperty("departureTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String departureTime;
    @JsonProperty("arrivalTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String arrivalTime;
    @JsonProperty("carrier")
    private String carrier;

    public Flight(int id, Airport fromAirport, Airport toAirport, String carrier, String departureTime, String arrivalTime) {
        this.id = id;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.carrier = carrier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Airport getFromAirport() {
        return fromAirport;
    }

    public void setFromAirport(String airportName,String city,String country) {
        this.fromAirport = new Airport(airportName,city,country);
    }

    public Airport getToAirport() {
        return toAirport;
    }

    public void setToAirport(String airportName,String city,String country) {
        this.toAirport = new Airport(airportName,city,country);
    }

    public String getCarrier() {
        return carrier;
    }

    public void setCarrier(String carrier) {
        this.carrier = carrier;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", fromAirport='" + fromAirport + '\'' +
                ", toAirport='" + toAirport + '\'' +
                ", departureTime='" + departureTime + '\'' +
                ", arrivalTime='" + arrivalTime + '\'' +
                ", carrier='" + carrier + '\'' +
                '}';
    }


}
