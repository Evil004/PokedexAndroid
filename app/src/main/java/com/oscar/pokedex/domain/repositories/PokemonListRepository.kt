package com.oscar.pokedex.domain.repositories

import com.oscar.pokedex.domain.models.PokemonList

/**
 * Interface responsible for defining the repository of the PokemonList.
 */
interface PokemonListRepository {
    /**
     * Retrieves a list of Pokemon.
     *
     * @return The PokemonList containing the list of Pokemon.
     */
    suspend fun getPokemonList(): PokemonList

    suspend fun getPokemonList(start: Int): PokemonList

}