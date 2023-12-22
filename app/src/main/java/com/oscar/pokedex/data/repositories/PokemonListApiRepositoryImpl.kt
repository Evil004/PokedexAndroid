package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.api.PokemonApi
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

/**
 * Implementation of PokemonListRepository that fetches a list of Pokemon from an API.
 * This class utilizes PokemonApi to retrieve a list of Pokemon.
 */
class PokemonListApiRepositoryImpl @Inject constructor(): PokemonListRepository {
    /**
     * Retrieves a list of Pokemon from the API.
     *
     * @return The PokemonList containing the list of Pokemon.
     */
    override suspend fun getPokemonList(): PokemonList {
        return PokemonApi.retrofitService.getPokemonList()
    }
}