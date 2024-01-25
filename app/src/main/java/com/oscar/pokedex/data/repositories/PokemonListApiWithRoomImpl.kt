package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

class PokemonListApiWithRoomImpl @Inject constructor(
    val pokemonListApiRepositoryImpl: PokemonListApiRepositoryImpl,
    val pokemonListRoomRepository: PokemonListRoomRepository,
    val appDatabase: AppDatabase
) : PokemonListRepository {

    override suspend fun getPokemonList(): PokemonList {
        val pokemonList = try {
            pokemonListApiRepositoryImpl.getPokemonList()
        } catch (e: Exception){
            pokemonListRoomRepository.getPokemonList()
        }

        return pokemonList
    }

    override suspend fun getPokemonList(start: Int): PokemonList {
        val pokemonList = try {
            pokemonListApiRepositoryImpl.getPokemonList(start)
        } catch (e: Exception){
            pokemonListRoomRepository.getPokemonList(start)
        }

        return pokemonList
    }
}