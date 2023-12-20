package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.PokemonApi
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository

class PokemonApiRepositoryImpl : PokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
        return PokemonApi.retrofitService.getPokemonByName(name)
    }

    override suspend fun getPokemon(id: Int): Pokemon {
        return PokemonApi.retrofitService.getPokemonById(id)
    }
}
