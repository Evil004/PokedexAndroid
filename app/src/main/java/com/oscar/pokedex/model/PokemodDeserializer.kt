package com.oscar.pokedex.model;
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.oscar.pokedex.model.data.Pokemon
import com.oscar.pokedex.model.data.PokemonType
import com.oscar.pokedex.model.data.Stat
import java.lang.reflect.Type


class PokemonDeserializer : JsonDeserializer<Pokemon> {
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext?
    ): Pokemon {

        val jsonObject = json.asJsonObject


        val id = jsonObject.get("id").asInt
        val name = jsonObject.get("name").asString
        val weight = jsonObject.get("weight").asFloat / 10
        val height = jsonObject.get("height").asFloat / 10

        val spriteUrl = getSpriteUrl(jsonObject)


        val statMap = getStatsMap(jsonObject)

        val typesTmp = jsonObject.get("types").asJsonArray;

        var primaryType: PokemonType = PokemonType.NORMAL;
        var secondaryType: PokemonType? = null;

        for (type in typesTmp) {
            val typeObject = type.asJsonObject;
            val typeSlot = typeObject.get("slot").asInt

            if (typeSlot == 1) {
                primaryType = getTypeFromJsonObject(typeObject)
            }
            if (typeSlot == 2) {
                secondaryType = getTypeFromJsonObject(typeObject)
            }
        }

        return Pokemon(
            id = id,
            name = name,
            statsMap = statMap,
            weight = weight,
            height = height,
            primaryType = primaryType,
            secondaryType = secondaryType,
            spriteUrl = spriteUrl
        )

    }

    private fun getStatsMap(jsonObject: JsonObject): MutableMap<Stat, Int> {
        val statMap = mutableMapOf<Stat, Int>()

        val statsTmp = jsonObject.get("stats").asJsonArray

        statsTmp.forEach() {
            val statJsonObject = it.asJsonObject

            val baseStat = statJsonObject.get("base_stat").asInt
            val statName = statJsonObject.get("stat").asJsonObject.get("name").asString


            statMap.put(Stat.getStat(jsonName = statName), baseStat)

        }
        return statMap
    }

    private fun getSpriteUrl(jsonObject: JsonObject): String {
        val sprite = jsonObject.get("sprites").asJsonObject
            .get("other").asJsonObject
            .get("official-artwork").asJsonObject
            .get("front_default").asString
        return sprite
    }

    private fun getTypeFromJsonObject(typeObj: JsonObject): PokemonType {
        val typeString = typeObj.get("type").asJsonObject.get("name").asString

        return PokemonType.valueOf(typeString.uppercase())
    }
}