package com.oscar.pokedex.data.sources.local.json

import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList

interface PokemonLocalSource {
    suspend fun getPokemonByName(name: String): Pokemon

    suspend fun getPokemonList(): PokemonList
}