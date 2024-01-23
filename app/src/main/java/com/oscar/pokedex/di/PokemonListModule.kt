package com.oscar.pokedex.di

import com.oscar.pokedex.data.repositories.PokemonListApiRepositoryImpl
import com.oscar.pokedex.data.repositories.PokemonListLocalRepositoryImpl
import com.oscar.pokedex.data.repositories.PokemonListWithFallBackRepositoryImpl
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonListApiModule {

    @Binds
    abstract fun bindPokemonListRepository(
        pokemonListRepository: PokemonListWithFallBackRepositoryImpl
    ): PokemonListRepository

}

/*
@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonListLocalModule {

    @Binds
    abstract fun bindPokemonListRepository(
        pokemonListRepository: PokemonListLocalRepositoryImpl
    ): PokemonListRepository

}*/
