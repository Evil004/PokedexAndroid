package com.oscar.pokedex.data.mappers


import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonType

object PokemonEntityModelMapper {

    fun map(pokemon: PokemonEntity): Pokemon {
        return Pokemon(
            name = pokemon.name,
            speciesName = pokemon.speciesName,
            spriteUrl = pokemon.spriteUrl,
            id = pokemon.id,
            primaryType = PokemonType.DARK,
            statsMap = mapOf(),
            height = 0.0f,
            weight = 0.0f)
    }

    fun map(pokemon: Pokemon): PokemonEntity {
        return PokemonEntity(
            name = pokemon.name,
            speciesName = pokemon.speciesName,
            spriteUrl = pokemon.spriteUrl,
            id = pokemon.id)
    }

}