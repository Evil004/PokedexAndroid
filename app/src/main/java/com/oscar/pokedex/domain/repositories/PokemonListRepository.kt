package com.oscar.pokedex.domain.repositories

import com.oscar.pokedex.domain.models.PokemonList

interface PokemonListRepository {
    suspend fun getPokemonList(): PokemonList
}