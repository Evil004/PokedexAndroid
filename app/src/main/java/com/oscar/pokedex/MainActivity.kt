package com.oscar.pokedex

import android.app.Application
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oscar.pokedex.data.repositories.PokemonApiRepositoryImpl
import com.oscar.pokedex.data.repositories.PokemonListApiRepositoryImpl
import com.oscar.pokedex.ui.screens.PokemonListView
import com.oscar.pokedex.ui.screens.PokemonView
import com.oscar.pokedex.ui.theme.PokedexTheme
import com.oscar.pokedex.ui.viewmodels.PokemonViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PokedexApp : Application() {
}

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemonViewModel =
                    PokemonViewModel(PokemonApiRepositoryImpl(), PokemonListApiRepositoryImpl())

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()

                    NavHost(navController = navController, startDestination = "PokemonList") {
                        composable("PokemonList") {
                            PokemonListView(
                                viewModel = pokemonViewModel,
                                navController
                            )
                        }
                        composable(
                            "PokemonView",
                        ) {

                            PokemonView(viewModel = pokemonViewModel, navController)
                        }
                    }

                }
            }
        }
    }
}
