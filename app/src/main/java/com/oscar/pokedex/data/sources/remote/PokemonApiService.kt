package com.oscar.pokedex.data.sources.remote

import com.google.gson.GsonBuilder
import com.oscar.pokedex.data.mappers.PokemonDeserializer
import com.oscar.pokedex.data.mappers.PokemonListDeserializer
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val DEFAULT_LIMIT = 30;

public interface PokemonApiService {
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
    suspend fun getPokemonList(@Query("offset")offset: Int=0, @Query("limit") limit: Int = DEFAULT_LIMIT): PokemonList
}

object PokemonApi{
    val gson = GsonBuilder()
        .registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
        .registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val retrofitService : PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)

    }

}