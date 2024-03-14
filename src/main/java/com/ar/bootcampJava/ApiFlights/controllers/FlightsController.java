package com.ar.bootcampJava.ApiFlights.controllers;

import com.ar.bootcampJava.ApiFlights.models.Flights;
import com.ar.bootcampJava.ApiFlights.services.FlightsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightsController {

    @Autowired
    FlightsService flightsService;

    @GetMapping
    public List<Flights> getFlights(){
        return flightsService.getFlights();
    }

    @GetMapping(value = "/{id}")
    public Flights getFlightById(@PathVariable Long id){
        return flightsService.getFlightById(id);
    }

    @PostMapping
    public void createFlight(@RequestBody Flights flight){
        flightsService.createFlight(flight);
    }

    @PutMapping(value = "/{id}")
    public Flights updateFlight(@PathVariable Long id, @RequestBody Flights flight){
        return flightsService.updateFlight(id, flight);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteFlight(@PathVariable Long id){

        flightsService.deleteFlight(id);
    }
}