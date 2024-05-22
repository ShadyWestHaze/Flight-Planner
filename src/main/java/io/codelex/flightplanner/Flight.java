package io.codelex.flightplanner;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Flight {
    @JsonProperty("id")
    private int id;

    @NotNull
    @JsonProperty("from")
    private Airport fromAirport;

    @NotNull
    @JsonProperty("to")
    private Airport toAirport;

    @NotNull
    @NotBlank
    @JsonProperty("departureTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String departureTime;

    @NotNull
    @NotBlank
    @JsonProperty("arrivalTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private String arrivalTime;

    @NotNull
    @NotBlank
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
    public String getArrivalTime() {
        return  arrivalTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public LocalDateTime getDepartureTimeAsDateTime() {
        return LocalDateTime.parse(departureTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    public LocalDateTime getArrivalTimeAsDateTime() {
        return LocalDateTime.parse(arrivalTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    }
    public void setArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
    }
    public Airport getFromAirport() {
        return fromAirport;
    }
    public Airport getToAirport() {
        return toAirport;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight flight)) return false;
        return Objects.equals(getFromAirport(), flight.getFromAirport()) && Objects.equals(getToAirport(), flight.getToAirport()) && Objects.equals(getDepartureTime(), flight.getDepartureTime()) && Objects.equals(getArrivalTime(), flight.getArrivalTime()) && Objects.equals(getCarrier(), flight.getCarrier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFromAirport(), getToAirport(), getDepartureTime(), getArrivalTime(), getCarrier());
    }


}
