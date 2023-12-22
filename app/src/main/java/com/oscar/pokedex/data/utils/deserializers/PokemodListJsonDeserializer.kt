package com.oscar.pokedex.data.utils.deserializers;
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.models.PokemonListItem
import java.lang.reflect.Type


/**
 * Custom JSON deserializer for PokemonList objects.
 */
class PokemonListDeserializer : JsonDeserializer<PokemonList> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): PokemonList {

        val jsonObject = json.asJsonObject

        var next: String? = null;
        if (!jsonObject.get("next").isJsonNull){
            next = jsonObject.get("next").asString;

        }

        val pokemonJsonList = jsonObject.get("results").asJsonArray

        val pokemonListTmp = mutableListOf<PokemonListItem>()

        pokemonJsonList.forEach {
            pokemonListTmp.add(PokemonListItem(it.asJsonObject.get("name").asString))
        }

        return PokemonList(next, pokemonListTmp)

    }
}