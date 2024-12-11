package com.pokemon.soap.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class PokemonModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String ip;
    private String method;
    private LocalDateTime dateRequest;
    private long duration;
    private String request;
    @Column(name = "response", length = 100000)
    private String response;
}
