package com.ar.bootcampJava.ApiFlights.services;

import com.ar.bootcampJava.ApiFlights.exceptions.FlightNotExistsException;
import com.ar.bootcampJava.ApiFlights.repositories.FlightsRepository;
import com.ar.bootcampJava.ApiFlights.models.Flights;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightsService {

    @Autowired
    FlightsRepository flightsRepository;

    public List<Flights> getFlights() {
        return flightsRepository.findAll();
    }

    public void createFlight(Flights flight) {
        flightsRepository.save(flight);
    }

    public Flights getFlightById(Long id) {

        return flightsRepository.findById(id).orElse(null);
    }

    public String deleteFlight(Long id){
        if (flightsRepository.existsById(id)){
            flightsRepository.deleteById(id);
            return "El vuelo con id: " + id + " ha sido eliminado";
        } else {
            throw new FlightNotExistsException("El vuelo a eliminar elegido no existe");
        }

    }

    public Flights updateFlight(Long id, Flights flight) {
        if (flightsRepository.existsById(id)){
            Flights flightToModify = flightsRepository.findById(id).get();

            if (flight.getOrigin() != null){
                flightToModify.setOrigin(flight.getOrigin());
            }

            if (flight.getDestination() != null){
                flightToModify.setDestination(flight.getDestination());
            }

            if (flight.getDepartureDateTime() != null){
                flightToModify.setDepartureDateTime(flight.getDepartureDateTime());
            }

            if (flight.getArrivalDateTime() != null){
                flightToModify.setArrivalDateTime(flight.getArrivalDateTime());
            }

            if (flight.getPrice() != null){
                flightToModify.setPrice(flight.getPrice());
            }

            if (flight.getFrequence() != null){
                flightToModify.setFrequence(flight.getFrequence());
            }

            Flights flightModified = flightsRepository.save(flightToModify);

            return flightModified;
        }

        return null;
    }
}
