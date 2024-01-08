package com.oscar.pokedex.di

import com.oscar.pokedex.data.repositories.PokemonApiRepositoryImpl
import com.oscar.pokedex.data.repositories.PokemonLocalRepositoryImpl
import com.oscar.pokedex.domain.repositories.PokemonRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonModule {

    @Binds
    abstract fun bindPokemonRepository(
        analyticsServiceImpl: PokemonApiRepositoryImpl
    ): PokemonRepository
}