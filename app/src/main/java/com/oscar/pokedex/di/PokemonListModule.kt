package com.oscar.pokedex.di

import com.oscar.pokedex.data.repositories.PokemonListApiWithRoomImpl
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
        pokemonListRepository: PokemonListApiWithRoomImpl
    ): PokemonListRepository

}

