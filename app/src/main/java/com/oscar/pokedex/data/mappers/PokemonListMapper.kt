package com.oscar.pokedex.data.mappers

import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.models.PokemonListItem

object PokemonListMapper {

    fun map(pokemonEntityList: List<PokemonEntity>): PokemonList {
        val pokemonListItems: MutableSet<PokemonListItem> = pokemonEntityList.map { pokemonEntity ->
            PokemonListItem(
                name = pokemonEntity.name,
                spriteUrl = pokemonEntity.spriteUrl,
                speciesName = pokemonEntity.speciesName
            )
        }.toMutableSet()


        return PokemonList(list = pokemonListItems)
    }

}