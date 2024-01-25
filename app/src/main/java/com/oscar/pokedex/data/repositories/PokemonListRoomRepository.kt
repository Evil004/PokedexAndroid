package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.mappers.PokemonEntityToPokemonModelMapper
import com.oscar.pokedex.data.mappers.PokemonListMapper
import com.oscar.pokedex.data.mappers.PokemonStatMapper
import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class PokemonListRoomRepository @Inject constructor(val appDatabase: AppDatabase): PokemonListRepository{
    /*override suspend fun getPokemon(name: String): PokemonList {

        val pokemonEntity = appDatabase.pokemonDao().findByName(name)

        val pokemonStats = appDatabase.pokemonStatDao().getStatsOfPokemon(pokemonEntity.id)

        val pokemon = PokemonEntityToPokemonModelMapper.map(pokemonEntity)
        pokemon.statsMap = PokemonStatMapper.map(pokemonStats)

        return pokemon
    }*/

    override suspend fun getPokemonList(): PokemonList {

        val pokemonEntityList = appDatabase.pokemonDao().findPokemons()
        println("PokemonListRoomRepository.getPokemonList()")

        return PokemonListMapper.map(pokemonEntityList)

    }

    override suspend fun getPokemonList(start: Int): PokemonList {
        val pokemonEntityList = appDatabase.pokemonDao().findPokemons(offset = start)
        println("PokemonListRoomRepository.getPokemonList(start: Int)")


        return PokemonListMapper.map(pokemonEntityList)
    }
}