package com.pokemon.soap.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.pokemon.soap.*;
import com.pokemon.soap.model.PokemonModel;
import com.pokemon.soap.repository.IPokemonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class PokemonService implements IPokemonService{

    @Autowired
    private WebClient webClient;

    @Autowired
    private IPokemonRepository repository;
    private String urlName;

    @Override
    public GetPokemonNameResponse getPokemonName(GetPokemonNameRequest request) {
        log.info("getPokemonName");
        long start = System.currentTimeMillis();
        GetPokemonNameResponse nameResponse = new GetPokemonNameResponse();
        urlName = "pokemon/".concat(request.getPokemonName());
       JsonNode response = fetchPokemon(urlName);
        JsonNode nameNode = response.get("name");
        log.info("node: "+nameNode);
        nameResponse.setResponse(nameNode.toString());
        saveRequestPokemonApi(urlName,request.toString(),nameResponse.toString(),System.currentTimeMillis() - start);
        return nameResponse;
    }

    @Override
    public GetPokemonAbilitiesResponse getPokemonAbilities(GetPokemonAbilitiesRequest request) {
        log.info("getPokemonAbilities");
        long start = System.currentTimeMillis();
        GetPokemonAbilitiesResponse abilitiesResponse = new GetPokemonAbilitiesResponse();
        urlName = "pokemon/".concat(request.getPokemonName());
        JsonNode response = fetchPokemon(urlName);
        JsonNode abilitiesNode = response.get("abilities");
        abilitiesResponse.setResponse(abilitiesNode.toString());
        saveRequestPokemonApi(urlName,request.toString(),abilitiesResponse.toString(),System.currentTimeMillis() - start);
        return abilitiesResponse;
    }

    @Override
    public GetPokemonBaseExperienceResponse getPokemonBaseExperience(GetPokemonBaseExperienceRequest request) {
        log.info("getPokemonBaseExperience");
        long start = System.currentTimeMillis();
        GetPokemonBaseExperienceResponse experienceResponse = new GetPokemonBaseExperienceResponse();
        urlName = "pokemon/".concat(request.getPokemonName());
        JsonNode response = fetchPokemon(urlName);
        JsonNode experienceNode = response.get("base_experience");
        experienceResponse.setResponse(experienceNode.toString());
        saveRequestPokemonApi(urlName,request.toString(),experienceResponse.toString(),System.currentTimeMillis() - start);
        return experienceResponse;
    }

    @Override
    public GetPokemonHeldItemsResponse getPokemonHeldItems(GetPokemonHeldItemsRequest request) {
        log.info("getPokemonHeldItems");
        long start = System.currentTimeMillis();
        GetPokemonHeldItemsResponse itemsResponse = new GetPokemonHeldItemsResponse();
        urlName = "pokemon/".concat(request.getPokemonName());
        JsonNode response = fetchPokemon(urlName);
        JsonNode itemsNode = response.get("held_items");
        itemsResponse.setResponse(itemsNode.toString());
        saveRequestPokemonApi(urlName,request.toString(),itemsResponse.toString(),System.currentTimeMillis() - start);
        return itemsResponse;
    }

    @Override
    public GetPokemonIdResponse getPokemonId(GetPokemonIdRequest request) {
        log.info("getPokemonId");
        long start = System.currentTimeMillis();
        GetPokemonIdResponse idResponse = new GetPokemonIdResponse();
        urlName = "pokemon/".concat(request.getPokemonName());
        JsonNode response = fetchPokemon(urlName);
        JsonNode idNode = response.get("id");
        idResponse.setResponse(idNode.toString());
        saveRequestPokemonApi(urlName,request.toString(),idResponse.toString(),System.currentTimeMillis() - start);
        return idResponse;
    }

    @Override
    public GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(GetPokemonLocationAreaEncountersRequest request) {
        log.info("getPokemonLocationAreaEncounters");
        long start = System.currentTimeMillis();
        GetPokemonLocationAreaEncountersResponse locationResponse = new GetPokemonLocationAreaEncountersResponse();
        urlName = "pokemon/".concat(request.getPokemonName()).concat("/encounters");
        JsonNode response = fetchPokemon(urlName);
        locationResponse.setResponse(response.toString());
        saveRequestPokemonApi(urlName,request.toString(),locationResponse.toString(),System.currentTimeMillis() - start);
        return locationResponse;
    }

    @Override
    public GetPokemonsResponse getAllRequests() {
        log.info("getAllRequests");
        GetPokemonsResponse response = new GetPokemonsResponse();
       List<PokemonModel> listRequest = repository.findAll();
        return (GetPokemonsResponse) listRequest;
    }
    private JsonNode fetchPokemon(String name) {
        log.info("fetchPokemon");
        return webClient.get().uri(name).retrieve().bodyToMono(JsonNode.class).block();
    }

    private void saveRequestPokemonApi(String method, String request, String response, long duration){
        log.info("saveRequestPokemonApi");
        PokemonModel pokemonModel = new PokemonModel();
        pokemonModel.setIp(getClientIp());
        pokemonModel.setMethod(method);
        pokemonModel.setDateRequest(LocalDateTime.now());
        pokemonModel.setDuration(duration);
        pokemonModel.setRequest(request);
        pokemonModel.setResponse(response);
        repository.save(pokemonModel);
    }
    private String getClientIp() {
        return "127.0.0.1"; // Placeholder
    }
}
