package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.mappers.PokemonEntityToPokemonModelMapper
import com.oscar.pokedex.data.mappers.PokemonStatMapper
import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonRoomRepository @Inject constructor(val appDatabase: AppDatabase): PokemonRepository{
    override suspend fun getPokemon(name: String): Pokemon {

        val pokemonEntity = appDatabase.pokemonDao().findByName(name)

        val pokemonStats = appDatabase.pokemonStatDao().getStatsOfPokemon(pokemonEntity.id)

        val pokemon = PokemonEntityToPokemonModelMapper.map(pokemonEntity)
        pokemon.statsMap = PokemonStatMapper.map(pokemonStats)

        return pokemon
    }
}