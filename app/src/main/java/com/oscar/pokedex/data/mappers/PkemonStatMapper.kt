package com.oscar.pokedex.data.mappers

import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.data.sources.local.db.entity.PokemonStatEntity
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.Stat

object PokemonStatMapper {

    fun map(statsEntityList: List<PokemonStatEntity>): Map<Stat, Int> {

        val map = mutableMapOf<Stat, Int>()

        statsEntityList.forEach { pokemonStatEntity ->

            map[Stat.valueOf(pokemonStatEntity.statName)] = pokemonStatEntity.value
        }

        return map

    }

    fun map(statsMap: Map<Stat, Int>, pokemonEntity: PokemonEntity): List<PokemonStatEntity> {

        val list = mutableListOf<PokemonStatEntity>()

        statsMap.forEach { stat, value ->

            list.add(PokemonStatEntity(pokemonEntity.id, stat.name, value))
        }

        return list
    }

    fun map(statsMap: Map<Stat, Int>, pokemon: Pokemon): List<PokemonStatEntity> {

        val list = mutableListOf<PokemonStatEntity>()

        statsMap.forEach { stat, value ->

            list.add(PokemonStatEntity(pokemon.id, stat.name, value))
        }

        return list
    }

}