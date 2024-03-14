package com.ar.bootcampJava.ApiFlights.exceptions;

public class FlightNotExistsException extends RuntimeException{

    public FlightNotExistsException(String message){
        super(message);
    }
}
