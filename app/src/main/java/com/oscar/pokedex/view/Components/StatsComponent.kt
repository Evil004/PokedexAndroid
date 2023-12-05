package com.oscar.pokedex.view.Components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.model.entity.Pokemon
import com.oscar.pokedex.model.entity.Stat

@Composable
fun StatsComponent(pokemon: Pokemon) {
    Text(text = "Base Stats", Modifier.padding(10.dp))

    Stat.values().forEach {
        val value = pokemon.statsMap.getValue(it)
        Spacer(modifier = Modifier.padding(5.dp))
        StatBar(stat = it, value)
    }

}