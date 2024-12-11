package com.pokemon.soap.repository;

import com.pokemon.soap.model.PokemonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPokemonRepository extends JpaRepository<PokemonModel, Integer> {
}