package com.oscar.pokedex.model.data


data class Pokemon(
    val id: Int,

    val name: String,

    val spriteUrl: String,


    val primaryType: PokemonType,
    val secondaryType: PokemonType? = null,

    val weight: Float,
    val height: Float,

    val statsMap: Map<Stat, Int>,
)