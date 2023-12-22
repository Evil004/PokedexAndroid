package com.oscar.pokedex.data.sources.remote.api

import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val DEFAULT_LIMIT = 21

interface PokemonApiService {
    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): Pokemon

    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon/{id}")
    suspend fun getPokemonById(@Path("id") id: Int): Pokemon

    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = DEFAULT_LIMIT
    ): PokemonList
}

