package com.oscar.pokedex.domain.models

data class PokemonList(
    var offset: Int? = null,
    val list: MutableList<PokemonListItem>
)

data class PokemonListItem(
    val name: String,
    val id: Int? = null,
    var spriteUrl: String? = null,
)