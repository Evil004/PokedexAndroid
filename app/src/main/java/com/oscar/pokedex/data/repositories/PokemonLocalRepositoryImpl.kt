package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.local.json.PokemonLocalSource
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonLocalRepositoryImpl @Inject constructor(val pokemonLocalSource: PokemonLocalSource) :
    PokemonRepository {
    override suspend fun getPokemon(name: String): Pokemon {
            val pokemon = pokemonLocalSource.getPokemonByName(name)

            return pokemon


    }

}