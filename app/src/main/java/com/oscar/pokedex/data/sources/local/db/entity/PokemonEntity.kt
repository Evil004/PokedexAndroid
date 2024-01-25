package com.oscar.pokedex.data.sources.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
class PokemonEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "species_name") val speciesName: String,
    @ColumnInfo(name = "sprite_url") val spriteUrl: String?,
    @ColumnInfo(name = "weight") val weight: Float,
    @ColumnInfo(name = "height") val height: Float,
    @ColumnInfo(name = "primary_type") val primaryType: String,
    @ColumnInfo(name = "secondary_type") val secondaryType: String?,
)