package com.oscar.pokedex.model.api

import com.oscar.pokedex.model.data.Pokemon
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
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
    suspend fun getPokemonByName(@Path("name") name: String): String


    @Headers(
        "Accept: application/json"
    )
    @GET("pokemon")
    suspend fun getPokemonList(@Query("offset")offset: Int=0, @Query("limit") limit: Int = DEFAULT_LIMIT): String
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