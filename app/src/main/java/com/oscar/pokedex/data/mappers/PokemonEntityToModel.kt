package com.oscar.pokedex.data.mappers


import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonType
import com.oscar.pokedex.domain.models.Stat

object PokemonEntityModelMapper {

    fun map(pokemon: PokemonEntity): Pokemon {

        var statMap = mapOf<Stat, Int>()

        Stat.entries.forEach {
            statMap = statMap.plus(Pair(it, 0))
        }

        return Pokemon(
            name = pokemon.name,
            speciesName = pokemon.speciesName,
            spriteUrl = pokemon.spriteUrl,
            id = pokemon.id,
            primaryType = PokemonType.valueOf(pokemon.primaryType),
            statsMap = statMap,
            height = 0.0f,
            weight = 0.0f
        )
    }

    fun map(pokemon: Pokemon): PokemonEntity {


        return PokemonEntity(
            name = pokemon.name,
            speciesName = pokemon.speciesName,
            spriteUrl = pokemon.spriteUrl,
            id = pokemon.id,
            primaryType = PokemonType.DARK.name,
            height = 0.0f,
            weight = 0.0f,
            secondaryType = null
        )
    }

}