package com.oscar.pokedex.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oscar.pokedex.domain.models.Pokemon

/**
 * Composable for displaying the top bar of a Pokemon view.
 *
 * @param pokemon The Pokemon object being displayed.
 * @param backArrowClick Callback for handling the back arrow button click.
 */
@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PokemonViewTopBar(pokemon: Pokemon, backArrowClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = backArrowClick) {
                Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "", tint = Color.White)
            }
        },
        title = {
            Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text(text = "Pokedex", color = Color.White)

                val pokemonIdText = String.format("#%03d", pokemon.id)
                Text(text = pokemonIdText, color = Color.White)
            }
        }, colors = TopAppBarDefaults.largeTopAppBarColors(
            containerColor = pokemon.primaryType.color
        )

    )
}