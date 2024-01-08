package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.api.PokemonApi
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

/**
 * Implementation of PokemonRepository that fetches Pokemon data from an API.
 * This class utilizes PokemonApi to retrieve Pokemon information by name or ID.
 */
class PokemonApiRepositoryImpl @Inject constructor(): PokemonRepository {
    /**
     * Retrieves a Pokemon by its name from the API.
     *
     * @param name The name of the Pokemon to retrieve.
     * @return The Pokemon object corresponding to the given name.
     */
    override suspend fun getPokemon(name: String): Pokemon {
        return PokemonApi.retrofitService.getPokemonByName(name)
    }


}
