package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.api.PokemonApi
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonApiRepositoryImpl @Inject constructor(): PokemonRepository {

    override suspend fun getPokemon(name: String): Pokemon {
        return PokemonApi.retrofitService.getPokemonByName(name)
    }

    override suspend fun getPokemon(id: Int): Pokemon {
        return PokemonApi.retrofitService.getPokemonById(id)
    }

}
