package com.pokemon.soap.endpoint;

import com.pokemon.soap.*;
import com.pokemon.soap.service.IPokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class PokemonEndpoint {

    private static final String NAMESPACE_URI = "http://www.example.com/pokemon";

    @Autowired
    private IPokemonService pokemonService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonNameRequest")
    @ResponsePayload
    public GetPokemonNameResponse getPokemonName(@RequestPayload GetPokemonNameRequest request) {
        return pokemonService.getPokemonName(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonAbilitiesRequest")
    @ResponsePayload
    public GetPokemonAbilitiesResponse getPokemonAbilities(@RequestPayload GetPokemonAbilitiesRequest request) {
        return pokemonService.getPokemonAbilities(request);
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonBaseExperienceRequest")
    @ResponsePayload
    public GetPokemonBaseExperienceResponse getPokemonBaseExperience(@RequestPayload GetPokemonBaseExperienceRequest request) {
       return pokemonService.getPokemonBaseExperience(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonHeldItemsRequest")
    @ResponsePayload
    public GetPokemonHeldItemsResponse getPokemonHeldItems(@RequestPayload GetPokemonHeldItemsRequest request) {
        return pokemonService.getPokemonHeldItems(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonIdRequest")
    @ResponsePayload
    public GetPokemonIdResponse getPokemonId(@RequestPayload GetPokemonIdRequest request) {
        return pokemonService.getPokemonId(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonLocationAreaEncountersRequest")
    @ResponsePayload
    public GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(@RequestPayload GetPokemonLocationAreaEncountersRequest request) {
        return pokemonService.getPokemonLocationAreaEncounters(request);
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllRequest")
    @ResponsePayload
    public GetPokemonsResponse getAllRequest(@RequestPayload GetAllRequest request) {
        return pokemonService.getAllRequests();
    }
}
