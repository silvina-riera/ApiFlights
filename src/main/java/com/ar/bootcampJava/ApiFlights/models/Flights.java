package com.ar.bootcampJava.ApiFlights.models;

import com.ar.bootcampJava.ApiFlights.models.enums.Frequence;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "flights")
@Getter
@Setter
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String origin;

    private String destination;

    private LocalDateTime departureDateTime;

    private LocalDateTime arrivalDateTime;

    private Double price;

    private Frequence frequence;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Companies company;

}
