package com.oscar.pokedex.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
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
import com.oscar.pokedex.domain.models.PokemonListItem
import com.oscar.pokedex.ui.components.LoadingComponent
import com.oscar.pokedex.ui.viewmodels.PokemonListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonListView(viewModel: PokemonListViewModel, navController: NavHostController) {
    val pokemonListObserved by viewModel.pokemonList.observeAsState()
    val searchInput by viewModel.searchInput.observeAsState()

    if (pokemonListObserved != null) {

        Column(Modifier.fillMaxSize()) {
            TextField(
                modifier = Modifier.fillMaxWidth(),
                value = searchInput ?: "",
                placeholder = {
                    Text(
                        text = "Buscar..."
                    )
                },
                onValueChange = { viewModel.setSearchInput(it) },
                maxLines = 1,
                singleLine = true,
                leadingIcon = { Icon(Icons.Filled.Search, "") })


            val pokemonList by remember {
                mutableStateOf(pokemonListObserved!!)
            }

            val state = rememberLazyGridState()

            /*if (state.layoutInfo.totalItemsCount-17 <= state.firstVisibleItemIndex){
                viewModel.expandPokemonList()
            }*/


            var showButton by remember {
                mutableStateOf(true)
            }


            fun LazyGridState.isScrolledToEnd() = layoutInfo.visibleItemsInfo.lastOrNull()?.index == layoutInfo.totalItemsCount - 1


            if (state.isScrolledToEnd()){
                viewModel.expandPokemonList()
            }

            LazyVerticalGrid(columns = GridCells.Fixed(3), state = state) {
                items(pokemonList.list) { pokemon ->
                    PokemonListCard(pokemon = pokemon, navController)
                }
                item (span = { GridItemSpan(3) }) {

                    Row(Modifier.size(60.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){

                        LoadingComponent(modifier = Modifier.size(40.dp))
                    }

                }
            }


        }
    }
}

@Composable
fun PokemonListCard(
    pokemon: PokemonListItem,
    navController: NavHostController,
) {
    Card(
        Modifier
            .padding(10.dp)
            .height(150.dp)
            .clickable {


                navController.navigate("PokemonView/${pokemon.name}")

            }) {
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            if (pokemon.spriteUrl == null) {
                LoadingComponent(Modifier)

            } else {

                SubcomposeAsyncImage(
                    pokemon.spriteUrl,
                    loading = {
                        LoadingComponent(Modifier)
                    },
                    contentDescription = "",
                    modifier = Modifier
                        .padding(30.dp),
                )
            }

            Text(text = pokemon.name.replaceFirstChar { it.uppercase() })
        }
    }
}
