package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.local.json.PokemonFile
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class PokemonListLocalRepositoryImpl @Inject constructor (val pokemonFile: PokemonFile):
    PokemonListRepository {
    override suspend fun getPokemonList(): PokemonList {
        val pokemonList = pokemonFile.getPokemonList()
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
                val pokemon = pokemonFile.getPokemonByName(name = pokemonItem.name)

                pokemonItem.speciesName = pokemon.speciesName
                pokemonItem.spriteUrl = pokemon.spriteUrl
            }
        }
    }
}