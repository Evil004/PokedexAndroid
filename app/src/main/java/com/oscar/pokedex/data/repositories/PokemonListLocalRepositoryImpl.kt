package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.local.json.PokemonLocalSource
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListLocalRepositoryImpl @Inject constructor (val pokemonLocalSource: PokemonLocalSource):
    PokemonListRepository {
    override suspend fun getPokemonList(): PokemonList {
        val pokemonList = pokemonLocalSource.getPokemonList()
        getPokemonSpritesURL(pokemonList)

        return pokemonList
    }

    override suspend fun getPokemonList(offset: Int): PokemonList {
        val pokemonList = PokemonList(offset, mutableSetOf())
        return pokemonList;
    }


    private suspend fun getPokemonSpritesURL(pokemonList: PokemonList) {
        for (pokemonItem in pokemonList.list) {
            CoroutineScope(Dispatchers.IO).launch {
                val pokemon = pokemonLocalSource.getPokemonByName(name = pokemonItem.name)

                pokemonItem.speciesName = pokemon.speciesName
                pokemonItem.spriteUrl = pokemon.spriteUrl
            }
        }
    }
}