package com.oscar.pokedex

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemonViewModel: PokemonViewModel by viewModels()
                val pokemonListViewModel: PokemonListViewModel by viewModels()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "PokemonList") {
                        composable("PokemonList") {
                            PokemonListView(
                                viewModel = pokemonListViewModel,
                                navController
                            )
                        }
                        composable(
                            "PokemonView/{pokemon}",
                        ) {
                            val pokemon = it.arguments?.getString("pokemon")

                            pokemon?.let {
                                pokemonViewModel.setPokemonAndGetData(pokemon)
                                PokemonView(viewModel = pokemonViewModel, navController)

                            }

                        }
                    }

                }
            }
        }
    }
}
