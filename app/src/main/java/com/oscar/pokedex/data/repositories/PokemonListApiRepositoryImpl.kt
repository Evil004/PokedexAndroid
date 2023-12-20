package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.PokemonApi
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository

class PokemonListApiRepositoryImpl: PokemonListRepository {
    override suspend fun getPokemonList(): PokemonList {
        return PokemonApi.retrofitService.getPokemonList()
    }
}