package io.codelex.flightplanner;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Airport {
    @JsonProperty("country")
    public String country;
    @JsonProperty("city")
    public String city;
    @JsonProperty("airport")
    public String airport;
    public Airport( String airport, String country, String city) {
        this.airport = airport;
        this.country = country;
        this.city = city;
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
        return airport;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }
}
