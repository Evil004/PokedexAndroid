package com.oscar.pokedex.domain.usecases

import com.oscar.pokedex.data.repositories.PokemonListLocalRepositoryImpl
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

/**
 * Use case class responsible for retrieving a list of Pokémon.
 *
 * @property repository The PokemonListRepository used to fetch the list of Pokémon.
 */
class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonListRepository,
) {
    /**
     * Retrieves a list of Pokémon.
     *
     * @return The PokemonList containing the list of Pokémon.
     */
    suspend fun getPokemonList(): PokemonList {
        return repository.getPokemonList()
    }

    /**
     * Expands the list of Pokémon.
     *
     * @param pokemonList The PokemonList to expand.
     */

    suspend fun expandPokemonList(pokemonList: PokemonList): PokemonList {
        try {
            val returnList = pokemonList.copy()

            if (returnList.offset == null) {
                return returnList
            }

            val newList = repository.getPokemonList(pokemonList.offset!!)

            returnList.list.addAll(newList.list)

            returnList.offset = newList.offset
            return returnList
        } catch (e: Exception) {
            return pokemonList
        }

    }


}