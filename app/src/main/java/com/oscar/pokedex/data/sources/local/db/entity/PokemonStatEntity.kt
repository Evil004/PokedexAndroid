package com.oscar.pokedex.data.sources.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "pokemon_stat",
    foreignKeys = arrayOf(
        ForeignKey(
            entity = PokemonEntity::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("pokemon_id"),
            onDelete = ForeignKey.CASCADE
        )
    ),
    primaryKeys = arrayOf("pokemon_id", "stat_name")
)
data class PokemonStatEntity(
    @ColumnInfo(name = "pokemon_id") val pokemonId: Int,
    @ColumnInfo(name = "stat_name") val statName: String,
    @ColumnInfo(name = "value") val value: Int,

    )