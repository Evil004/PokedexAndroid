package com.oscar.pokedex.domain.models


data class Pokemon(
    val id: Int,

    val name: String,

    val speciesName: String,

    val spriteUrl: String?,


    val primaryType: PokemonType,
    val secondaryType: PokemonType? = null,

    val weight: Float,
    val height: Float,

    var statsMap: Map<Stat, Int>,
)