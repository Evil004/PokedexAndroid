package com.oscar.pokedex.domain.usecases

import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

/**
 * Use case class responsible for retrieving a list of Pokémon.
 *
 * @property repository The PokemonListRepository used to fetch the list of Pokémon.
 */
class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonListRepository
) {
    /**
     * Retrieves a list of Pokémon.
     *
     * @return The PokemonList containing the list of Pokémon.
     */
    suspend fun getPokemonList(): PokemonList {
        return repository.getPokemonList()
    }


}