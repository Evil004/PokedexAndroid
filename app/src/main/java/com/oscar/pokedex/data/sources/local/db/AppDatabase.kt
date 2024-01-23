package com.oscar.pokedex.data.sources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oscar.pokedex.data.sources.local.db.dao.PokemonDao
import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity

@Database(entities = [PokemonEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao
}