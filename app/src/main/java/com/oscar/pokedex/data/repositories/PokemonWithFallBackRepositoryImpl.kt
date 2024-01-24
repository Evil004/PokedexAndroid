package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonWithFallBackRepositoryImpl @Inject constructor(
    val pokemonLocalRepositoryImpl: PokemonLocalRepositoryImpl,
    val pokemonApiRepositoryImpl: PokemonApiRepositoryImpl,
) : PokemonRepository {

    override suspend fun getPokemon(name: String): Pokemon {
        val pokemon = try {
            pokemonApiRepositoryImpl.getPokemon(name)
        } catch (e: Exception) {
            pokemonLocalRepositoryImpl.getPokemon(name)
        }


        return pokemon
    }
}