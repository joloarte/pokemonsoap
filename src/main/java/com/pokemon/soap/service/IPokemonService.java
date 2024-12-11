package com.pokemon.soap.service;

import com.pokemon.soap.*;

public interface IPokemonService {

    GetPokemonNameResponse getPokemonName(GetPokemonNameRequest request);
    GetPokemonAbilitiesResponse getPokemonAbilities(GetPokemonAbilitiesRequest request);
    GetPokemonBaseExperienceResponse getPokemonBaseExperience(GetPokemonBaseExperienceRequest request);
    GetPokemonHeldItemsResponse getPokemonHeldItems(GetPokemonHeldItemsRequest request);
    GetPokemonIdResponse getPokemonId(GetPokemonIdRequest request);
    GetPokemonLocationAreaEncountersResponse getPokemonLocationAreaEncounters(GetPokemonLocationAreaEncountersRequest request);
    GetPokemonsResponse getAllRequests();
}
