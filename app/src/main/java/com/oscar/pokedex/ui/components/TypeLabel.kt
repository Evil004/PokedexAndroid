package com.oscar.pokedex.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.domain.models.PokemonType

@Composable
fun TypeLabel(type: PokemonType) {
    Column(
        Modifier
            .background(
                type.color,
                shape = RoundedCornerShape(40.dp)
            )
            .size(110.dp, 30.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = type.typeName)

    }
}
