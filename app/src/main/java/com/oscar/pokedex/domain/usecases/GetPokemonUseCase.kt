package com.oscar.pokedex.domain.usecases

import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject


/**
 * Use case class responsible for retrieving Pokémon data.
 *
 * @property repository The PokemonRepository used to fetch Pokemon data.
 */
class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    /**
     * Retrieves Pokemon data by name.
     *
     * @param name The name of the Pokemon to retrieve.
     * @return The Pokemon object corresponding to the given name.
     */
    suspend fun getPokemon(name: String): Pokemon {
        return repository.getPokemon(name)
    }

}