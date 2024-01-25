package com.oscar.pokedex.data.repositories

import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject

class PokemonListWithFallBackRepositoryImpl @Inject constructor(
    val pokemonListLocalRepositoryImpl: PokemonListLocalRepositoryImpl,
    val pokemonListApiRepositoryImpl: PokemonListApiRepositoryImpl
) : PokemonListRepository {

    override suspend fun getPokemonList(): PokemonList {
        return try {
            pokemonListApiRepositoryImpl.getPokemonList()
        } catch (e: Exception) {
            pokemonListLocalRepositoryImpl.getPokemonList()
        }
    }


    override suspend fun getPokemonList(offset: Int): PokemonList {
        return try {
            pokemonListApiRepositoryImpl.getPokemonList(offset)
        } catch (e: Exception) {
            pokemonListLocalRepositoryImpl.getPokemonList(offset)
        }
    }
}