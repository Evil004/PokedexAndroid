package com.oscar.pokedex.view.Components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.oscar.pokedex.model.data.Pokemon

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun PokemonViewTopBar(pokemon: Pokemon) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = { }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "", tint = Color.White)
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