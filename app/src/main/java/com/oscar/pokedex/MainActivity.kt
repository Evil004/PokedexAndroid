package com.oscar.pokedex

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscar.pokedex.ui.screens.PokemonListView
import com.oscar.pokedex.ui.screens.PokemonView
import com.oscar.pokedex.ui.theme.PokedexTheme
import com.oscar.pokedex.ui.viewmodels.PokemonListViewModel
import com.oscar.pokedex.ui.viewmodels.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokedexApp : Application()

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val pokemonViewModel: PokemonViewModel by viewModels()
    private val pokemonListViewModel: PokemonListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SetupNavigation()
                }
            }
        }
    }

    @Composable
    private fun SetupNavigation() {
        val navController = rememberNavController()


        NavHost(navController = navController, startDestination = "PokemonList") {
            composable("PokemonList") {
                PokemonListView(viewModel = pokemonListViewModel, navController)
            }
            composable("PokemonView/{pokemon}") {
                it.arguments?.getString("pokemon")?.let { pokemon ->

                        pokemonViewModel.updatePokemonAndFetchData(pokemon)

                        PokemonView(viewModel = pokemonViewModel, navController)

                }
            }
        }
    }
}
