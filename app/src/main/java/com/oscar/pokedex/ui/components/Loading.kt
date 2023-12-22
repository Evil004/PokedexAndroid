package com.oscar.pokedex.ui.components

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * Composable that displays a loading indicator component.
 *
 * @param modifier The modifier for customizing the loading indicator.
 */
@Composable
fun LoadingComponent(modifier: Modifier){
    CircularProgressIndicator(
        modifier = modifier,
        color = MaterialTheme.colorScheme.secondary,

    )
}