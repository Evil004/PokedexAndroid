package com.oscar.pokedex.domain.repositories

import com.oscar.pokedex.domain.models.Pokemon

/**
 * Interface responsible for defining the repository of the Pokemon.
 */
interface PokemonRepository {
    /**
     * Retrieves Pokemon data by name.
     *
     * @param name The name of the Pokemon to retrieve.
     * @return The Pokemon object corresponding to the given name.
     */
    suspend fun getPokemon(name: String): Pokemon

    /**
     * Retrieves Pokemon data by ID.
     *
     * @param id The ID of the Pokemon to retrieve.
     * @return The Pokemon object corresponding to the given ID.
     */
    suspend fun getPokemon(id: Int): Pokemon

}