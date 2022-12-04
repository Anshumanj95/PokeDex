package com.example.pokedex.persentation.pokemonList

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.pokedex.R
import com.example.pokedex.persentation.componet.ListScreen.PokemonList
import com.example.pokedex.persentation.componet.ListScreen.SearchBar

@Composable
fun PokemonListScreen(navController: NavController,
viewModel: PokemonListViewModel = hiltViewModel()) {
    
    Surface(
        color = MaterialTheme.colors.background, 
        modifier = Modifier.fillMaxSize()) 
    {
        Column {
            Spacer(modifier = Modifier.height(20.dp))
            Image(painter = painterResource(id = R.drawable.pokedex),
                contentDescription = "pokemon",
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.CenterHorizontally))
            SearchBar(hint = "Search..",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)){
                viewModel.searchPokemonList(it)
            }
            Spacer(modifier = Modifier.heightIn(16.dp))
            PokemonList(navController = navController)
        }
        
    }
}









