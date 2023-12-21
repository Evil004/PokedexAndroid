package com.oscar.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.models.PokemonList
import com.oscar.pokedex.domain.repositories.PokemonListRepository
import com.oscar.pokedex.domain.repositories.PokemonRepository
import com.oscar.pokedex.domain.usecases.GetPokemonListUseCase
import com.oscar.pokedex.domain.usecases.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {


    private var _pokemon: MutableLiveData<Pokemon> = MutableLiveData(null);
    val pokemon: LiveData<Pokemon> = _pokemon

    private var _pokemonName = ""



    fun setPokemonAndUpate(pokemon: String) {
        _pokemonName = pokemon
        getPokemonData()
    }

    fun getPokemonData() {

        viewModelScope.launch {
            val pokemon = withContext(Dispatchers.IO) {

                val pokemon = getPokemonUseCase.getPokemon(_pokemonName)
                pokemon
            }


            _pokemon.postValue(pokemon)
        }
    }



}