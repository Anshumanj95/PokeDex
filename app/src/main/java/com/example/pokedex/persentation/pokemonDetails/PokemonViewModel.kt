package com.example.pokedex.persentation.pokemonDetails

import androidx.lifecycle.ViewModel
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.reposistory.PokemonRepository
import com.example.pokedex.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(
    val repository: PokemonRepository
):ViewModel() {

    suspend fun getPokemonInfo(pokemonName:String):Resource<Pokemon>{
        return repository.getPokeInfo(pokemonName)
    }
}