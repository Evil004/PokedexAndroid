package com.oscar.pokedex.model.data

data class PokemonList(
    val nextPokemonsUrl: String,
    val list: MutableList<String>
)