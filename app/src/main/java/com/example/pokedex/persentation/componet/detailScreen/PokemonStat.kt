package com.example.pokedex.persentation.componet

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun PokemonStat(
    statName:String,
    statValue:Int,
    statMaxValue:Int,
    statColor: Color,
    height: Dp =28.dp,
    animDur:Int=1000,
    animDelay:Int=0
){
    var animationPlayed by remember {
        mutableStateOf(false)
    }
    val currPercent= animateFloatAsState(
        targetValue = if (animationPlayed){
            statValue/statMaxValue.toFloat()
        }else 0f,
        animationSpec = tween(animDur,animDelay)
    )
    LaunchedEffect(key1 = true){
        animationPlayed=true
    }
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(height)
        .clip(CircleShape)
        .background(
            if (isSystemInDarkTheme()) {
                Color.DarkGray
            } else {
                Color.LightGray
            }
        )) {
        Row(horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(currPercent.value)
                .clip(CircleShape)
                .background(statColor)
                .padding(horizontal = 8.dp))
        {
            Text(text = statName, fontWeight = FontWeight.Bold)
            Text(text = (currPercent.value*statMaxValue).toInt().toString(), fontWeight = FontWeight.Bold)

        }
    }
}