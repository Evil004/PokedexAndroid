package com.oscar.pokedex.data.sources.local

import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList

interface PokemonFile {
    suspend fun getPokemonByName(name: String): Pokemon

    suspend fun getPokemonList(): PokemonList
}