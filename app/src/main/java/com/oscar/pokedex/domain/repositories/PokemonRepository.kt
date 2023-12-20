package com.oscar.pokedex.domain.repositories

import com.oscar.pokedex.domain.models.Pokemon

interface PokemonRepository{
    suspend fun getPokemon(name: String): Pokemon
    suspend fun getPokemon(id: Int): Pokemon

}