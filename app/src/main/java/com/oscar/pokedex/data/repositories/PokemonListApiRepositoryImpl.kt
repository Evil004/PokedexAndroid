package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.remote.api.PokemonApiService
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Implementation of PokemonListRepository that fetches a list of Pokemon from an API.
 * This class utilizes PokemonApi to retrieve a list of Pokemon.
 */
class PokemonListApiRepositoryImpl @Inject constructor(
    val pokemonApi: PokemonApiService

): PokemonListRepository {
    /**
     * Retrieves a list of Pokemon from the API.
     *
     * @return The PokemonList containing the list of Pokemon.
     */
    override suspend fun getPokemonList(): PokemonList {
        val pokemonList = pokemonApi.getPokemonList()

        getPokemonExtraData(pokemonList)

        return pokemonList

    }

    override suspend fun getPokemonList(start: Int): PokemonList {

        val pokemonList = pokemonApi.getPokemonList(start)

        getPokemonExtraData(pokemonList)

        return pokemonList
    }

    private suspend fun getPokemonExtraData(pokemonList: PokemonList) {
        for (pokemonItem in pokemonList.list) {

            CoroutineScope(Dispatchers.IO).launch {
                val pokemon = pokemonApi.getPokemonByName(name = pokemonItem.name)

                pokemonItem.speciesName = pokemon.speciesName
                pokemonItem.spriteUrl = pokemon.spriteUrl
            }

        }
    }
}