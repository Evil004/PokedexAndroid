package com.oscar.pokedex.data.sources.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM pokemon WHERE id LIKE :pokemonId LIMIT 1")
    fun findByID(pokemonId: Int): PokemonEntity

    @Query("SELECT * FROM pokemon WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): PokemonEntity

    @Insert
    fun insertAll(vararg pokemonEntity: PokemonEntity)

    //fun delete(pokemonEntity: PokemonEntity)
}