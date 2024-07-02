package io.codelex.flightplanner.repository;

import io.codelex.flightplanner.model.Airport;
import io.codelex.flightplanner.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface FlightDbRepository extends JpaRepository<Flight, Long> {
    Optional<Flight> findByFromAirportAndToAirportAndDepartureTimeAndArrivalTimeAndCarrier(Airport fromAirport, Airport toAirport, LocalDateTime departureTime, LocalDateTime arrivalTime, String carrier);

    @Query("SELECT f FROM Flight f WHERE f.fromAirport.airport = :from AND f.toAirport.airport = :to AND TO_CHAR(f.departureTime, 'YYYY-MM-DD') = :departureDate")
    List<Flight> searchFlights(@Param("from") String from, @Param("to") String to, @Param("departureDate") String departureDate);
}

