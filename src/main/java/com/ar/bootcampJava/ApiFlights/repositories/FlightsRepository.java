package com.ar.bootcampJava.ApiFlights.repositories;

import com.ar.bootcampJava.ApiFlights.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<Flights,Long> {
}