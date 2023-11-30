package com.oscar.pokedex.model

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

public interface PokemonApiService {
    @Headers(
        "Accept: application/json"  
    )  
    @GET("pokemon/{name}")
    suspend fun getPokemonByName(@Path("name") name: String): String

}

object PokemonApi{
    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val retrofitService : PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)

    }

}