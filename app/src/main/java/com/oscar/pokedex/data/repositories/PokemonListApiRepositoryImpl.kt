package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.api.PokemonApi
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

class PokemonListApiRepositoryImpl @Inject constructor(): PokemonListRepository {
    override suspend fun getPokemonList(): PokemonList {
        return PokemonApi.retrofitService.getPokemonList()
    }
}