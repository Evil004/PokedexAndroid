package com.oscar.pokedex.model.entity

data class PokemonList(
    val nextPokemonsUrl: String? = null,
    val list: MutableList<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val id: Int? = null,
    val spriteUrl: String? = null,
)