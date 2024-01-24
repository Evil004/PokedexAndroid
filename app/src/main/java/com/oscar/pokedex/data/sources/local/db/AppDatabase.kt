package com.oscar.pokedex.data.sources.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oscar.pokedex.data.sources.local.db.dao.PokemonDao
import com.oscar.pokedex.data.sources.local.db.dao.PokemonStatDao
import com.oscar.pokedex.data.sources.local.db.entity.PokemonEntity
import com.oscar.pokedex.data.sources.local.db.entity.PokemonStatEntity
import com.oscar.pokedex.data.sources.local.db.relations.PokemonWithStats

@Database(entities = [PokemonEntity::class, PokemonStatEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun pokemonDao(): PokemonDao

    abstract fun pokemonStatDao(): PokemonStatDao
}