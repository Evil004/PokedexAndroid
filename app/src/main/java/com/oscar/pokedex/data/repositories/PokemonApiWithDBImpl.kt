package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.mappers.PokemonEntityModelMapper
import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonApiWithDBImpl @Inject constructor(
    val pokemonApiRepositoryImpl: PokemonApiRepositoryImpl,
    val appDatabase: AppDatabase
) : PokemonRepository {

    override suspend fun getPokemon(name: String): Pokemon {
        val pokemon = try {
            val pokemonEntity = appDatabase.pokemonDao().findByName(name)

            PokemonEntityModelMapper.map(pokemonEntity)

        } catch (e: Exception) {
            val pokemonModel = pokemonApiRepositoryImpl.getPokemon(name)


            // Save the pokemon in the database
            try {
                appDatabase.pokemonDao().insert(PokemonEntityModelMapper.map(pokemonModel))

            } catch (e: Exception) {
                // Do nothing
            }

            pokemonModel
        }


        return pokemon
    }
}