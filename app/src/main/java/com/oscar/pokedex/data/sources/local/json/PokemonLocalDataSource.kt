package com.oscar.pokedex.data.sources.local.json

import android.content.Context
import com.google.gson.GsonBuilder
import com.oscar.pokedex.data.utils.deserializers.PokemonDeserializer
import com.oscar.pokedex.data.utils.deserializers.PokemonListDeserializer
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.InputStream
import javax.inject.Inject

class PokemonLocalDataSource @Inject constructor (@ApplicationContext val context: Context) :
    PokemonFile
{

    private val gson = GsonBuilder()
        .registerTypeAdapter(Pokemon::class.java, PokemonDeserializer())
        .registerTypeAdapter(PokemonList::class.java, PokemonListDeserializer())
        .create()
    override suspend fun getPokemonByName(name: String): Pokemon {
        val name = name.replace('-', '_')
        val file = context.assets.open("json/$name.json")
        val json = getJsonStringFromInputStream(file)

        return  gson.fromJson(json, Pokemon::class.java)
    }

    override suspend fun getPokemonList(): PokemonList {

        val file = context.assets.open("json/list.json")
        val json = getJsonStringFromInputStream(file)

        return  gson.fromJson(json, PokemonList::class.java)

    }



    private fun getJsonStringFromInputStream(fileInputStream: InputStream): String {
        val size = fileInputStream.available()
        val buffer = ByteArray(size)
        fileInputStream.read(buffer)

        val json = String(buffer)
        return json
    }
}
