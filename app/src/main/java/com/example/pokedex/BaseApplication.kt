package com.example.pokedex

import android.app.Application
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.pokedex.persentation.pokemonList.PokemonListViewModel
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class BaseApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}