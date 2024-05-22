package io.codelex.flightplanner;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Objects;

public class Airport {

    @NotNull
    @NotBlank
    @JsonProperty("country")
    public String country;

    @NotNull
    @NotBlank
    @JsonProperty("city")
    public String city;

    @NotNull
    @NotBlank
    @JsonProperty("airport")
    public String airport;

    public Airport(@NotNull @NotBlank String airport, @NotNull @NotBlank String country, @NotNull @NotBlank String city) {
        this.airport = airport;
        this.country = country;
        this.city = city;
        validateFields();
    }

    private void validateFields() {
        if (airport == null || airport.isBlank()) {
            throw new IllegalArgumentException("Airport name cannot be null or empty.");
        }
        if (country == null || country.isBlank()) {
            throw new IllegalArgumentException("Country cannot be null or empty.");
        }
        if (city == null || city.isBlank()) {
            throw new IllegalArgumentException("City cannot be null or empty.");
        }
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAirport() {
        return this.airport;
    }
    public void setAirport(String airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport airport1)) return false;
        return Objects.equals(getCountry(), airport1.getCountry()) && Objects.equals(getCity(), airport1.getCity()) && Objects.equals(getAirport(), airport1.getAirport());
    }


    @Override
    public String toString() {
        return "airport{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", airport='" + airport + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getCity(), getAirport());
    }


}
