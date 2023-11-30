package com.oscar.pokedex.viewModel

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.oscar.pokedex.model.PokemonApi
import com.oscar.pokedex.model.data.Pokemon
import com.oscar.pokedex.model.test
import kotlinx.coroutines.launch


class PokemonViewModel(application: Application): AndroidViewModel(application){

    private var _pokemon:MutableLiveData<Pokemon> = MutableLiveData(null);

    val pokemon: LiveData<Pokemon> = _pokemon

    init {
        getPokemonData()
    }

    private val context = getApplication<Application>().applicationContext

    private fun getPokemonData(){

        viewModelScope.launch {
            val pokemonJson = PokemonApi.retrofitService.getPokemonByName("oranguru")
            _pokemon.value = test(pokemonJson)
        }
    }
}

