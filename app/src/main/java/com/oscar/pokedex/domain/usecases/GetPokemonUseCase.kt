package com.oscar.pokedex.domain.usecases

import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.repositories.PokemonRepository
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    suspend fun getPokemon(name: String): Pokemon {
        return repository.getPokemon(name)
    }

    suspend fun getPokemon(id: Int): Pokemon {
        return repository.getPokemon(id)
    }
}