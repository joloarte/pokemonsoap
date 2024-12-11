package com.pokemon.soap.service;

import com.pokemon.soap.GetPokemonNameRequest;
import com.pokemon.soap.GetPokemonNameResponse;
import com.pokemon.soap.repository.IPokemonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.reactive.function.client.WebClient;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class IPokemonServiceTest {

    @InjectMocks
    private PokemonService service;
    @Mock
    private IPokemonRepository repository;

    @Mock
    private WebClient client;

    @Test
    void getPokemonName() {
        GetPokemonNameRequest request = new GetPokemonNameRequest();
        request.setPokemonName("bulbasaur");
        GetPokemonNameResponse response = service.getPokemonName(request);
        Assertions.assertNotNull(response);
    }

}