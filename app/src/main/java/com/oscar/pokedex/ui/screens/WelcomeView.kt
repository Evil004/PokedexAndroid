package com.oscar.pokedex.ui.screens;

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.oscar.pokedex.R
import com.oscar.pokedex.ui.components.LoadingPokeballComponent

@Composable
fun WelcomeView() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(painter = painterResource(id = R.drawable.pokedex_logo), contentDescription = "", Modifier.size(300.dp))

        LoadingPokeballComponent(modifier = Modifier.size(100.dp))


        Spacer(modifier = Modifier.size(100.dp))
    }
}