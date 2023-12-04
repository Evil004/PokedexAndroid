package com.oscar.pokedex.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.SubcomposeAsyncImage
import com.oscar.pokedex.model.data.Pokemon
import com.oscar.pokedex.view.Components.LoadingComponent
import com.oscar.pokedex.viewModel.PokemonViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListView(viewModel: PokemonViewModel, navController: NavHostController) {
    val pokemonListObserved by viewModel.pokemonList.observeAsState()
    val searchInput by viewModel.searchInput.observeAsState()

    if (pokemonListObserved != null) {

        Column(Modifier.fillMaxSize()) {
            TextField(modifier = Modifier.fillMaxWidth(),value = searchInput ?: "", placeholder = { Text(
                text = "Buscar..."
            )}, onValueChange = { viewModel.setSearchInput(it) }, maxLines = 1, singleLine = true)


            val pokemonList by remember {
                mutableStateOf(pokemonListObserved!!)
            }


            LazyVerticalGrid(columns = GridCells.Fixed(3)) {
                items(pokemonList.list) { pokemon ->
                    PokemonListCard(pokemon = pokemon, navController,viewModel)
                }
            }
        }
    }
}

@Composable
fun PokemonListCard(pokemon: String, navController: NavHostController, viewModel: PokemonViewModel) {
    Card(
        Modifier
            .padding(10.dp)
            .height(150.dp)
            .clickable {

                viewModel.setPokemonAndUpate(pokemon)

                navController.navigate("PokemonView")

            }) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {


            Text(text = pokemon)
        }
    }
}
