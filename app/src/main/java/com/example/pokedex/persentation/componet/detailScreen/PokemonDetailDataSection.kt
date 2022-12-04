package com.example.pokedex.persentation.componet

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.pokedex.R
import kotlin.math.round

@Composable
fun PokemonDetailDataSection(
    pokemonWeight: Int,
    pokemonHeight:Int,
    sectionHeight: Dp =80.dp
){
    val pokemonWeightInKg= remember {
        round(pokemonWeight*100f) /1000f
    }
    val pokemonHeightInMeter= remember {
        round(pokemonHeight*100f) /1000f
    }
    Row(modifier = Modifier.fillMaxWidth()) {
        PokemonDetailDataItem(
            dataVale = pokemonWeightInKg,
            dataUnit = "kg",
            dataIcon = painterResource(id = R.drawable.ic_weight),
            modifier = Modifier.weight(1f))
        Spacer(
            modifier = Modifier
                .size(1.dp, sectionHeight)
                .background(Color.LightGray))
        PokemonDetailDataItem(
            dataVale = pokemonHeightInMeter,
            dataUnit = "m",
            dataIcon = painterResource(id = R.drawable.ic_height_24),
            modifier = Modifier.weight(1f))


    }

}

@Composable
fun PokemonDetailDataItem(
    dataVale:Float,
    dataUnit:String,
    dataIcon: Painter,
    modifier: Modifier = Modifier
){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier) {
        Icon(painter = dataIcon,
            contentDescription = null,
            tint = MaterialTheme.colors.onSurface)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "$dataVale$dataUnit",
            color = MaterialTheme.colors.onSurface)
    }

}