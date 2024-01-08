package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.local.PokemonFile
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

class PokemonListLocalRepositoryImpl @Inject constructor (val pokemonFile: PokemonFile):
    PokemonListRepository {
    override suspend fun getPokemonList(): PokemonList {
        val pokemonList = pokemonFile.getPokemonList()
        getPokemonSpritesURL(pokemonList)

        return pokemonList
    }

    override suspend fun getPokemonList(offset: Int): PokemonList {
        val pokemonList = PokemonList(offset, mutableListOf())
        return pokemonList;
    }


    private suspend fun getPokemonSpritesURL(pokemonList: PokemonList) {
        for (pokemonItem in pokemonList.list) {
            val pokemon = pokemonFile.getPokemonByName(name = pokemonItem.name)

            pokemonItem.spriteUrl = pokemon.spriteUrl
        }
    }
}