package com.oscar.pokedex.data.sources.local.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.data.sources.local.db.entity.PokemonStatEntity

data class PokemonWithStats (
    @Embedded val pokemon: PokemonEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "pokemon_id"
    )
    val stats: List<PokemonStatEntity>
)