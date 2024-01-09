package com.oscar.pokedex.ui.screens

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.oscar.pokedex.ui.components.HeightAndWeightComopnent
import com.oscar.pokedex.ui.components.LoadingComponent
import com.oscar.pokedex.ui.components.PokemonSpriteView
import com.oscar.pokedex.ui.components.PokemonViewTopBar
import com.oscar.pokedex.ui.components.StatsComponent
import com.oscar.pokedex.ui.components.TypesComponent
import com.oscar.pokedex.ui.viewmodels.PokemonViewModel

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonView(viewModel: PokemonViewModel, navHost: NavHostController) {

    val pokemon by viewModel.pokemon.observeAsState()

    if (pokemon == null) {
        LoadingComponent(Modifier)
    }
    
    if (pokemon != null) {

        Scaffold(
            topBar = {
                PokemonViewTopBar(pokemon!!) {navHost.navigate("PokemonList") }
            }
        ) {

            Column(
                Modifier
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .padding(top = it.calculateTopPadding()),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                
                PokemonSpriteView(pokemon!!)

                Spacer(modifier = Modifier.height(20.dp))

                Text(text = pokemon!!.speciesName.replaceFirstChar { it.uppercase() }, fontSize = 30.sp, fontWeight = FontWeight.Bold)

                TypesComponent(pokemon!!)

                Spacer(modifier = Modifier.height(20.dp))

                HeightAndWeightComopnent(pokemon!!)

                Spacer(modifier = Modifier.height(30.dp))

                StatsComponent(pokemon!!)

            }
        }
    }
}









