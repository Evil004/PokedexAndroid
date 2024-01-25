package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.mappers.PokemonEntityToPokemonModelMapper
import com.oscar.pokedex.data.mappers.PokemonStatMapper
import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonApiWithRoomImpl @Inject constructor(
    val pokemonApiRepositoryImpl: PokemonApiRepositoryImpl,
    val pokemonRoomRepository: PokemonRoomRepository,
    val appDatabase: AppDatabase
) : PokemonRepository {

    override suspend fun getPokemon(name: String): Pokemon {

        val pokemon = try {

            pokemonRoomRepository.getPokemon(name)

        } catch (e: Exception) {

            val pokemonModel = pokemonApiRepositoryImpl.getPokemon(name)

            // Save the pokemon in the database
            appDatabase.pokemonDao().insert(PokemonEntityToPokemonModelMapper.map(pokemonModel))


            appDatabase.pokemonStatDao().insertBulk(
                PokemonStatMapper.map(
                    statsMap = pokemonModel.statsMap,
                    pokemon = pokemonModel
                )
            )


            pokemonModel
        }

        return pokemon
    }
}