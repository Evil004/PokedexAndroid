package com.oscar.pokedex.ui.components
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.data.models.entity.Pokemon

@Composable
fun HeightAndWeightComopnent(pokemon: Pokemon) {
    Row(Modifier.width(250.dp), horizontalArrangement = Arrangement.SpaceBetween) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(110.dp)
        ) {
            Text(text = "${pokemon.weight} KG")
            Text(text = "Weight")
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.width(110.dp)
        ) {
            Text(text = "${pokemon.height} M")
            Text(text = "Height")
        }
    }
}
