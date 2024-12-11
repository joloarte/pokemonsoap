package com.pokemon.soap.controller;

import com.pokemon.soap.*;
import com.pokemon.soap.endpoint.PokemonEndpoint;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/soap")
public class SoapRestAdapter {

    @Autowired
    private PokemonEndpoint soapEndpoint;

    @Operation(summary = "Obtener información del Pokémon desde el servicio SOAP")
    @GetMapping("/pokemon")
    public GetPokemonNameResponse getPokemon(@RequestParam GetPokemonNameRequest pokemonName) {
        return soapEndpoint.getPokemonName(pokemonName);
    }
    @Operation(summary = "Obtener Habilidades del Pokémon desde el servicio SOAP")
    @GetMapping("/pokemonAbilities")
    public GetPokemonAbilitiesResponse getPokemonAbilities(@RequestParam GetPokemonAbilitiesRequest pokemonName) {
        return soapEndpoint.getPokemonAbilities(pokemonName);
    }
    @Operation(summary = "Obtener Base Experiencia del Pokémon desde el servicio SOAP")
    @GetMapping("/getPokemonBaseExperience")
    public GetPokemonBaseExperienceResponse getPokemonBaseExperience(@RequestParam GetPokemonBaseExperienceRequest pokemonName) {
        return soapEndpoint.getPokemonBaseExperience(pokemonName);
    }
    @Operation(summary = "Obtener HeldItems del Pokémon desde el servicio SOAP")
    @GetMapping("/getPokemonHeldItems")
    public GetPokemonHeldItemsResponse getPokemonHeldItems(@RequestParam GetPokemonHeldItemsRequest pokemonName) {
        return soapEndpoint.getPokemonHeldItems(pokemonName);
    }
    @Operation(summary = "Obtener Id del Pokémon desde el servicio SOAP")
    @GetMapping("/getPokemonId")
    public GetPokemonIdResponse getPokemonId(@RequestParam GetPokemonIdRequest pokemonName) {
        return soapEndpoint.getPokemonId(pokemonName);
    }
    @Operation(summary = "Obtener LocationAreaEncounters del Pokémon desde el servicio SOAP")
    @GetMapping("/getPokemonLocationAreaEncounters")
    public GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(@RequestParam GetPokemonLocationAreaEncountersRequest pokemonName) {
        return soapEndpoint.getPokemonLocationAreaEncounters(pokemonName);
    }
}
