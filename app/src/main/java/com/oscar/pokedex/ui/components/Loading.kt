package com.oscar.pokedex.ui.components

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import com.oscar.pokedex.R

/**
 * Composable that displays a loading indicator component.
 *
 * @param modifier The modifier for customizing the loading indicator.
 */
@Composable
fun LoadingComponent(modifier: Modifier) {
    CircularProgressIndicator(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondary,

        )
}


@Composable
fun LoadingPokeballComponent(modifier: Modifier) {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0F,
        targetValue = 360F,
        animationSpec = infiniteRepeatable(
            animation = tween(700, easing = FastOutSlowInEasing)
        ), label = ""
    )
    Image(
        painter = painterResource(id = R.drawable.pokeball), contentDescription = "",
        modifier = modifier.rotate(angle)
    )
}