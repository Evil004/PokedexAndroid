package com.oscar.pokedex.di

import com.oscar.pokedex.data.repositories.PokemonApiWithRoomImpl
import com.oscar.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonApiModule {

    @Binds
    abstract fun bindPokemonRepository(
        analyticsServiceImpl: PokemonApiWithRoomImpl
    ): PokemonRepository
}

/*
@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonLocalModule {

    @Binds
    abstract fun bindPokemonRepository(
        analyticsServiceImpl: PokemonLocalRepositoryImpl
    ): PokemonRepository
}*/
