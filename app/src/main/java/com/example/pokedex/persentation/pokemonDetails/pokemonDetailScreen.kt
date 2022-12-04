package com.example.pokedex.persentation.pokemonDetails

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.pokedex.R
import com.example.pokedex.data.remote.responses.Pokemon
import com.example.pokedex.data.remote.responses.Type
import com.example.pokedex.persentation.componet.PokemonDetailStateWrapper
import com.example.pokedex.persentation.componet.PokemonDetailTopSection
import com.example.pokedex.persentation.componet.PokemonStat
import com.example.pokedex.util.Resource
import com.example.pokedex.util.parseStatToAbbr
import com.example.pokedex.util.parseStatToColor
import com.example.pokedex.util.parseTypeToColor
import java.util.*
import kotlin.math.round

@Composable
fun PokemonDetailScreen(
    dominantColor:Color,
    pokemonName:String,
    navController: NavController,
    topPadding:Dp=20.dp,
    pokemonImageSize:Dp=200.dp,
    viewModel: PokemonViewModel = hiltViewModel()
){
    val pokemonInfo= produceState<Resource<Pokemon>>(initialValue = Resource.Loading()){
        value=viewModel.getPokemonInfo(pokemonName)
    }.value
    Box(modifier = Modifier
        .fillMaxSize()
        .background(dominantColor)
        .padding(bottom = 16.dp)) {
        PokemonDetailTopSection(
            navController = navController,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .align(
                    Alignment.TopCenter
                )
        )
        PokemonDetailStateWrapper(pokemonInfo = pokemonInfo,
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = topPadding + pokemonImageSize / 2f,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
            .shadow(10.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colors.surface)
            .padding(16.dp)
            .align(
                Alignment.BottomCenter
            ),
        loadingModifier = Modifier
            .size(100.dp)
            .align(Alignment.Center)
            .padding(
                top = topPadding + pokemonImageSize / 2f,
                start = 16.dp,
                end = 16.dp,
                bottom = 16.dp
            )
        )
        Box(contentAlignment = Alignment.TopCenter
            ,modifier = Modifier.fillMaxSize()) {
            if (pokemonInfo is Resource.Success){
                pokemonInfo.data?.id?.let {
                    val id = String.format("%03d",it)
                    val url =
                        "https://assets.pokemon.com/assets/cms2/img/pokedex/full/${id}.png"
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current).
                        data(url).crossfade(true).build(),
                        contentDescription = pokemonName, modifier = Modifier
                            .size(pokemonImageSize)
                            .offset(y = topPadding)
                    )
                }
            }
        }
    }
}












