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

/**
 * ViewModel responsible for managing a list of Pokemon.
 * Utilizes [GetPokemonListUseCase] to fetch the Pokemon list data.
 */
@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonListUseCase: GetPokemonListUseCase
) : ViewModel() {

    private var _pokemonList: MutableLiveData<PokemonList> = MutableLiveData(null);
    val pokemonList: LiveData<PokemonList> = _pokemonList

    private var _searchInput: MutableLiveData<String> = MutableLiveData("");
    val searchInput: LiveData<String> = _searchInput

    init {
        getPokemonListData()
    }

    /**
     * Updates the search input value and notifies observers of the change.
     * @param searchInput The new search input string.
     */
    fun setSearchInput(searchInput: String) {
        _searchInput.postValue(searchInput)
    }

    /**
     * Fetches the list of Pokemon data asynchronously and updates the LiveData with the fetched list.
     */
    private fun getPokemonListData() {

        viewModelScope.launch {

            val pokemonList = withContext(Dispatchers.IO) {

                val pokemonList = getPokemonListUseCase.getPokemonList()
                pokemonList

            }
            _pokemonList.postValue(pokemonList)
        }

    }
}
