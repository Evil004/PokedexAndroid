package com.oscar.pokedex.model

import androidx.compose.ui.res.painterResource
import com.google.gson.GsonBuilder
import com.oscar.pokedex.model.data.Pokemon
import com.oscar.pokedex.model.data.PokemonList


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



