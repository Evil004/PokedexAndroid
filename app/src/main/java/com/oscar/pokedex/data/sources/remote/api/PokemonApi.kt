package com.oscar.pokedex.data.sources.remote.api
import com.google.gson.GsonBuilder
import com.oscar.pokedex.data.utils.deserializers.PokemonDeserializer
import com.oscar.pokedex.data.utils.deserializers.PokemonListDeserializer
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PokemonApi {

    val gson = GsonBuilder()
        .registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
        .registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
        .create()

    val retrofit = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/api/v2/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    val retrofitService: PokemonApiService by lazy {
        retrofit.create(PokemonApiService::class.java)

    }

}