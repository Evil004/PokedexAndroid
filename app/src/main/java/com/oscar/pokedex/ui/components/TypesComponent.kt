package com.oscar.pokedex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.domain.models.Pokemon

/**
 * Component that displays the types of a Pokemon.
 * It arranges the primary and secondary types, if available, horizontally.
 *
 * @param pokemon The Pokemon object containing type information.
 */
@Composable
fun TypesComponent(pokemon: Pokemon) {
    val primaryType = pokemon.primaryType
    val secondaryType = pokemon.secondaryType

    Row(
        Modifier.width(250.dp),
        horizontalArrangement = if (secondaryType == null) Arrangement.Center else Arrangement.SpaceBetween
    ) {
        TypeLabel(primaryType)

        if (secondaryType != null) {
            TypeLabel(secondaryType)
        }
    }
}
