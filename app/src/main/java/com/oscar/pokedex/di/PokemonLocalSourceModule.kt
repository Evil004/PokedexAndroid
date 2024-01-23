package com.oscar.pokedex.di

import com.oscar.pokedex.data.sources.local.json.PokemonFile
import com.oscar.pokedex.data.sources.local.json.PokemonLocalDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonLocalSourceModule {

    @Binds
    abstract fun bindPokemonLocalDataSource(
        analyticsServiceImpl: PokemonLocalDataSource
    ): PokemonFile
}
