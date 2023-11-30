package com.oscar.pokedex.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.oscar.pokedex.view.Components.PokemonViewTopBar
import com.oscar.pokedex.view.Components.HeightAndWeightComopnent
import com.oscar.pokedex.view.Components.PokemonSpriteView
import com.oscar.pokedex.view.Components.StatsComponent
import com.oscar.pokedex.view.Components.TypesComponent
import com.oscar.pokedex.viewModel.PokemonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(viewModel: PokemonViewModel) {
    val pokemonObserved by viewModel.pokemon.observeAsState()

    if (pokemonObserved != null) {

        val pokemon by remember {
            mutableStateOf(pokemonObserved!!)
        }

        Scaffold(
            topBar = {
                PokemonViewTopBar(pokemon)
            }
        ) {

            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                PokemonSpriteView(pokemon)

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = pokemon.name, fontSize = 30.sp, fontWeight = FontWeight.Bold)

                TypesComponent(pokemon)

                Spacer(modifier = Modifier.height(20.dp))

                HeightAndWeightComopnent(pokemon)

                Spacer(modifier = Modifier.height(30.dp))

                StatsComponent(pokemon)

            }
        }
    }
}









