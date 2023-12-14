package com.oscar.pokedex.data.models

import com.google.gson.GsonBuilder
import com.oscar.pokedex.data.models.entity.Pokemon
import com.oscar.pokedex.data.models.entity.PokemonList


fun parseJsonToPokemon(json: String): Pokemon {
    val gsonBuilder = GsonBuilder();

    gsonBuilder.registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())

    val gson = gsonBuilder.create();

    return gson.fromJson(json, Pokemon::class.java)
}
fun parseJsonListToPokemon(json: String): PokemonList {

    val gsonBuilder = GsonBuilder();
    gsonBuilder.registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
    val gson = gsonBuilder.create();
    return gson.fromJson(json, PokemonList::class.java)

}



