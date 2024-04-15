package com.ar.bootcampJava.ApiFlights.exceptions;

public class CompanyNotExistsException extends RuntimeException{

    public CompanyNotExistsException(String message){
        super(message);
    }
}
