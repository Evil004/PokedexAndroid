package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.local.PokemonFile
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonLocalRepositoryImpl @Inject constructor (val pokemonFile: PokemonFile): PokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
            val pokemon = pokemonFile.getPokemonByName(name)

            return pokemon


    }

}