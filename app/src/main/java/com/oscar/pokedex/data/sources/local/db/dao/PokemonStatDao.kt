package com.oscar.pokedex.data.sources.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.oscar.pokedex.data.sources.local.db.entity.PokemonStatEntity

@Dao
interface PokemonStatDao {
    @Upsert
    fun upsert(pokemonStatEntity: PokemonStatEntity)

    @Upsert
    fun insertBulk(list: List<PokemonStatEntity>)

    @Transaction
    @Query("SELECT * FROM pokemon_stat WHERE pokemon_id LIKE :pokemonId")
    fun getStatsOfPokemon(pokemonId: Int): List<PokemonStatEntity>
}