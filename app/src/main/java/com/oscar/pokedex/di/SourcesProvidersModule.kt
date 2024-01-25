package com.oscar.pokedex.di

import android.content.Context
import androidx.room.Room
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.oscar.pokedex.data.sources.local.db.AppDatabase
import com.oscar.pokedex.data.sources.local.json.PokemonLocalSource
import com.oscar.pokedex.data.sources.local.json.PokemonLocalDataSource

import com.oscar.pokedex.data.sources.remote.api.PokemonApiService
import com.oscar.pokedex.data.utils.deserializers.PokemonDeserializer
import com.oscar.pokedex.data.utils.deserializers.PokemonListDeserializer
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SourcesProvidersModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).build(
        )
    }

    @Provides
    fun provideGson(): Gson {
        return GsonBuilder()
            .registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
            .registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
            .create()
    }

    @Provides
    fun provideRetrofit(gson: Gson): Retrofit{
        return Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApiService {
        return retrofit.create(PokemonApiService::class.java)
    }

    @Provides
    fun bindPokemonLocalDataSource(
        localSource: PokemonLocalDataSource
    ): PokemonLocalSource {
        return localSource
    }
}

