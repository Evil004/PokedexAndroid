package com.oscar.pokedex.di

import com.oscar.pokedex.data.sources.local.PokemonFile
import com.oscar.pokedex.data.sources.local.PokemonLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonLocalModule {

    @Binds
    abstract fun bindPokemonLocalDataSource(
        analyticsServiceImpl: PokemonLocalDataSource
    ): PokemonFile
}
