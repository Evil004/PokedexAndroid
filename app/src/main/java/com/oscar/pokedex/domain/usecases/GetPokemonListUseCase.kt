package com.oscar.pokedex.domain.usecases

import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import javax.inject.Inject


class GetPokemonListUseCase @Inject constructor(
    private val repository: PokemonListRepository
) {
    suspend fun getPokemonList(): PokemonList {
        return repository.getPokemonList()
    }


}