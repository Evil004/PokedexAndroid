package com.oscar.pokedex.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.oscar.pokedex.domain.models.PokemonListItem

@Composable
fun PokemonListCard(
    pokemon: PokemonListItem,
    navController: NavHostController,
) {

    Card(
        Modifier
            .padding(10.dp)
            .height(150.dp)
            .clickable {
                navController.navigate("PokemonView/${pokemon.name}")
            }) {
        Column( Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            
            if (pokemon.spriteUrl == null) {
                LoadingComponent(Modifier)

            } else {
                SubcomposeAsyncImage(
                    pokemon.spriteUrl,
                    error = { LoadingComponent(Modifier) },
                    loading = {LoadingComponent(Modifier)},
                    contentDescription = "",
                    modifier = Modifier
                        .padding(30.dp),
                )
            }

            if (pokemon.speciesName != null) {
                Text(text = pokemon.speciesName!!.replaceFirstChar { it.uppercase() })

            }
        }
    }
}