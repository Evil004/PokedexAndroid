package com.oscar.pokedex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModelStore
import com.oscar.pokedex.model.data.Pokemon
import com.oscar.pokedex.model.data.PokemonType
import com.oscar.pokedex.view.PokemonView
import com.oscar.pokedex.viewModel.PokemonViewModel
import com.oscar.pokedex.ui.theme.PokedexTheme
import com.oscar.pokedex.model.data.Stat
import com.oscar.pokedex.model.test

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme {
                val pokemonViewModel: PokemonViewModel by viewModels()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PokemonView(pokemonViewModel)

                }
            }
        }
    }
}

