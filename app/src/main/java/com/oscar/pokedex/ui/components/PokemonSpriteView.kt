package com.oscar.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.oscar.pokedex.domain.models.Pokemon

/**
 * Composable used to display the sprite view of a Pokemon.
 *
 * @param pokemon The Pokemon object containing sprite information.
 */
@Composable
fun PokemonSpriteView(pokemon: Pokemon) {
    Row(
        Modifier
            .fillMaxWidth()
            .height(230.dp)
            .background(
                pokemon.primaryType.color,
                shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
            )
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {


        SubcomposeAsyncImage(
            pokemon.spriteUrl,
            error = { LoadingComponent(Modifier.size(150.dp)) },
            loading = {
                LoadingComponent(Modifier.size(150.dp))
            },
            contentDescription = "",
            modifier = Modifier
                .padding(30.dp),
        )
    }
}

