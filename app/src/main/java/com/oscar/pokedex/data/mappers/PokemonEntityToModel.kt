package com.oscar.pokedex.data.mappers


import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.data.sources.local.db.entity.PokemonStatEntity
import com.oscar.pokedex.data.sources.local.db.relations.PokemonWithStats
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonType
import com.oscar.pokedex.domain.models.Stat

object PokemonEntityToPokemonModelMapper {

    fun map(pokemon: PokemonEntity): Pokemon {

        val name = pokemon.name
        val speciesName = pokemon.speciesName
        val spriteUrl = pokemon.spriteUrl
        val id = pokemon.id
        val primaryType = PokemonType.valueOf(pokemon.primaryType)
        val seconddaryType = pokemon.secondaryType?.let { PokemonType.valueOf(it) }


        val statMap = mutableMapOf<Stat, Int>()
        Stat.entries.forEach { stat ->
            statMap[stat] = 0
        }

        val height = pokemon.height
        val weight = pokemon.weight


        return Pokemon(
            name = name,
            speciesName = speciesName,
            spriteUrl = spriteUrl,
            id = id,
            primaryType = primaryType,
            secondaryType = seconddaryType,
            statsMap = statMap,
            height = height,
            weight = weight
        )
    }

    fun map(pokemon: Pokemon): PokemonEntity {

        val name = pokemon.name
        val speciesName = pokemon.speciesName
        val spriteUrl = pokemon.spriteUrl
        val id = pokemon.id
        val primaryType = pokemon.primaryType.name
        val secondaryType = pokemon.secondaryType?.name
        val height = pokemon.height
        val weight = pokemon.weight

        return PokemonEntity(
            name = name,
            speciesName = speciesName,
            spriteUrl = spriteUrl,
            id = id,
            primaryType = primaryType,
            secondaryType = secondaryType,
            height = height,
            weight = weight
        )


    }

}