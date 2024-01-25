package com.oscar.pokedex.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.oscar.pokedex.ui.components.LoadingPokeballComponent
import com.oscar.pokedex.ui.components.PokemonListCard
import com.oscar.pokedex.ui.viewmodels.PokemonListViewModel

@Composable
fun PokemonListView(viewModel: PokemonListViewModel, navController: NavHostController) {
    val pokemonListObserved by viewModel.pokemonList.observeAsState()
    if (pokemonListObserved != null) {

        Column(Modifier.fillMaxSize()) {

            val pokemonList by remember {
                mutableStateOf(pokemonListObserved!!)
            }

            val state = rememberLazyGridState()

            fun LazyGridState.isScrolledToEnd() =
                layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1

            if (state.isScrolledToEnd()) {
                viewModel.expandPokemonList()
            }


            LazyVerticalGrid(columns = GridCells.Fixed(3), state = state) {
                items(pokemonList.list.toList()) { pokemon ->
                    PokemonListCard(pokemon = pokemon, navController)
                }
                item(span = { GridItemSpan(3) }) {

                    Row(
                        Modifier.size(60.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        LoadingPokeballComponent(modifier = Modifier.size(40.dp))
                    }

                }
            }


        }
    }else{
        WelcomeView()
    }
}

