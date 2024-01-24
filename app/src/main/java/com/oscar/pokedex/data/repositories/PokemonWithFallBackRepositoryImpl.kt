package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.mappers.PokemonEntityModelMapper
import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonType
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