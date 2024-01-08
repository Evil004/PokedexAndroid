package com.oscar.pokedex.ui.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.pokedex.domain.models.Pokemon
import com.oscar.pokedex.domain.usecases.GetPokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
*   ViewModel responsible for managing Pokemon data.
*   Uses [GetPokemonUseCase] to fetch the Pokemon data.
*/
@HiltViewModel
class PokemonViewModel @Inject constructor(
    private val getPokemonUseCase: GetPokemonUseCase,
) : ViewModel() {


    private var _pokemon: MutableLiveData<Pokemon> = MutableLiveData(null);
    val pokemon: LiveData<Pokemon> = _pokemon

    private var _pokemonName = ""


    /**
     *  Updtates the pokemon name and triggers the call to fetch
     *  the data of the Pokemon.
     *  @param pokemonName the name of the Pokemon to fetch
     */
    fun setPokemonAndGetData(pokemonName: String) {
        _pokemonName = pokemonName
        getPokemonData()
    }

    /**
     * Fetches Pokémon data asynchronously and updates the LiveData with the fetched Pokémon.
     */
    private fun getPokemonData() {

        viewModelScope.launch {
            val pokemon = withContext(Dispatchers.IO) {
                val pokemon = getPokemonUseCase.getPokemon(_pokemonName)
                pokemon
            }


            _pokemon.postValue(pokemon)
        }
    }



}