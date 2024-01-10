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

        var offset: Int? = null;
        if (!jsonObject.get("next").isJsonNull){
            val next = jsonObject.get("next").asString;
            offset = getOffset(next)

        }

        val pokemonJsonList = jsonObject.get("results").asJsonArray

        val pokemonListTmp = mutableListOf<PokemonListItem>()


        pokemonJsonList.forEach {
            val  name = it.asJsonObject.get("name").asString;


            pokemonListTmp.add(PokemonListItem(name = name));
        }


        return PokemonList(offset, pokemonListTmp)

    }

    fun getOffset (nextUrl: String): Int?{
        val regex = Regex("offset=(\\d+)")
        val matchResult = regex.find(nextUrl)

        val offset = matchResult?.groupValues?.get(1)

        if (offset != null) {
            return offset.toInt()
        } else {
            return null;
        }
    }


}