package com.oscar.pokedex.model;
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.oscar.pokedex.model.data.PokemonList
import java.lang.reflect.Type


class PokemonListDeserializer : JsonDeserializer<PokemonList> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): PokemonList {

        val jsonObject = json.asJsonObject

        val next = jsonObject.get("next").asString;

        val pokemonJsonList = jsonObject.get("results").asJsonArray

        val pokemonListTmp = mutableListOf<String>()

        pokemonJsonList.forEach {
            pokemonListTmp.add(it.asJsonObject.get("name").asString)
        }

        return PokemonList(next, pokemonListTmp)

    }
}