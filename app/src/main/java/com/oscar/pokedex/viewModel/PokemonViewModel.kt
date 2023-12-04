package com.oscar.pokedex.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.oscar.pokedex.model.api.PokemonApi
import com.oscar.pokedex.model.data.Pokemon
import com.oscar.pokedex.model.data.PokemonList
import com.oscar.pokedex.model.parseJsonListToPokemon
import com.oscar.pokedex.model.parseJsonToPokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class PokemonViewModel(application: Application) : AndroidViewModel(application) {

    private var _pokemon: MutableLiveData<Pokemon> = MutableLiveData(null);

    val pokemon: LiveData<Pokemon> = _pokemon

    private var _pokemonName = ""

    private var _pokemonList:MutableLiveData<PokemonList> = MutableLiveData(null);
    val pokemonList: LiveData<PokemonList> = _pokemonList

    private var _searchInput: MutableLiveData<String> = MutableLiveData("");
    val searchInput: LiveData<String> = _searchInput

    init {

        getPokemonListData()
    }

    fun setPokemonAndUpate(pokemon: String){
        _pokemonName = pokemon
        getPokemonData()
    }

    fun getPokemonData() {

        viewModelScope.launch {
            val pokemon = withContext(Dispatchers.IO) {

                val pokemonJson = PokemonApi.retrofitService.getPokemonByName(_pokemonName)
                parseJsonToPokemon(pokemonJson)

            }

            _pokemon.postValue(pokemon)
        }
    }

    fun setSearchInput(searchInput:String){
        _searchInput.postValue(searchInput)
    }

    private fun getPokemonListData(){

        viewModelScope.launch {


            val pokemonList = withContext(Dispatchers.IO) {

                val pokemonListJson = PokemonApi.retrofitService.getPokemonList(limit=1017)
                parseJsonListToPokemon(pokemonListJson)

            }

            _pokemonList.postValue(pokemonList)
        }

    }
}

