package com.oscar.pokedex.data.sources.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity

const val DEFAULT_LIMIT = 51

@Dao
interface PokemonDao {
    @Query("SELECT * FROM pokemon")
    fun getAll(): List<PokemonEntity>

    @Query("SELECT * FROM pokemon WHERE id LIKE :pokemonId LIMIT 1")
    fun findByID(pokemonId: Int): PokemonEntity

    @Query("SELECT * FROM pokemon WHERE name LIKE :name LIMIT 1")
    fun findByName(name: String): PokemonEntity

    @Query("SELECT * FROM pokemon LIMIT :limit OFFSET :offset")
    fun findPokemons(offset: Int = 0, limit: Int = DEFAULT_LIMIT): List<PokemonEntity>

    @Query("SELECT * FROM pokemon WHERE name LIKE :name LIMIT 1")
    fun findPokemon(name: String): PokemonEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(pokemonEntity: PokemonEntity)


    //fun delete(pokemonEntity: PokemonEntity)
}