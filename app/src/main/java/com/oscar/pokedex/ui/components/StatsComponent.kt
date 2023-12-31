package com.oscar.pokedex.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.Stat

/**
 * Component responsible for displaying the base statistics of a Pokemon.
 *
 * @param pokemon The Pokemon object containing base stats information.
 */
@Composable
fun StatsComponent(pokemon: Pokemon) {
    Text(text = "Base Stats", Modifier.padding(10.dp))

    Stat.entries.forEach {
        val value = pokemon.statsMap.getValue(it)
        Spacer(modifier = Modifier.padding(5.dp))
        StatBar(stat = it, value)
    }

}