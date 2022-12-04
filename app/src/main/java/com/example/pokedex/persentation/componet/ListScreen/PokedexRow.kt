package com.example.pokedex.persentation.componet.ListScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedex.data.models.PokedexListEntry

@Composable
fun PokeDexRow(
    rowIndex:Int,
    entries:List<PokedexListEntry>,
    navController: NavController
){
    Column  {
        Row{
            PokedexEntry(entry = entries[rowIndex * 2], navController = navController, modifier = Modifier.weight(1f))
            Spacer(modifier = Modifier.width(16.dp))
            if (entries.size>=rowIndex*2+2){
                PokedexEntry(entry = entries[rowIndex * 2+1], navController = navController, modifier = Modifier.weight(1f))
            }
            else{
                Spacer(modifier = Modifier.weight(1f) )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))

    }

}